package com.example.demo.controller;

import com.example.demo.dto.CategoryDtoDto;
import com.example.demo.enytity.Product;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.repository.ProductRepository;
import com.example.demo.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/category")
public class Category {

    @Autowired
    CategoryService categoryService;

    @PostMapping("/add")
    ResponseEntity add(@RequestBody CategoryDtoDto categoryDtoDto){
        return ResponseEntity.ok(categoryService.addCategoty(categoryDtoDto));
    }
}
