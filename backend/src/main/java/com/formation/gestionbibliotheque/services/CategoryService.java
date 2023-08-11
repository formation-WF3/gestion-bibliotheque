package com.formation.gestionbibliotheque.services;

import com.formation.gestionbibliotheque.dtos.BookDto;
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

    public List<CategoryDto> getAll() {
        List<CategoryDto> categoryDtos = new ArrayList<>();
        categoryRepository.findAll().forEach(
                model -> categoryDtos.add(CategoryAdapter.toDto(model))
        );
        return categoryDtos;
    }

    public CategoryDto getById(long id) {
        return categoryRepository.findById(id)
                .map(CategoryAdapter::toDto)
                .orElseThrow(() -> new RuntimeException("Catégorie non trouvée !"));
    }
}
