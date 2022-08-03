package com.enesergen.obss.springStarter.springStarter.DataAccessLayer;
import com.enesergen.obss.springStarter.springStarter.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDAL extends JpaRepository<User,Long> {

}
