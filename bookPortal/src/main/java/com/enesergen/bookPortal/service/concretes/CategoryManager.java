package com.enesergen.bookPortal.service.concretes;

import com.enesergen.bookPortal.core.utilities.results.*;
import com.enesergen.bookPortal.dal.abstratcs.CategoryDAL;
import com.enesergen.bookPortal.entities.concretes.Category;
import com.enesergen.bookPortal.entities.dtos.CategoryDTO;
import com.enesergen.bookPortal.service.abstracts.CategoryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryManager implements CategoryService {
    private final CategoryDAL categoryDAL;

    public CategoryManager(CategoryDAL categoryDAL) {
        this.categoryDAL = categoryDAL;
    }

    @Override
    public Result save(CategoryDTO categoryDTO) {
        Category category = new Category();
        category.setName(categoryDTO.getName());
        category.setBooks(null);
        category = this.categoryDAL.save(category);
        if (this.categoryDAL.existsById(category.getId())) {
            return new SuccessResult("Category adding operation is successful.");
        } else {
            return new ErrorResult("Category could not add");
        }
    }

    @Override
    public Result remove(CategoryDTO categoryDTO) {
        Category category =
                this.categoryDAL.getByName(categoryDTO.getName());
        if (category != null) {
            category.setActive(false);
            this.categoryDAL.save(category);
            return new SuccessResult("Category removing is successful.");
        } else {
            return new ErrorResult("Category could not remove.");
        }
    }

    @Override
    public Result update(CategoryDTO categoryDTO) {
        Category category =
                this.categoryDAL.getByName(categoryDTO.getName());
        if (category != null) {
            category.setName(categoryDTO.getName());
            this.categoryDAL.save(category);
            return new SuccessResult("Category updating is successful.");

        } else {
            return new ErrorResult("Category could not update");
        }
    }

    @Override
    public DataResult<Category> getOne(long id) {
        Optional<Category> category = this.categoryDAL.findById(id);
        if (category.isPresent()) {
            return new SuccessDataResult<>(category.get(), "Get category operation is successful.");
        } else {
            return new ErrorDataResult<>
                    ("Category could not found.");
        }

    }

    @Override
    public DataResult<List<Category>> getAll() {
        List<Category> categories = this.categoryDAL.findAll();
        if (!categories.isEmpty()) {
            return new SuccessDataResult<>(categories, "Get operation is successful");
        }
        return  new ErrorDataResult<>( "Categories could not found.");
    }
}
