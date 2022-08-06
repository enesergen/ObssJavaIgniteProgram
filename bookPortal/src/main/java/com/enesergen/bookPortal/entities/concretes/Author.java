package com.enesergen.bookPortal.entities.concretes;

import com.enesergen.bookPortal.core.utilities.entities.EntityBase;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "AUTHOR")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
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
