package com.example.demo.service;

import com.example.demo.dto.CategoryDtoDto;
import com.example.demo.enytity.Category;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
class CategoryServiceImplTest {

    @Test
    void equalTest() {
        Category category = new Category();
        category.setId(1l);
        category.setName("name");


        Category categoryParent = new Category();
        categoryParent.setId(1l);
        categoryParent.setName("name");

        category.setCategory(categoryParent);

        assertTrue(category.equals(categoryParent));


    }
}