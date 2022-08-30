package com.enesergen.bookPortal.service.concretes;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.enesergen.bookPortal.core.utilities.results.*;
import com.enesergen.bookPortal.dal.abstratcs.BookDAL;
import com.enesergen.bookPortal.dal.abstratcs.RoleDAL;
import com.enesergen.bookPortal.dal.abstratcs.UserDAL;
import com.enesergen.bookPortal.entities.concretes.Book;
import com.enesergen.bookPortal.entities.concretes.Role;
import com.enesergen.bookPortal.entities.concretes.User;
import com.enesergen.bookPortal.entities.dtos.BookDTO;
import com.enesergen.bookPortal.entities.dtos.UserDTO;
import com.enesergen.bookPortal.service.abstracts.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.MimeTypeUtils;

import javax.activation.MimeType;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

import static java.util.Arrays.stream;
import static org.springframework.http.HttpHeaders.AUTHORIZATION;
import static org.springframework.http.HttpStatus.FORBIDDEN;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Service
public class UserManager implements UserService, UserDetailsService {
    private final UserDAL userDAL;
    private final RoleDAL roleDAL;
    private final BookDAL bookDAL;
    private final PasswordEncoder encoder;

    @Override
    public void refreshToken(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String authorizationHeader = request.getHeader(AUTHORIZATION);
        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
            try {
                String refresh_token = authorizationHeader.substring("Bearer ".length());
                Algorithm algorithm = Algorithm.HMAC256("secret".getBytes());
                JWTVerifier verifier = JWT.require(algorithm).build();
                DecodedJWT decodedJWT = verifier.verify(refresh_token);
                String username = decodedJWT.getSubject();
                User user = this.userDAL.getByUsername(username);
                String access_token = JWT.create()
                        .withSubject(user.getUsername())
                        .withExpiresAt(new Date(System.currentTimeMillis() + 20 * 60 * 1000))
                        .withIssuer(request.getRequestURL().toString())
                        .withClaim("roles", user.getRoles().stream().map(Role::getName).collect(Collectors.toList()))
                        .sign(algorithm);
                Map<String, String> tokens = new HashMap<>();
                tokens.put("access_token", access_token);
                tokens.put("refresh_token", refresh_token);
                response.setContentType(MediaType.APPLICATION_JSON_VALUE);
                new ObjectMapper().writeValue(response.getOutputStream(), tokens);
            } catch (Exception exception) {
                response.setStatus(FORBIDDEN.value());
                Map<String, String> errors = new HashMap<>();
                errors.put("error_message", exception.getMessage());
                response.setContentType(MimeTypeUtils.APPLICATION_JSON_VALUE);
                new ObjectMapper().writeValue(response.getOutputStream(), errors);
            }
        } else {
            throw new RuntimeException("Refresh token is missing");
        }
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        var user = this.userDAL.getByUsername(username);
        if (user == null) {
            LOGGER.error("User not found.");
            throw new UsernameNotFoundException("user not found");
        } else {
            LOGGER.info("User found.Username:{}", username);
        }
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        user.getRoles().forEach(role -> authorities.add(new SimpleGrantedAuthority(role.getName())));
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), authorities);
    }

    public UserManager(UserDAL userDAL, RoleDAL roleDAL, BookDAL bookDAL, PasswordEncoder encoder) {
        this.userDAL = userDAL;
        this.roleDAL = roleDAL;
        this.bookDAL = bookDAL;
        this.encoder = encoder;
    }

    private static final Logger LOGGER = LoggerFactory.getLogger(UserManager.class);

    @Override
    public Result save(UserDTO userDTO) {
        if (!this.userDAL.existsByUsername(userDTO.getUsername())) {
            User user = new User();
            user.setUsername(userDTO.getUsername());
            user.setPassword(encoder.encode(userDTO.getPassword()));
            user.setBooks(null);
            user.setFavoriteBooks(null);
            var role = this.roleDAL.getByName("ROLE_USER");
            var set = new HashSet<Role>();
            set.add(role);
            user.setRoles(set);
            user = this.userDAL.save(user);
            if (this.userDAL.existsById(user.getId())) {//password logger içinde olmamalı
                LOGGER.info("Operation:Create User; Username:{} - Password:{}", user.getUsername(), user.getPassword());
                return new SuccessResult("User adding operation is successful.");
            } else {
                return new ErrorResult("The user could not be added.");
            }
        } else {
            return new ErrorResult("The username has been used");
        }

    }

    @Override
    public Result remove(UserDTO userDTO) {
        if (this.userDAL.existsByUsername(userDTO.getUsername())) {
            User user = this.userDAL.getByUsername(userDTO.getUsername());
            user.setActive(false);
            user = this.userDAL.save(user);
            if (!user.isActive()) {
                LOGGER.info("User's Active Attribute is changed to FALSE");
                return new SuccessResult("User removing operation is successful.");
            } else {
                return new ErrorResult("User could not be deleted");
            }
        } else {
            return new ErrorResult("User could not be found.");
        }
    }

    @Override
    public Result update(UserDTO userDTO) {
        if (this.userDAL.existsByUsername(userDTO.getUsername())) {
            User user = this.userDAL.getByUsername(userDTO.getUsername());
            user.setPassword(encoder.encode(userDTO.getPassword()));
            this.userDAL.save(user);
            LOGGER.info("User password changed, new password:{}", user.getPassword());

            return new SuccessResult("Password changing is successful");
        } else {
            return new ErrorResult("User could not be found");
        }
    }

    @Override
    public DataResult<User> getOne(long id) {
        Optional<User> user = this.userDAL.findById(id);
        if (user.isPresent()) {
            LOGGER.info("Get One User method called.Username:{}", user.get().getUsername());
            return new SuccessDataResult<>(user.get(), "Get one user operation is successful");
        } else {
            return new ErrorDataResult<>("User could not be found.");
        }

    }

    @Override
    public DataResult<List<User>> getAll() {
        List<User> users = this.userDAL.findAll();
        if (!users.isEmpty()) {
            LOGGER.info("Get All User method called.");
            return new SuccessDataResult<>(users, "Get users operation is successful");
        } else {
            return new ErrorDataResult<>("Users  could not be found");
        }

    }

    @Override
    public Result addBook(String username, BookDTO bookDTO) {
        var user = this.userDAL.getByUsername(username);
        if (user!=null) {
            var book = this.bookDAL.getByIsbn(bookDTO.getIsbn());
            if (book != null) {
                user.addBook(book);
                this.userDAL.save(user);
                LOGGER.info("Book added book list.Book name:{}", book.getName());
                return new SuccessResult("Book added user's book list.");
            } else {
                return new ErrorResult("Book could not be found.");
            }
        } else {
            return new ErrorResult("User could not be found.");
        }
    }

    @Override
    public DataResult<Set<Book>> listMyBooks(String username) {
        var user = this.userDAL.getByUsername(username);
        if (user!=null) {
            LOGGER.info("User called listMyBooks method.Username:{}", user.getUsername());
            return new SuccessDataResult<>(user.myBooksList(), "Get book list operation is successful.");
        } else {
            return new ErrorDataResult<>("User could not be found.");
        }
    }

    @Override
    public Result removeBook(String username, BookDTO bookDTO) {
        var user = this.userDAL.getByUsername(username);
        if (user!=null) {
            var book = this.bookDAL.getByIsbn(bookDTO.getIsbn());
            if (book != null && user.myBooksList().contains(book)) {
                user.myBooksList().remove(book);
                this.userDAL.save(user);
                LOGGER.info("Book removed user's book list.Username: {} - Book name:{}", user.getUsername(), book.getName());
                return new SuccessResult("removing book from book list  is successful.");
            } else {
                return new
                        ErrorResult("Book is could not found or user has not this book.");
            }
        } else {
            return new
                    ErrorResult("User is could not found.");
        }
    }

    @Override
    public Result addFavoriteBook(String username, BookDTO bookDTO) {
        var user = this.userDAL.getByUsername(username);
        if (user!=null) {
            var book = this.bookDAL.getByIsbn(bookDTO.getIsbn());
            if (book != null) {
                user.addFavoriteBook(book);
                this.userDAL.save(user);
                LOGGER.info("Book added favorite book list.Book name:{}", book.getName());
                return new SuccessResult("Book added user's  favorite book list.");
            } else {
                return new ErrorResult("Book could not be found.");
            }
        } else {
            return new ErrorResult("User could not be found.");
        }
    }

    @Override
    public DataResult<Set<Book>> listMyFavoriteBooks(String username) {
        var user = this.userDAL.getByUsername(username);
        if (user!=null) {
            LOGGER.info("User called listMyFavoriteBooks method.Username:{}", user.getUsername());
            return new SuccessDataResult<>(user.myFavoriteBooksList(), "Get favorite book list operation is successful.");
        } else {
            return new ErrorDataResult<>("User could not be found.");
        }
    }

    @Override
    public Result removeFavoriteBook(String username, BookDTO bookDTO) {
        var user = this.userDAL.getByUsername(username);
        if (user!=null) {
            var book = this.bookDAL.getByIsbn(bookDTO.getIsbn());
            if (book != null && user.myFavoriteBooksList().contains(book)) {
                user.myFavoriteBooksList().remove(book);
                this.userDAL.save(user);
                LOGGER.info("Book removed user's favorite book list.Username: {} - Book name:{}", user.getUsername(), book.getName());
                return new SuccessResult("removing book from favorite book list  is successful.");
            } else {
                return new
                        ErrorResult("Book is could not found or user has not this book.");
            }
        } else {
            return new
                    ErrorResult("User is could not found.");
        }
    }


}
