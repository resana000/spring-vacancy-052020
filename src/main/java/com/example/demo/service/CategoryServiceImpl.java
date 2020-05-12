package com.example.demo.service;

import com.example.demo.dto.CategoryDtoDto;
import com.example.demo.enytity.Category;
import com.example.demo.exeption.CustomDBExeption;
import com.example.demo.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

        try {
            return categoryRepository.save(category);
        } catch (Exception e) {
            throw new CustomDBExeption(String.format("%s already exists", category.getName()));
        }
    }

    @Override
    public Category addCategoty(CategoryDtoDto categoryDtoDto) {
        return dtoMapping(categoryDtoDto);
    }
}
