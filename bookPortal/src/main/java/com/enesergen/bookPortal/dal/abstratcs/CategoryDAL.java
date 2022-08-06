package com.enesergen.bookPortal.dal.abstratcs;

import com.enesergen.bookPortal.entities.concretes.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CategoryDAL extends JpaRepository<Category,Long> {
Category getByName(String name);
List<Category> getByNameContains(String name);

}
