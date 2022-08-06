package com.enesergen.bookPortal.core.utilities.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@MappedSuperclass
@Getter
@Setter
public class EntityBase implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID",nullable = false)
    private long id;
    @Column(name="CREATE_DATE")
    private Date createDate;
    @Column(name="UPDATE_DATE")
    private Date updateDate;
    @Column(name="ACTIVE")
    private boolean active;
    @Column(name="OPERATION_TYPE")
    private String operationType;

    @PrePersist
    public void onPrePersist(){
        this.active=true;
        this.createDate=new Date();
        this.updateDate=new Date();
        this.operationType="SAVE";
    }

    @PreUpdate
    public void onPreUpdate(){
        this.updateDate=new Date();
        this.operationType="UPDATE";
    }
    @PreRemove
    public void onPreRemove(){
        this.updateDate=new Date();
        this.operationType="DELETE";
    }
}
