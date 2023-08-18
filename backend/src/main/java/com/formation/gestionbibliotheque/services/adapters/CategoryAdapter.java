package com.formation.gestionbibliotheque.services.adapters;

import com.formation.gestionbibliotheque.dtos.CategoryDto;
import com.formation.gestionbibliotheque.models.CategoryModel;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class CategoryAdapter {

    public CategoryDto toDto(CategoryModel model) {
        return CategoryDto.builder()
                .id(model.getId())
                .name(model.getName())
                .build();
    }
}
