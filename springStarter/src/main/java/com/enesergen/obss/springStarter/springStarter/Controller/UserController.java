package com.enesergen.obss.springStarter.springStarter.Controller;

import com.enesergen.obss.springStarter.springStarter.Cache.UserCache;
import com.enesergen.obss.springStarter.springStarter.Cache.UserDTOPrototype;
import com.enesergen.obss.springStarter.springStarter.Cache.UserDTOSingleton;
import com.enesergen.obss.springStarter.springStarter.DTO.UserDTO;

import com.enesergen.obss.springStarter.springStarter.Service.UserService;
import org.mapstruct.Qualifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {
    private static final Logger LOGGER= LoggerFactory.getLogger(UserController.class);

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/search")
    public ResponseEntity<?>getUsers(){

        return ResponseEntity.ok("GetUsers is successful.");
    }
    @PostMapping("/create")
    public ResponseEntity<?> postUsers(@Valid @RequestBody UserDTO userDTO){
        LOGGER.info("Username {},Password {}",userDTO.getUsername(),userDTO.getPassword());
        return   ResponseEntity.ok(userService.save(userDTO));
        /*var userCachePrototype=context.getBean(UserDTOPrototype.class);
        var userCacheSingleton=context.getBean(UserDTOSingleton.class);
        userCachePrototype.users.put(userDTO.getUsername(),userDTO);
        userCacheSingleton.users.put(userDTO.getUsername(),userDTO);

        var map=new HashMap<String,Object>();
        map.put("Singleton",userCacheSingleton);
        map.put("Prototype",userCachePrototype);*/
    }

}
