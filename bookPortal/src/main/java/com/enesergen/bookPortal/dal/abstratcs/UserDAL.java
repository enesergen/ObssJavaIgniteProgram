package com.enesergen.bookPortal.dal.abstratcs;

import com.enesergen.bookPortal.entities.concretes.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface UserDAL extends JpaRepository<User, Long> {
    Boolean existsByUsername(String username);
    User getByUsername(String username);
}
