package com.example.demo.service;

import com.example.demo.dto.CategoryDtoDto;
import com.example.demo.enytity.Category;

public interface CategoryService {
    Category dtoMapping(CategoryDtoDto categoryDtoDto);
    Category addCategoty(CategoryDtoDto categoryDtoDto);
}
