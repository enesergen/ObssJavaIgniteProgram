package com.enesergen.bookPortal.entities.concretes;

import com.enesergen.bookPortal.core.utilities.entities.EntityBase;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "USER_ACCOUNT")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User extends EntityBase {
    @Column(name = "USERNAME", unique = true)
    private String username;
    @Column(name = "PASSWORD")
    private String password;
    @ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)//fetch kısmında rolleride çekmesini sağlar
    @JoinTable(name = "USERS_ROLES",
            joinColumns = {@JoinColumn(name = "USER_ID", referencedColumnName = "ID")},
            inverseJoinColumns = {@JoinColumn(name = "ROLE_ID", referencedColumnName = "ID")})
    @JsonManagedReference
    private Set<Role> roles;
    @ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinTable(name = "USERS_BOOKS",
            joinColumns = {@JoinColumn(name = "USER_ID", referencedColumnName = "ID")},
            inverseJoinColumns = {@JoinColumn(name = "BOOK_ID", referencedColumnName = "ID")})
    @JsonManagedReference
    private Set<Book> books;
    @ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinTable(name = "USERS_FAVORITE_BOOKS",
            joinColumns = {@JoinColumn(name = "USER_ID", referencedColumnName = "ID")},
            inverseJoinColumns = {@JoinColumn(name = "BOOK_ID", referencedColumnName = "ID")})
    @JsonManagedReference
    private Set<Book> favoriteBooks;

    public void addBook(Book book) {
        books.add(book);
    }

    public void addFavoriteBook(Book book) {
        favoriteBooks.add(book);
    }

    public void removeBook(Book book) {
        books.remove(book);
    }

    public void removeFavoriteBook(Book book) {
        favoriteBooks.remove(book);
    }
    public Set<Book>myBooksList(){
        return books;
    }
    public Set<Book>myFavoriteBooksList(){
        return favoriteBooks;
    }
}
