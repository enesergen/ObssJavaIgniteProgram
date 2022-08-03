package com.enesergen.obss.springStarter.springStarter.DataAccessLayer;

import com.enesergen.obss.springStarter.springStarter.Entity.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;
@Repository
public class UserDALManager {
    private final EntityManager entityManager;

    public UserDALManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    public List<User>getUsersWithCriteria(int pageNumber,int pageSize){
        var criteriaBuilder=entityManager.getCriteriaBuilder();
        var criteriaQuery=criteriaBuilder.createQuery(User.class);
        var from=criteriaQuery.from(User.class);
        var select=criteriaQuery.select(from);
        select.where(criteriaBuilder.isTrue(from.get("active")));
        var typedQuery=entityManager.createQuery(select);
        typedQuery.setFirstResult(pageSize*pageNumber);
        typedQuery.setMaxResults(pageSize);
        return typedQuery.getResultList();


    }
}
