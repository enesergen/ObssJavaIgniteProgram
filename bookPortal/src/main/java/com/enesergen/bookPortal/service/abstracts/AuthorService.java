package com.enesergen.bookPortal.service.abstracts;

import com.enesergen.bookPortal.core.utilities.results.DataResult;
import com.enesergen.bookPortal.core.utilities.results.Result;
import com.enesergen.bookPortal.entities.concretes.Author;
import com.enesergen.bookPortal.entities.dtos.AuthorDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface AuthorService {
    Result save(AuthorDTO authorDTO);
    Result remove(long id);
    Result update(long id,AuthorDTO authorDTO);
    DataResult<Author>getOne(long id);
    DataResult<List<Author>>getAll();
}
