package com.enesergen.bookPortal.dal.abstratcs;

import com.enesergen.bookPortal.entities.concretes.User;
import com.enesergen.bookPortal.entities.dtos.UserDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserDAL extends JpaRepository<User, Long> {
    Boolean existsByUsername(String username);
    User getByUsername(String username);
}
