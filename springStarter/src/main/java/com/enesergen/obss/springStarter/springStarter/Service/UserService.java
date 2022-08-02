package com.enesergen.obss.springStarter.springStarter.Service;

import com.enesergen.obss.springStarter.springStarter.Cache.UserCache;
import com.enesergen.obss.springStarter.springStarter.DTO.UserDTO;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class UserService {

    private final ApplicationContext context;

    private final UserCache userCache;

    public UserService(ApplicationContext context, @Qualifier("singleton") UserCache userCache) {
        this.context = context;
        this.userCache = userCache;
    }
    public Map<String, UserDTO>save(UserDTO userDTO){
        userCache.put(userDTO);
        return userCache.getMap();
    }


}
