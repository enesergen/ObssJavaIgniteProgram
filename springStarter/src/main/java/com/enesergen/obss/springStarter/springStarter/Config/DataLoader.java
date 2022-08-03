package com.enesergen.obss.springStarter.springStarter.Config;

import com.enesergen.obss.springStarter.springStarter.DataAccessLayer.RoleDAL;
import com.enesergen.obss.springStarter.springStarter.Entity.Role;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.UserRoleAuthorizationInterceptor;

@Component
public class DataLoader implements ApplicationRunner {
    public static final String ROLE_USER="ROLE_USER";
    public static final String ROLE_ADMIN="ROLE_ADMIN";
    private final RoleDAL roleDAL;

    public DataLoader(RoleDAL roleDAL) {
        this.roleDAL = roleDAL;
    }


    @Override
    public void run(ApplicationArguments args) throws Exception {
        var userRoleExists=roleDAL.existsByName("ROLE_USER");
        if(!userRoleExists){
            var userRole=new Role();
            userRole.setName("ROLE_USER");
            roleDAL.save(userRole);
        }
        var adminRoleExists=roleDAL.existsByName("ROLE_ADMIN");
        if(!adminRoleExists){
            var adminRole=new Role();
            adminRole.setName("ROLE_ADMIN");
            roleDAL.save(adminRole);
        }

    }
}
