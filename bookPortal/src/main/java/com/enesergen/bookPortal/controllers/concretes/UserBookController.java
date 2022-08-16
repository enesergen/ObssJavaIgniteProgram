package com.enesergen.bookPortal.controllers.concretes;

import com.enesergen.bookPortal.controllers.abstracts.AbstractUserBookController;
import com.enesergen.bookPortal.core.utilities.results.DataResult;
import com.enesergen.bookPortal.core.utilities.results.Result;
import com.enesergen.bookPortal.entities.concretes.Book;
import com.enesergen.bookPortal.entities.dtos.BookDTO;
import com.enesergen.bookPortal.entities.dtos.UserDTO;
import com.enesergen.bookPortal.service.abstracts.BookService;
import com.enesergen.bookPortal.service.abstracts.UserService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/userbooks")
public class UserBookController implements AbstractUserBookController {
    private final UserService userService;
    private final BookService bookService;

    public UserBookController(UserService userService, BookService bookService) {
        this.userService = userService;
        this.bookService = bookService;
    }

    @GetMapping("/books")
    public DataResult<List<Book>> getAllActiveBooks(){
        return this.bookService.getAllActiveBooks();
    }
    @GetMapping("/{search}")
    public DataResult<List<Book>> searchBooks(@PathVariable String search){
        return this.bookService.searchBooks(search);
    }

    @PostMapping("/books/{id}")
    @Override
    public Result addBook(@PathVariable long id, @RequestBody BookDTO bookDTO) {
        return this.userService.addBook(id,bookDTO);
    }

    @GetMapping("/books/{id}")
    @Override
    public DataResult<Set<Book>> listMyBook(@PathVariable long id) {
        return this.userService.listMyBooks(id);
    }

    @DeleteMapping("/books/{id}")
    @Override
    public Result removeBook(@PathVariable long id, @RequestBody BookDTO bookDTO) {
        return this.userService.removeBook(id,bookDTO);
    }

    @PostMapping("/fbooks/{id}")
    @Override
    public Result addFavoriteBook(@PathVariable long id, @RequestBody BookDTO bookDTO) {
        return this.userService.addFavoriteBook(id,bookDTO);
    }

    @GetMapping("/fbooks/{id}")
    @Override
    public DataResult<Set<Book>> listMyFavoriteBook(@PathVariable long id) {
        return this.userService.listMyFavoriteBooks(id);
    }

    @DeleteMapping("/fbooks/{id}")
    @Override
    public Result removeFavoriteBook(@PathVariable long id, @RequestBody BookDTO bookDTO) {
        return this.userService.removeFavoriteBook(id,bookDTO);
    }
    @PutMapping("")
    @Override
    public Result updateUSer(@Valid @RequestBody UserDTO userDTO) {
        return this.userService.update(userDTO);
    }
}