package com.enesergen.obss.springStarter.springStarter.DataAccessLayer;
import com.enesergen.obss.springStarter.springStarter.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserDAL extends JpaRepository<User,Long> {
     Optional<User> findByUsername(String username);
     List<User>     findByUsernameStartsWithAndActiveTrueOrderByCreateDateDesc(String username);
}
