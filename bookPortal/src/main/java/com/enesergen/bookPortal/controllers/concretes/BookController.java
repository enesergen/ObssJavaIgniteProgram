package com.enesergen.bookPortal.controllers.concretes;

import com.enesergen.bookPortal.controllers.abstracts.AbstractBookController;
import com.enesergen.bookPortal.core.utilities.results.DataResult;
import com.enesergen.bookPortal.core.utilities.results.Result;
import com.enesergen.bookPortal.entities.concretes.Book;
import com.enesergen.bookPortal.entities.dtos.BookDTO;
import com.enesergen.bookPortal.service.abstracts.BookService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController implements AbstractBookController {
    private final BookService bookService;

    public BookController(@Valid @RequestBody BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping("")
    @Override
    public Result createBook(@Valid @RequestBody BookDTO bookDTO) {
        return this.bookService.save(bookDTO);
    }

    @DeleteMapping("")
    @Override
    public Result removeBook(@PathVariable long id) {
        return this.bookService.remove(id);
    }

    @PutMapping("/{id}")
    @Override
    public Result updateBook(@PathVariable long id
            , @Valid @RequestBody BookDTO bookDTO) {
        return this.bookService.update(id, bookDTO);
    }


    @GetMapping("/{id}")
    @Override
    public DataResult<Book> getOneBook(@PathVariable long id) {
        return this.bookService.getOne(id);
    }

    @GetMapping("")
    @Override
    public DataResult<List<Book>> getAllBooks() {
        return this.bookService.getAll();
    }
}
