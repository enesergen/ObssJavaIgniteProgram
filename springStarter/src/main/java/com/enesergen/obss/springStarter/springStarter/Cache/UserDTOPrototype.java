package com.enesergen.obss.springStarter.springStarter.Cache;

import com.enesergen.obss.springStarter.springStarter.DTO.UserDTO;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Component("prototype")
@Scope("prototype")
public class UserDTOPrototype implements UserCache{
    public Map<String, UserDTO> users;

    @PostConstruct
    void init() {
        users = new HashMap<>();
    }

    @Override
    public void put(UserDTO userDTO) {
        users.put(userDTO.getUsername(),userDTO);
    }

    @Override
    public Map<String, UserDTO> getMap() {
        return users;
    }
}
