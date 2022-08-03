package com.enesergen.obss.springStarter.springStarter.DataAccessLayer;

import com.enesergen.obss.springStarter.springStarter.Entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleDAL extends JpaRepository<Role,Long> {
    Optional<Role>findByName(String name);
    boolean existsByName(String name);
}
