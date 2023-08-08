package com.formation.gestionbibliotheque.services.adapters;

import com.formation.gestionbibliotheque.dtos.CategoryDto;
import com.formation.gestionbibliotheque.models.CategoryModel;

public class CategoryAdapter {

    public static CategoryDto toDto(CategoryModel model) {
        CategoryDto dto = new CategoryDto();
        dto.setId(model.getId());
        dto.setName(model.getName());
        return dto;
    }
}
