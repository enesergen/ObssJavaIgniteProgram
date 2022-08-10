package com.enesergen.bookPortal.service.abstracts;

import com.enesergen.bookPortal.core.utilities.results.DataResult;
import com.enesergen.bookPortal.core.utilities.results.Result;
import com.enesergen.bookPortal.entities.concretes.Book;
import com.enesergen.bookPortal.entities.concretes.User;
import com.enesergen.bookPortal.entities.dtos.BookDTO;
import com.enesergen.bookPortal.entities.dtos.UserDTO;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Set;

@Service
public interface UserService extends UserDetailsService {
    Result save(UserDTO userDTO);
    Result remove(UserDTO userDTO);
    Result update(UserDTO userDTO);
    DataResult<User> getOne(long id);
    DataResult<List<User>>getAll();

    Result addBook(long id,BookDTO bookDTO);
    DataResult<Set<Book>> listMyBooks(long id);
    Result removeBook(long id,BookDTO bookDTO);

    Result addFavoriteBook(long id,BookDTO bookDTO);
    DataResult<Set<Book>> listMyFavoriteBooks(long id);
    Result removeFavoriteBook(long id,BookDTO bookDTO);

    void refreshToken(HttpServletRequest request, HttpServletResponse response) throws IOException;
}
