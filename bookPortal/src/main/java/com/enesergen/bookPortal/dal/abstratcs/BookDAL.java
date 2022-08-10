package com.enesergen.bookPortal.dal.abstratcs;

import com.enesergen.bookPortal.entities.concretes.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface BookDAL extends JpaRepository<Book, Long> {
    Book getByIsbn(String isbn);

    List<Book> getByName(String name);

    List<Book> getByNameContains(String name);

    List<Book> getByAuthor_Name(String name);


    List<Book>findByActiveTrue();

    @Query("SELECT b from Book as b " +
            "where b.name LIKE CONCAT('%',:search,'%')" +
            "OR b.description LIKE CONCAT('%',:search,'%')")
    List<Book>searchBooks(String search);



}
