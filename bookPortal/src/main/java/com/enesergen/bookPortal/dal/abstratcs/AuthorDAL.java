package com.enesergen.bookPortal.dal.abstratcs;

import com.enesergen.bookPortal.entities.concretes.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AuthorDAL extends JpaRepository<Author,Long> {
    List<Author>getByName(String name);
    List<Author>getByNameContains(String name);
}
