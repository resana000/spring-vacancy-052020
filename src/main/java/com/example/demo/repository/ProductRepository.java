package com.example.demo.repository;

import com.example.demo.enytity.Category;
import com.example.demo.enytity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
