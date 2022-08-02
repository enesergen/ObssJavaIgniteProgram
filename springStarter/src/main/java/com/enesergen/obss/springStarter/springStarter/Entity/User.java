package com.enesergen.obss.springStarter.springStarter.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "USER_ACCOUNT")
public class User extends EntityBase{

    @Column(name = "USERNAME", unique = true)
    private String username;
    @Column(name = "PASSWORD")
    private String password;



}
