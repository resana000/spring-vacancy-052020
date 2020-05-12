package com.example.demo.controller;

import com.example.demo.enytity.Product;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class Category {

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    ProductRepository productRepository;

    @GetMapping("add")
    ResponseEntity add(){
        com.example.demo.enytity.Category category = new com.example.demo.enytity.Category();
        category.setName("one");
        com.example.demo.enytity.Category category1 = new com.example.demo.enytity.Category();
        category1.setName("two");
        category1.setCategory(category);
        categoryRepository.save(category);
        categoryRepository.save(category1);

        List<com.example.demo.enytity.Category> list = new ArrayList<>();
        list.add(category);
        list.add(category1);

        Product product = new Product();
        product.setName("p1");
        product.setCategories(list);
        productRepository.save(product);

        return ResponseEntity.ok(product.getCategories());
    }
}
