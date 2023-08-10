package com.formation.gestionbibliotheque.services.adapters;

import com.formation.gestionbibliotheque.dtos.BookDto;
import com.formation.gestionbibliotheque.models.BookModel;

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
}
