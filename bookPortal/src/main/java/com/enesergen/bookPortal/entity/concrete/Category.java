package com.enesergen.bookPortal.entity.concrete;

import com.enesergen.bookPortal.core.utility.EntityBase;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;

@Entity
@Table(name="CATEGORY")
@Getter
@Setter
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","books"})
public class Category extends EntityBase {
    @Column(name="NAME")
    private String name;
    @OneToMany(mappedBy = "category")
    private Set<Book> books;
}
