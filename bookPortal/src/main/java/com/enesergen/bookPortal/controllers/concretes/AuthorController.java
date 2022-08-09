package com.enesergen.bookPortal.controllers.concretes;

import com.enesergen.bookPortal.controllers.abstracts.AbstractAuthorController;
import com.enesergen.bookPortal.core.utilities.results.DataResult;
import com.enesergen.bookPortal.core.utilities.results.Result;
import com.enesergen.bookPortal.entities.concretes.Author;
import com.enesergen.bookPortal.entities.dtos.AuthorDTO;
import com.enesergen.bookPortal.service.abstracts.AuthorService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/authors")
public class AuthorController implements AbstractAuthorController {
    private final AuthorService authorService;

    public AuthorController(@Valid @RequestBody AuthorService authorService) {
        this.authorService = authorService;
    }

    @PostMapping("")
    @Override
    public Result createAuthor(@Valid @RequestBody AuthorDTO authorDTO) {
        return this.authorService.save(authorDTO);
    }

    @DeleteMapping("/{id}")
    @Override
    public Result removeAuthor(@PathVariable long id) {
        return this.authorService.remove(id);
    }

    @PutMapping("/{id}")
    @Override
    public Result updateAuthor(@PathVariable long id, @Valid @RequestBody AuthorDTO authorDTO) {
        return this.authorService.update(id, authorDTO);
    }

    @GetMapping("/{id}")
    @Override
    public DataResult<Author> getOneAuthor(@PathVariable long id) {
        return this.authorService.getOne(id);
    }

    @GetMapping("")
    @Override
    public DataResult<List<Author>> getAllAuthors() {
        return this.authorService.getAll();
    }
}
