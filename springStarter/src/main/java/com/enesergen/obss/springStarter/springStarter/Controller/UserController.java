package com.enesergen.obss.springStarter.springStarter.Controller;

import com.enesergen.obss.springStarter.springStarter.Cache.UserCache;
import com.enesergen.obss.springStarter.springStarter.Cache.UserDTOPrototype;
import com.enesergen.obss.springStarter.springStarter.Cache.UserDTOSingleton;
import com.enesergen.obss.springStarter.springStarter.DTO.UserDTO;

import com.enesergen.obss.springStarter.springStarter.DTO.UserUpdateDTO;
import com.enesergen.obss.springStarter.springStarter.Entity.User;
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
import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {
    private static final Logger LOGGER= LoggerFactory.getLogger(UserController.class);

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("")
    public ResponseEntity<List<User>>getUsers(){
        return ResponseEntity.ok(userService.getAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<User>getUser(@PathVariable long id){
        return ResponseEntity.ok(userService.findById(id));
    }
    @PostMapping("")
    public ResponseEntity<User> createUser(@Valid @RequestBody UserDTO userDTO){
        LOGGER.info("Username {},Password {}",userDTO.getUsername(),userDTO.getPassword());
        User user=new User();
        user.setUsername(userDTO.getUsername());
        user.setPassword(userDTO.getPassword());
        return   ResponseEntity.ok(userService.saveUser(user));
        /*var userCachePrototype=context.getBean(UserDTOPrototype.class);
        var userCacheSingleton=context.getBean(UserDTOSingleton.class);
        userCachePrototype.users.put(userDTO.getUsername(),userDTO);
        userCacheSingleton.users.put(userDTO.getUsername(),userDTO);
        var map=new HashMap<String,Object>();
        map.put("Singleton",userCacheSingleton);
        map.put("Prototype",userCachePrototype);*/
    }

    @PutMapping("/{id}")
    public ResponseEntity<User>updateUser(@PathVariable long id, UserUpdateDTO userUpdateDTO){
        return ResponseEntity.ok(userService.update(id,userUpdateDTO));
    }
    @PostMapping("/{id}")
    public ResponseEntity<User>removeUser(long id){
        return ResponseEntity.ok(userService.remove(id));
    }

}
