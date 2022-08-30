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
        System.out.println(search);
        return this.bookService.searchBooks(search);

    }

    @PostMapping("/books/{username}")
    @Override
    public Result addBook(@PathVariable String  username, @RequestBody BookDTO bookDTO) {
        return this.userService.addBook(username,bookDTO);
    }

    @GetMapping("/books/{username}")
    @Override
    public DataResult<Set<Book>> listMyBook(@PathVariable String username) {
        return this.userService.listMyBooks(username);
    }

    @DeleteMapping("/books/{username}")
    @Override
    public Result removeBook(@PathVariable String username, @RequestBody BookDTO bookDTO) {
        return this.userService.removeBook(username,bookDTO);
    }

    @PostMapping("/fbooks/{username}")
    @Override
    public Result addFavoriteBook(@PathVariable String username, @RequestBody BookDTO bookDTO) {
        return this.userService.addFavoriteBook(username,bookDTO);
    }

    @GetMapping("/fbooks/{username}")
    @Override
    public DataResult<Set<Book>> listMyFavoriteBook(@PathVariable String username) {
        return this.userService.listMyFavoriteBooks(username);
    }

    @DeleteMapping("/fbooks/{username}")
    @Override
    public Result removeFavoriteBook(@PathVariable String username, @RequestBody BookDTO bookDTO) {
        return this.userService.removeFavoriteBook(username,bookDTO);
    }
    @PutMapping("")
    @Override
    public Result updateUSer(@Valid @RequestBody UserDTO userDTO) {
        return this.userService.update(userDTO);
    }

}
