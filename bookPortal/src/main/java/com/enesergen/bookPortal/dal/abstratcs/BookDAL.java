package com.enesergen.bookPortal.dal.abstratcs;

import com.enesergen.bookPortal.entities.concretes.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookDAL extends JpaRepository<Book, Long> {
    Book getByIsbn(String isbn);

    List<Book> getByName(String name);

    List<Book> getByNameContains(String name);

    List<Book> getByAuthor_Name(String name);

    @Query("from Book where name=:name and category.id=:id")
    List<Book> getByNameAndCategory(String name, int id);

}
