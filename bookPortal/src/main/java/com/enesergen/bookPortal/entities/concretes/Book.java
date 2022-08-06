package com.enesergen.bookPortal.entities.concretes;

import com.enesergen.bookPortal.core.utilities.entities.EntityBase;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="BOOK")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Book  extends EntityBase {
    @Column(name = "ISBN", unique = true)
    private String isbn;
    @Column(name="NAME")
    private String name;
    @Column(name="PAGE_SIZE")
    private int pageSize;
    @Column(name="IMAGE_URL")
    private String imageUrl;
    @Column(name="DESCRIPTION")
    private String description;
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
