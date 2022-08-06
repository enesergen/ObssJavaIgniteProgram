package com.enesergen.bookPortal.entities.concretes;

import com.enesergen.bookPortal.core.utilities.entities.EntityBase;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
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
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","books"})
public class Category extends EntityBase {
    @Column(name="NAME",unique = true)
    private String name;
    @OneToMany(mappedBy = "category")
    private Set<Book> books;
}
