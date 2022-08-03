package com.enesergen.obss.springStarter.springStarter.Service;

import com.enesergen.obss.springStarter.springStarter.Cache.UserCache;
import com.enesergen.obss.springStarter.springStarter.DTO.UserDTO;
import com.enesergen.obss.springStarter.springStarter.DTO.UserUpdateDTO;
import com.enesergen.obss.springStarter.springStarter.DataAccessLayer.UserDAL;
import com.enesergen.obss.springStarter.springStarter.Entity.User;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class UserService {

    private final ApplicationContext context;


    private final UserCache userCache;

    private final UserDAL userDAL;
    public UserService(ApplicationContext context, @Qualifier("singleton") UserCache userCache,UserDAL userDAL) {
        this.context = context;
        this.userCache = userCache;
        this.userDAL=userDAL;
    }
    public Map<String, UserDTO>save(UserDTO userDTO){
        userCache.put(userDTO);
        return userCache.getMap();
    }
    public User saveUser(User user){
        userDAL.save(user);
        return user;
    }

    public List<User> getAll(){
        return userDAL.findAll();
    }
    public User findById(long id){
        var userOpt=userDAL.findById(id);
        return userOpt.orElseThrow(()-> {
            throw new NullPointerException("User not found.");
        });
    }

    public User update(long id, UserUpdateDTO userUpdateDTO){
        var user=this.findById(id);
        user.setPassword(userUpdateDTO.getPassword());
        return userDAL.save(user);
    }
    public User remove(long id){
        var user=this.findById(id);
        user.setActive(false);
        return userDAL.save(user);
    }
    public User findByUsername(String username){
       var userOpt=userDAL.findByUsername(username);
        return userOpt.orElseThrow(()->{
            throw new NullPointerException("User is not found.");
        });
    }
    public List<User>findByUsernameStartsWith(String username){
        return userDAL.findByUsernameStartsWithAndActiveTrueOrderByCreateDateDesc(username);
    }

    public User getUserByHQL(long id){
        var userOpt=userDAL.getById(id);
        return userOpt.orElseThrow(()->{
            throw new NullPointerException("User is not found.");
        });
    }
    public User getUserByNative(long id){
        var userOpt=userDAL.getByIdNative(id);
        return userOpt.orElseThrow(()->{
            throw new NullPointerException("User is not found.");
        });
    }



}
