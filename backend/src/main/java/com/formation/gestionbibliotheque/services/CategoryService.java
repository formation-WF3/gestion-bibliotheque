package com.formation.gestionbibliotheque.services;

import com.formation.gestionbibliotheque.dtos.CategoryDto;
import com.formation.gestionbibliotheque.repositories.CategoryRepository;
import com.formation.gestionbibliotheque.services.adapters.CategoryAdapter;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Service
public class CategoryService {
    private CategoryRepository categoryRepository;

    private CategoryAdapter categoryAdapter;

    public List<CategoryDto> getAll() {
        List<CategoryDto> categoryDtos = new ArrayList<>();
        categoryRepository.findAll().forEach(
                model -> categoryDtos.add(categoryAdapter.toDto(model))
        );
        return categoryDtos;
    }

    public CategoryDto getById(long id) {
        return categoryRepository.findById(id)
                .map(categoryAdapter::toDto)
                .orElseThrow(() -> new RuntimeException("Catégorie non trouvée !"));
    }

    public CategoryDto getByName(String name) {
        return categoryRepository.findByNameIgnoreCase(name)
                .map(categoryAdapter::toDto)
                .orElseThrow(() -> new RuntimeException("Catégorie non trouvée !"));
    }
}
