package com.iheb.gestiondestock.controller;

import com.iheb.gestiondestock.controller.api.CategoryApi;
import com.iheb.gestiondestock.dto.CategoryDto;
import com.iheb.gestiondestock.services.CategoryService;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class CategoryController implements CategoryApi {

    private CategoryService categoryService ;
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService ;

    }

    @Override
    public CategoryDto save(CategoryDto categoryDto) {
        return categoryService.save(categoryDto);
    }

    @Override
    public CategoryDto findById(Integer id) {
        return categoryService.findById(id);
    }

    @Override
    public CategoryDto findByCodeCategory(String codeCategory) {
        return categoryService.findByCodeCategory(codeCategory);
    }

    @Override
    public List<CategoryDto> findAll() {
        return categoryService.findAll();
    }

    @Override
    public void delete(Integer id) {

        categoryService.delete(id);
    }
}
