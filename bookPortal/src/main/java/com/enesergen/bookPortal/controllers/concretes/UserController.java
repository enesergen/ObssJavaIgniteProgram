package com.enesergen.bookPortal.controllers.concretes;


import com.enesergen.bookPortal.controllers.abstracts.AbstractUserController;
import com.enesergen.bookPortal.core.utilities.results.DataResult;
import com.enesergen.bookPortal.core.utilities.results.Result;
import com.enesergen.bookPortal.entities.concretes.User;
import com.enesergen.bookPortal.entities.dtos.UserDTO;
import com.enesergen.bookPortal.service.abstracts.UserService;

import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;

import java.util.List;


@RestController
@RequestMapping("/users")
public class UserController implements AbstractUserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("")
    @Override
    public Result createUser(@Valid @RequestBody UserDTO userDTO) {
        return this.userService.save(userDTO);
    }

    @DeleteMapping("")
    @Override
    public Result removeUser(@Valid @RequestBody UserDTO userDTO) {
        return this.userService.remove(userDTO);
    }

    @PutMapping("")
    @Override
    public Result updateUSer(@Valid @RequestBody UserDTO userDTO) {
        return this.userService.update(userDTO);
    }

    @GetMapping("/{id}")
    @Override
    public DataResult<User> getOneUser(@PathVariable long id) {
        return this.userService.getOne(id);
    }

    @GetMapping("")
    @Override
    public DataResult<List<User>> getAllUsers() {
        return this.userService.getAll();
    }

    @GetMapping("/token/refresh")
    public void refreshToken(HttpServletRequest request, HttpServletResponse response) throws IOException {
        this.userService.refreshToken(request, response);
    }
}
