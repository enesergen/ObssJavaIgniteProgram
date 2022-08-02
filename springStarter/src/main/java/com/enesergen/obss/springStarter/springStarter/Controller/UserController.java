package com.enesergen.obss.springStarter.springStarter.Controller;

import com.enesergen.obss.springStarter.springStarter.Entity.UserDTO;

import com.enesergen.obss.springStarter.springStarter.Exception.GlobalExcepitonHandler;
import org.apache.catalina.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {
    private static final Logger LOGGER= LoggerFactory.getLogger(UserController.class);


    @GetMapping("/search")
    public ResponseEntity<?>getUsers(){

        return ResponseEntity.ok("GetUsers is successful.");
    }
    @PostMapping("/create")
    public ResponseEntity<?> postUsers(@Valid @RequestBody UserDTO userDTO){
        LOGGER.info("Username {},Password {}",userDTO.getUsername(),userDTO.getPassword());
        return  ResponseEntity.ok("PostUsers is successful.");
    }

}
