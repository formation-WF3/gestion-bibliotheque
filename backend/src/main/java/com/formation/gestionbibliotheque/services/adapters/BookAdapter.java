package com.formation.gestionbibliotheque.services.adapters;

import com.formation.gestionbibliotheque.dtos.BookDto;
import com.formation.gestionbibliotheque.models.BookModel;
import com.formation.gestionbibliotheque.models.CategoryModel;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class BookAdapter {

    public static BookDto toDto(BookModel model) {
        BookDto dto = new BookDto();
        dto.setId(model.getId());
        dto.setTitle(model.getTitle());
        dto.setAuthor(model.getAuthor());
        dto.setTotalItems(model.getTotalItems());
        dto.setRemainingItems(model.getRemainingItems());
        dto.setCategory(model.getCategory());
        return dto;
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
