package com.formation.gestionbibliotheque.controllers;

import com.formation.gestionbibliotheque.dtos.CategoryDto;
import com.formation.gestionbibliotheque.services.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/categories")
public class CategoryController {
    private CategoryService categoryService;

    @GetMapping
    public List<CategoryDto> getAll() {
        System.out.println("coucou");
        return categoryService.getAll();
    }

}
