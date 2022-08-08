package com.enesergen.bookPortal.service.abstracts;

import com.enesergen.bookPortal.core.utilities.results.DataResult;
import com.enesergen.bookPortal.core.utilities.results.Result;
import com.enesergen.bookPortal.entities.concretes.Book;
import com.enesergen.bookPortal.entities.dtos.BookDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public interface BookService {
    Result save(BookDTO bookDTO);
    Result remove(long id);
    Result update(long id,BookDTO bookDTO);
    DataResult<Book>getOne(long id);
    DataResult<List<Book>>getAll();
}
