package com.enesergen.bookPortal.controllers.abstracts;

import com.enesergen.bookPortal.core.utilities.results.DataResult;
import com.enesergen.bookPortal.core.utilities.results.Result;
import com.enesergen.bookPortal.entities.concretes.Book;
import com.enesergen.bookPortal.entities.dtos.BookDTO;
import com.enesergen.bookPortal.entities.dtos.UserDTO;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
public interface AbstractUserBookController {
    Result addBook(String username,BookDTO bookDTO);
    DataResult<Set<Book>> listMyBook(String username);
    Result removeBook(String username,BookDTO bookDTO);

    Result addFavoriteBook(String username,BookDTO bookDTO);
    DataResult<Set<Book>> listMyFavoriteBook(String username);
    Result removeFavoriteBook(String username,BookDTO bookDTO);
    Result updateUSer(UserDTO userDTO);
}
