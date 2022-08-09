package com.enesergen.bookPortal.service.concretes;

import com.enesergen.bookPortal.core.utilities.results.*;
import com.enesergen.bookPortal.dal.abstratcs.AuthorDAL;
import com.enesergen.bookPortal.dal.abstratcs.BookDAL;
import com.enesergen.bookPortal.entities.concretes.Book;
import com.enesergen.bookPortal.entities.dtos.BookDTO;
import com.enesergen.bookPortal.service.abstracts.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookManager implements BookService {

    public BookManager(BookDAL bookDAL, AuthorDAL authorDAL) {
        this.bookDAL = bookDAL;
        this.authorDAL = authorDAL;
    }

    private static final Logger LOGGER = LoggerFactory.getLogger(BookManager.class);

    private final BookDAL bookDAL;
    private final AuthorDAL authorDAL;

    @Override
    public Result save(BookDTO bookDTO) {
        Book book = new Book();
        book.setIsbn(bookDTO.getIsbn());
        book.setName(bookDTO.getName());
        book.setPageSize(bookDTO.getPageSize());
        book.setImageUrl(bookDTO.getImageUrl());
        book.setDescription(bookDTO.getDescription());
        var author=this.authorDAL.findById(bookDTO.getAuthorId());
        if(author.isPresent()){
            book.setAuthor(author.get());
        }else{
            book.setAuthor(null);
        }
        book = this.bookDAL.save(book);
        if (this.bookDAL.existsById(book.getId())) {
            LOGGER.info("Book saved.Book Name:{}", bookDTO.getName());
            return new SuccessResult("Book adding operation is successful.");
        } else {
            return new ErrorResult("Book adding operation is not successful.");
        }
    }

    @Override
    public Result remove(long id) {
        Optional<Book> book = this.bookDAL.findById(id);
        if (book.isPresent()) {
            book.get().setActive(false);
            this.bookDAL.save(book.get());
            LOGGER.info("Book active status changed to FALSE.Book Name:{}", book.get().getName());

            return new SuccessResult("Remove operation is successful.");
        } else {
            return new ErrorResult("Book is not found");
        }
    }

    @Override
    public Result update(long id, BookDTO bookDTO) {
        var book = this.bookDAL.findById(id);
        if (book.isPresent()) {
            book.get().setName(bookDTO.getName());
            book.get().setIsbn(bookDTO.getIsbn());
            book.get().setPageSize(bookDTO.getPageSize());
            book.get().setImageUrl(bookDTO.getImageUrl());
            book.get().setDescription(bookDTO.getDescription());
            var author=this.authorDAL.findById(bookDTO.getAuthorId());
            if(author.isPresent()){
                book.get().setAuthor(author.get());
            }else{
                book.get().setAuthor(null);
            }


            this.bookDAL.save(book.get());
            LOGGER.info("Book updated.Book Name:{}", book.get().getName());

            return new SuccessResult("Update operation is successful.");
        } else {
            return new ErrorResult("Update operation is not successful.");
        }
    }

    @Override
    public DataResult<Book> getOne(long id) {
        Optional<Book> book = this.bookDAL.findById(id);
        if (book.isPresent()) {
            LOGGER.info("Get one book method called.Book Name:{}", book.get().getName());

            return new SuccessDataResult<>(book.get(), "Book was found.");
        } else {
            return new ErrorDataResult<>("Book was not found.");
        }
    }

    @Override
    public DataResult<List<Book>> getAll() {
        List<Book> books = this.bookDAL.findAll();
        if (!books.isEmpty()) {
            LOGGER.info("Get all books method called.");

            return new SuccessDataResult<>(books, "Books were found.");
        } else {
            return new ErrorDataResult<>("Books were not found.");
        }
    }
}
