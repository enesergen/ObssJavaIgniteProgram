package com.enesergen.bookPortal.controllers.abstracts;

import com.enesergen.bookPortal.core.utilities.results.DataResult;
import com.enesergen.bookPortal.core.utilities.results.Result;
import com.enesergen.bookPortal.entities.concretes.Book;
import com.enesergen.bookPortal.entities.dtos.BookDTO;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public interface AbstractBookController {
    Result createBook(BookDTO bookDTO);

    Result removeBook(long id);

    Result updateBook(long id, BookDTO bookDTO);

    DataResult<Book> getOneBook(long id);

    DataResult<List<Book>> getAllBooks();
}
