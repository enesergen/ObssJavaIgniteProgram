package com.enesergen.bookPortal.service.concretes;

import com.enesergen.bookPortal.core.utilities.results.*;
import com.enesergen.bookPortal.dal.abstratcs.BookDAL;
import com.enesergen.bookPortal.entities.concretes.Book;
import com.enesergen.bookPortal.entities.dtos.BookDTO;
import com.enesergen.bookPortal.service.abstracts.BookService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class BookManager implements BookService {

    public BookManager(BookDAL bookDAL) {
        this.bookDAL = bookDAL;
    }

    private final BookDAL bookDAL;

    @Override
    public Result save(BookDTO bookDTO) {
        Book book = new Book();
        book.setIsbn(bookDTO.getIsbn());
        book.setName(bookDTO.getName());
        book.setPageSize(bookDTO.getPageSize());
        book.setImageUrl(bookDTO.getImageUrl());
        book.setDescription(bookDTO.getDescription());
        book.setAuthor(book.getAuthor());
        book.setCategory(book.getCategory());
        book = this.bookDAL.save(book);
        if (this.bookDAL.existsById(book.getId())) {
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
            return new SuccessResult("Remove operation is successful.");
        } else {
            return new ErrorResult("Book is not found");
        }
    }

    @Override
    public Result update(BookDTO bookDTO) {
        Book book = this.bookDAL.getByIsbn(bookDTO.getIsbn());
        book.setName(bookDTO.getName());
        book.setIsbn(bookDTO.getIsbn());
        book.setPageSize(bookDTO.getPageSize());
        book.setImageUrl(bookDTO.getImageUrl());
        book.setDescription(bookDTO.getDescription());
        book.setAuthor(book.getAuthor());
        book.setCategory(book.getCategory());
        book = this.bookDAL.save(book);
        if (this.bookDAL.existsById(book.getId())) {
            return new SuccessResult("Update operation is successful.");
        } else {
            return new ErrorResult("Update operation is not successful.");
        }
    }

    @Override
    public DataResult<Book> getOne(long id) {
        Optional<Book> book = this.bookDAL.findById(id);
        if (book.isPresent()) {
            return new SuccessDataResult<>(book.get(), "Book was found.");
        } else {
            return new ErrorDataResult<>("Book was not found.");
        }
    }

    @Override
    public DataResult<List<Book>> getAll() {
        List<Book>books=this.bookDAL.findAll();
        if(!books.isEmpty()){
            return new SuccessDataResult<>(books,"Books were found.");
        }else{
            return new ErrorDataResult<>("Books were not found.");
        }
    }
}
