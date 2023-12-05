package com.camping.camping.controllers;


import com.camping.camping.applications.GetCategoryService;
import com.camping.camping.dtos.CategoryItemDto;
import com.camping.camping.dtos.RegisterRequestDto;
import com.camping.camping.dtos.RegisterResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/category")
public class CategoryController {

    private final GetCategoryService getCategoryService;

    public CategoryController(GetCategoryService getCategoryService) {
        this.getCategoryService = getCategoryService;
    }

    @GetMapping
    public List<CategoryItemDto> get() {
        return getCategoryService.getCategories();
    }
}
