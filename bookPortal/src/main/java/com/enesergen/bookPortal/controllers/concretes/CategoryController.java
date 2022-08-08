package com.enesergen.bookPortal.controllers.concretes;

import com.enesergen.bookPortal.controllers.abstracts.AbstractCategoryController;
import com.enesergen.bookPortal.core.utilities.results.DataResult;
import com.enesergen.bookPortal.core.utilities.results.Result;
import com.enesergen.bookPortal.entities.concretes.Category;
import com.enesergen.bookPortal.entities.dtos.CategoryDTO;
import com.enesergen.bookPortal.service.abstracts.CategoryService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
@RequestMapping("/categories")
@RestController
public class CategoryController implements AbstractCategoryController {
    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }
    @PostMapping("")
    @Override
    public Result createCategory(@Valid @RequestBody CategoryDTO categoryDTO) {
        return this.categoryService.save(categoryDTO);
    }
    @DeleteMapping("")
    @Override
    public Result removeCategory(@Valid @RequestBody CategoryDTO categoryDTO) {
        return this.categoryService.remove(categoryDTO);
    }
    @PutMapping("/{id}")
    @Override
    public Result updateCategory(@PathVariable long id,@Valid @RequestBody  CategoryDTO categoryDTO) {
        return this.categoryService.update(id,categoryDTO);
    }
    @GetMapping("/{id}")
    @Override
    public DataResult<Category> getOneCategory(@PathVariable long id) {
        return this.categoryService.getOne(id);
    }
    @GetMapping("")
    @Override
    public DataResult<List<Category>> getAllCategories() {
        return this.categoryService.getAll();
    }
}
