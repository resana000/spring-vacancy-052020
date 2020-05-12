package com.example.demo.controller;

import com.example.demo.dto.CategoryDtoDto;
import com.example.demo.service.CategoryService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(Category.class)
class CategoryTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    CategoryService categoryService;

    @Test
    void add() throws Exception {
        CategoryDtoDto categoryDtoDto = new CategoryDtoDto();
        categoryDtoDto.setName("name");
        categoryDtoDto.setParentId(1l);
        String content = new ObjectMapper().writeValueAsString(categoryDtoDto);
        mockMvc.perform(post("/category/add")
        .contentType(MediaType.APPLICATION_JSON)
        .content(content))
                .andExpect(status().isOk());
    }
}