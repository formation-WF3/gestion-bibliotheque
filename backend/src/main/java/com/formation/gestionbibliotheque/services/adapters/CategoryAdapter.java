package com.formation.gestionbibliotheque.services.adapters;

import com.formation.gestionbibliotheque.dtos.CategoryDto;
import com.formation.gestionbibliotheque.models.CategoryModel;

public class CategoryAdapter {

    public static CategoryDto toDto(CategoryModel model) {
        return CategoryDto.builder()
                .id(model.getId())
                .name(model.getName())
                .build();
    }
}
