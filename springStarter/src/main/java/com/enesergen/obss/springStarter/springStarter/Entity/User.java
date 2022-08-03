package com.enesergen.obss.springStarter.springStarter.Entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.util.Set;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "USER_ACCOUNT")
public class User extends EntityBase{

    @Column(name = "USERNAME", unique = true)
    private String username;
    @Column(name = "PASSWORD")
    private String password;
    @ManyToMany(cascade = CascadeType.MERGE,fetch = FetchType.EAGER)//fetch kısmında rolleride çekmesini sağlar
    @JoinTable(name="USERS_ROLES",
    joinColumns = {@JoinColumn(name="USER_ID",referencedColumnName = "ID")},
    inverseJoinColumns = {@JoinColumn(name = "ROLE_ID",referencedColumnName = "ID")})
    @JsonManagedReference
    private Set<Role> roles;


}
