package com.enesergen.bookPortal.controllers.abstracts;

import com.enesergen.bookPortal.core.utilities.results.DataResult;
import com.enesergen.bookPortal.core.utilities.results.Result;
import com.enesergen.bookPortal.entities.concretes.Author;
import com.enesergen.bookPortal.entities.dtos.AuthorDTO;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public interface AbstractAuthorController {
    Result createAuthor(AuthorDTO authorDTO);

    Result removeAuthor(long id);

    Result updateAuthor(long id, AuthorDTO authorDTO);

    DataResult<Author> getOneAuthor(long id);

    DataResult<List<Author>> getAllAuthors();
}
