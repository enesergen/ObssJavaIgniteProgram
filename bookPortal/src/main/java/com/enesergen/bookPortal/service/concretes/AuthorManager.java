package com.enesergen.bookPortal.service.concretes;

import com.enesergen.bookPortal.core.utilities.results.*;
import com.enesergen.bookPortal.dal.abstratcs.AuthorDAL;
import com.enesergen.bookPortal.entities.concretes.Author;
import com.enesergen.bookPortal.entities.dtos.AuthorDTO;
import com.enesergen.bookPortal.service.abstracts.AuthorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorManager implements AuthorService {
    private final AuthorDAL authorDAL;
    private static final Logger LOGGER = LoggerFactory.getLogger(AuthorManager.class);

    public AuthorManager(AuthorDAL authorDAL) {
        this.authorDAL = authorDAL;
    }

    @Override
    public Result save(AuthorDTO authorDTO) {
        Author author = new Author();
        author.setName(authorDTO.getName());
        author.setBirthYear(authorDTO.getBirthYear());
        author.setBirthPlace(authorDTO.getBirthPlace());
        author.setBooks(null);
        var result = this.authorDAL.save(author);

        if (this.authorDAL.existsById(result.getId())) {
            LOGGER.info("Author saved.Author name:{}",authorDTO.getName());

            return new SuccessResult("Author was added successfully.");
        } else {
            return new ErrorResult("Author adding operation is not successful.");
        }
    }

    @Override
    public Result remove(long id) {
        Optional<Author> author = this.authorDAL.findById(id);
        if (author.isPresent()) {
            author.get().setActive(false);
            this.authorDAL.save(author.get());
            LOGGER.info("Author active status changed to FALSE.Author name:{}",author.get().getName());
            return new SuccessResult("Author was removed");
        } else {
            return new ErrorResult("Author was not found.");
        }
    }

    @Override
    public Result update(long id, AuthorDTO authorDTO) {
        Optional<Author> author = this.authorDAL.findById(id);
        if (author.isPresent()) {
            author.get().setName(authorDTO.getName());
            author.get().setBirthYear(authorDTO.getBirthYear());
            author.get().setBirthPlace(authorDTO.getBirthPlace());
            this.authorDAL.save(author.get());
            LOGGER.info("Author updated.Author name:{}",author.get().getName());

            return new SuccessResult("Author was updated.");
        } else {
            return new ErrorResult("Author was not found.");
        }

    }

    @Override
    public DataResult<Author> getOne(long id) {
        var author = this.authorDAL.findById(id);
        if (author.isPresent()) {
            LOGGER.info("Get one author method called.");

            return new SuccessDataResult<>(author.get(), "Operation is successful.");
        } else {
            return new ErrorDataResult<>("Author was not found");
        }

    }

    @Override
    public DataResult<List<Author>> getAll() {
        var authors = this.authorDAL.findAll();
        if (!authors.isEmpty()) {
            LOGGER.info("Get all authors method called.");

            return new SuccessDataResult<>(authors, "Operation is successful.");
        } else {
            return new ErrorDataResult<>("Author list is empty");

        }

    }
}
