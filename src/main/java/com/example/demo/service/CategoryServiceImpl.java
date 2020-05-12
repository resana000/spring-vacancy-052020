package com.example.demo.service;

import com.example.demo.dto.CategoryDtoDto;
import com.example.demo.enytity.Category;
import com.example.demo.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public Category dtoMapping(CategoryDtoDto categoryDtoDto) {
        Category category = new Category();
        category.setName(categoryDtoDto.getName());

        Category parentCategory = categoryRepository
        .getOne(categoryDtoDto.getParentId());
        category.setCategory(parentCategory);

        return categoryRepository.save(category);
    }

    @Override
    public Category addCategoty(CategoryDtoDto categoryDtoDto) {
        return dtoMapping(categoryDtoDto);
    }
}
