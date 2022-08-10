package com.enesergen.bookPortal;

import com.enesergen.bookPortal.dal.abstratcs.BookDAL;
import com.enesergen.bookPortal.dal.abstratcs.RoleDAL;
import com.enesergen.bookPortal.dal.abstratcs.UserDAL;
import com.enesergen.bookPortal.entities.concretes.User;
import com.enesergen.bookPortal.entities.dtos.UserDTO;
import com.enesergen.bookPortal.service.concretes.UserManager;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})//
public class BookPortalApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookPortalApplication.class, args);
	}

}
