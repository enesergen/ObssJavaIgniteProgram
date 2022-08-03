package com.enesergen.obss.springStarter.springStarter.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import lombok.Getter;
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
public class Role extends EntityBase{
    @Column(name="name")
    private String name;

    @ManyToMany(mappedBy = "roles")
    @JsonBackReference
    private Set<User>users;


}
