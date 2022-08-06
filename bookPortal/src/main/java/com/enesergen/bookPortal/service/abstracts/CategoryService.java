package com.enesergen.bookPortal.service.abstracts;

import com.enesergen.bookPortal.core.utilities.results.DataResult;
import com.enesergen.bookPortal.core.utilities.results.Result;
import com.enesergen.bookPortal.entities.concretes.Book;
import com.enesergen.bookPortal.entities.concretes.Category;
import com.enesergen.bookPortal.entities.dtos.BookDTO;
import com.enesergen.bookPortal.entities.dtos.CategoryDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public interface CategoryService {
    Result save(CategoryDTO CategoryDTO);
    Result remove(CategoryDTO CategoryDTO);
    Result update(CategoryDTO CategoryDTO);
    DataResult<Category> getOne(long id);
    DataResult<List<Category>>getAll();
}
