package com.enesergen.obss.springStarter.springStarter.Entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@MappedSuperclass
@Data
public class EntityBase implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private long id;
    @Column(name = "CREATE_DATE")
    private Date createDate;
    @Column(name = "UPDATE_BASE")
    private Date updateDate;
    @Column(name = "ACTIVE")
    private boolean active;
    @Column(name = "OPERATION_TYPE")
    private String operationType;

}
