package com.enesergen.bookPortal.controllers.abstracts;

import com.enesergen.bookPortal.core.utilities.results.DataResult;
import com.enesergen.bookPortal.core.utilities.results.Result;
import com.enesergen.bookPortal.entities.concretes.Book;
import com.enesergen.bookPortal.entities.dtos.BookDTO;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
public interface AbstractUserBookController {
    Result addBook(long id,BookDTO bookDTO);
    DataResult<Set<Book>> listMyBook(long id);
    Result removeBook(long id,BookDTO bookDTO);

    Result addFavoriteBook(long id,BookDTO bookDTO);
    DataResult<Set<Book>> listMyFavoriteBook(long id);
    Result removeFavoriteBook(long id,BookDTO bookDTO);
}
