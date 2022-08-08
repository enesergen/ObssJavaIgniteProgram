package com.enesergen.bookPortal.controllers.abstracts;

import com.enesergen.bookPortal.core.utilities.results.DataResult;
import com.enesergen.bookPortal.core.utilities.results.Result;
import com.enesergen.bookPortal.entities.concretes.Category;
import com.enesergen.bookPortal.entities.dtos.CategoryDTO;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public interface AbstractCategoryController {
    Result createCategory(CategoryDTO categoryDTO);
    Result removeCategory(CategoryDTO categoryDTO);
    Result updateCategory(long id, CategoryDTO categoryDTO);
    DataResult<Category> getOneCategory(long id);
    DataResult<List<Category>>getAllCategories();

}
