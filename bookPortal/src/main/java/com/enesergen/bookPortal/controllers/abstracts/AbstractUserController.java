package com.enesergen.bookPortal.controllers.abstracts;

import com.enesergen.bookPortal.core.utilities.results.DataResult;
import com.enesergen.bookPortal.core.utilities.results.Result;
import com.enesergen.bookPortal.entities.concretes.User;
import com.enesergen.bookPortal.entities.dtos.UserDTO;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public interface AbstractUserController {
    Result createUser(UserDTO userDTO);
    Result removeUser(UserDTO userDTO);
    Result updateUSer(UserDTO userDTO);
    DataResult<User>getOneUser(long id);
    DataResult<List<User>>getAllUsers();

}
