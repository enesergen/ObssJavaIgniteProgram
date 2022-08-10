package com.enesergen.bookPortal.service.concretes;

import com.enesergen.bookPortal.core.utilities.configurations.secuirties.MyUserDetails;
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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class UserManager implements UserService, UserDetailsService {
    private final UserDAL userDAL;
    private final RoleDAL roleDAL;
    private final BookDAL bookDAL;
    private final PasswordEncoder encoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        var user = this.userDAL.getByUsername(username);
        return new MyUserDetails(user);
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
            if (this.userDAL.existsById(user.getId())) {
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
    public Result addBook(long id, BookDTO bookDTO) {
        var user = this.userDAL.findById(id);
        if (user.isPresent()) {
            var book = this.bookDAL.getByIsbn(bookDTO.getIsbn());
            if (book != null) {
                user.get().addBook(book);
                this.userDAL.save(user.get());
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
    public DataResult<Set<Book>> listMyBooks(long id) {
        var user = this.userDAL.findById(id);
        if (user.isPresent()) {
            LOGGER.info("User called listMyBooks method.Username:{}", user.get().getUsername());
            return new SuccessDataResult<>(user.get().myBooksList(), "Get book list operation is successful.");
        } else {
            return new ErrorDataResult<>("User could not be found.");
        }
    }

    @Override
    public Result removeBook(long id, BookDTO bookDTO) {
        var user = this.userDAL.findById(id);
        if (user.isPresent()) {
            var book = this.bookDAL.getByIsbn(bookDTO.getIsbn());
            if (book != null && user.get().myBooksList().contains(book)) {
                user.get().myBooksList().remove(book);
                this.userDAL.save(user.get());
                LOGGER.info("Book removed user's book list.Username: {} - Book name:{}", user.get().getUsername(), book.getName());
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
    public Result addFavoriteBook(long id, BookDTO bookDTO) {
        var user = this.userDAL.findById(id);
        if (user.isPresent()) {
            var book = this.bookDAL.getByIsbn(bookDTO.getIsbn());
            if (book != null) {
                user.get().addFavoriteBook(book);
                this.userDAL.save(user.get());
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
    public DataResult<Set<Book>> listMyFavoriteBooks(long id) {
        var user = this.userDAL.findById(id);
        if (user.isPresent()) {
            LOGGER.info("User called listMyFavoriteBooks method.Username:{}", user.get().getUsername());
            return new SuccessDataResult<>(user.get().myFavoriteBooksList(), "Get favorite book list operation is successful.");
        } else {
            return new ErrorDataResult<>("User could not be found.");
        }
    }

    @Override
    public Result removeFavoriteBook(long id, BookDTO bookDTO) {
        var user = this.userDAL.findById(id);
        if (user.isPresent()) {
            var book = this.bookDAL.getByIsbn(bookDTO.getIsbn());
            if (book != null && user.get().myFavoriteBooksList().contains(book)) {
                user.get().myFavoriteBooksList().remove(book);
                this.userDAL.save(user.get());
                LOGGER.info("Book removed user's favorite book list.Username: {} - Book name:{}", user.get().getUsername(), book.getName());
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
