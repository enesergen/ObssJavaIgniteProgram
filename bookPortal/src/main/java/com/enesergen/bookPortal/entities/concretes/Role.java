package com.enesergen.bookPortal.entities.concretes;
import com.enesergen.bookPortal.core.utilities.entities.EntityBase;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.Set;

@Entity
@Table(name="ROLE")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Role extends EntityBase {
    @Column(name="name",unique = true)
    private String name;

    @ManyToMany(mappedBy = "roles")
    @JsonBackReference
    private Set<User>users;


}