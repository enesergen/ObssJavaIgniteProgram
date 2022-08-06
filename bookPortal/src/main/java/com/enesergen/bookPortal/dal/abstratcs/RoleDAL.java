package com.enesergen.bookPortal.dal.abstratcs;

import com.enesergen.bookPortal.entities.concretes.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleDAL extends JpaRepository<Role,Long> {
    Role getByName(String name);
}
