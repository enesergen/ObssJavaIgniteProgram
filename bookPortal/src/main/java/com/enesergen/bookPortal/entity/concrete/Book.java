package com.enesergen.bookPortal.entity.concrete;

import com.enesergen.bookPortal.core.utility.EntityBase;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="BOOK")
@Getter
@Setter
public class Book  extends EntityBase {
    @Column(name = "ISBN", unique = true)
    private String isbn;
    @Column(name="NAME")
    private String name;
    @Column(name="PAGE_SIZE")
    private int pageSize;
    @ManyToOne()
    @JoinColumn(name="AUTHOR_ID")
    private Author author;
    @ManyToOne()
    @JoinColumn(name="CATEGORY_ID")
    private Category category;

    @ManyToMany(mappedBy = "books")
    @JsonBackReference
    private Set<User> users;

    @ManyToMany(mappedBy = "favoriteBooks")
    @JsonBackReference
    private Set<User> favoriteUsers;


}
