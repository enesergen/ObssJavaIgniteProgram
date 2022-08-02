package com.enesergen.obss.springStarter.springStarter.Cache;

import com.enesergen.obss.springStarter.springStarter.DTO.UserDTO;

import java.util.Map;

public interface UserCache {
    void put(UserDTO userDTO);
    Map<String,UserDTO> getMap();
}
