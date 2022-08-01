package com.enesergen.obss.springStarter.springStarter.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    @GetMapping("/search")
    public ResponseEntity<?>getUsers(){
        return ResponseEntity.ok("GetUsers is successful.");
    }
    @PostMapping("/create")
    public ResponseEntity<?>postUsers(){
        return ResponseEntity.ok("postUsers is successful.");
    }

}
