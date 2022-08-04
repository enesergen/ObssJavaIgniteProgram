package com.enesergen.bookPortal.entity.concrete;

import com.enesergen.bookPortal.core.utility.EntityBase;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "AUTHOR")
@Getter
@Setter
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "books"})
public class Author extends EntityBase {
    @Column(name = "NAME")
    private String name;
    @Column(name = "BIRTH_YEAR")
    private int birthYear;
    @Column(name = "BIRTH_PLACE")
    private String birthPlace;
    @OneToMany(mappedBy = "author")
    private Set<Book> books;
}
