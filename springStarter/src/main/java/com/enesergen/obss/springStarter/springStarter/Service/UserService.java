package com.enesergen.obss.springStarter.springStarter.Service;

import com.enesergen.obss.springStarter.springStarter.Cache.UserCache;
import com.enesergen.obss.springStarter.springStarter.Config.OurPasswordEncoder;
import com.enesergen.obss.springStarter.springStarter.DTO.MyUserDetails;
import com.enesergen.obss.springStarter.springStarter.DTO.UserDTO;
import com.enesergen.obss.springStarter.springStarter.DTO.UserUpdateDTO;
import com.enesergen.obss.springStarter.springStarter.DataAccessLayer.RoleDAL;
import com.enesergen.obss.springStarter.springStarter.DataAccessLayer.UserDAL;
import com.enesergen.obss.springStarter.springStarter.DataAccessLayer.UserDALManager;
import com.enesergen.obss.springStarter.springStarter.Entity.User;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Set;

@Service
public class UserService implements UserDetailsService {

    private final ApplicationContext context;


    private final UserCache userCache;

    private final RoleDAL roleDAL;
    private final UserDAL userDAL;
    private final UserDALManager userDALManager;
    private final PasswordEncoder encoder;

    public UserService(ApplicationContext context, @Qualifier("singleton") UserCache userCache, RoleDAL roleDAL, UserDAL userDAL, UserDALManager userDALManager, OurPasswordEncoder encoder) {
        this.context = context;
        this.userCache = userCache;
        this.roleDAL = roleDAL;
        this.userDAL = userDAL;
        this.userDALManager = userDALManager;
        this.encoder = encoder;
    }

    public Map<String, UserDTO> save(UserDTO userDTO) {
        userCache.put(userDTO);
        return userCache.getMap();
    }

    public User saveUser(User user) {
        var userRolesOpt=roleDAL.findByName("ROLE_USER");
        user.setRoles(Set.of(userRolesOpt.get()));
        user.setPassword(encoder.encode(user.getPassword()));

        var user1=userDAL.save(user);
        return user1;
    }

    public List<User> getAll() {
        return userDAL.findAll();
    }

    public User findById(long id) {
        var userOpt = userDAL.findById(id);
        return userOpt.orElseThrow(() -> {
            throw new NullPointerException("User not found.");
        });
    }

    public User update(long id, UserUpdateDTO userUpdateDTO) {
        var user = this.findById(id);
        user.setPassword(encoder.encode(userUpdateDTO.getPassword()));
        return userDAL.save(user);
    }

    public User remove(long id) {
        var user = this.findById(id);
        user.setActive(false);
        return userDAL.save(user);
    }

    public User findByUsername(String username) {
        var userOpt = userDAL.findByUsername(username);
        return userOpt.orElseThrow(() -> {
            throw new NullPointerException("User is not found.");
        });
    }

    public List<User> findByUsernameStartsWith(String username) {
        return userDAL.findByUsernameStartsWithAndActiveTrueOrderByCreateDateDesc(username);
    }

    public User getUserByHQL(long id) {
        var userOpt = userDAL.getById(id);
        return userOpt.orElseThrow(() -> {
            throw new NullPointerException("User is not found.");
        });
    }

    public User getUserByNative(long id) {
        var userOpt = userDAL.getByIdNative(id);
        return userOpt.orElseThrow(() -> {
            throw new NullPointerException("User is not found.");
        });
    }

    public List<User> getUsersWithCriteria(int pageNumber, int pageSize) {
        return userDALManager.getUsersWithCriteria(pageNumber, pageSize);
    }

    public List<User> getUsersWithPageable(int pageNumber, int pageSize) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        return userDAL.findAll(pageable).getContent();
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        var user=this.findByUsername(username);
        return new MyUserDetails(user);
    }
}
