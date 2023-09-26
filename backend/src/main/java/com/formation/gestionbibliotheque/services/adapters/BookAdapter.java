package com.formation.gestionbibliotheque.services.adapters;

import com.formation.gestionbibliotheque.dtos.BookDto;
import com.formation.gestionbibliotheque.models.BookModel;
import com.formation.gestionbibliotheque.models.CategoryModel;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class BookAdapter {

    public BookDto toDto(BookModel model) {
         if (model == null) {
            return null;
        }

        return BookDto.builder()
                .id(model.getId())
                .title(model.getTitle())
                .author(model.getAuthor())
                .totalItems(model.getTotalItems())
                .remainingItems(model.getRemainingItems())
                .categoryName(model.getCategory().getName())
                .build();
    }

    public BookModel toModel(BookDto dto, CategoryModel categoryModel) {
        if (dto == null) {
            return null;
        }

        return BookModel.builder()
                .id(dto.getId())
                .title(dto.getTitle())
                .author(dto.getAuthor())
                .totalItems(dto.getTotalItems())
                .remainingItems(dto.getRemainingItems())
                .category(categoryModel)
                .build();
    }
}
