package com.formation.gestionbibliotheque.services.adapters;

import com.formation.gestionbibliotheque.dtos.BookDto;
import com.formation.gestionbibliotheque.models.BookModel;

public class BookAdapter {

    public static BookDto toDto(BookModel model) {
        BookDto dto = new BookDto();
        dto.setId(model.getId());
        dto.setTitle(model.getTitle());
        dto.setAuthor(model.getAuthor());
        dto.setTotal_items(model.getTotal_items());
        dto.setRemaining_items(model.getRemaining_items());
        dto.setCategory(model.getCategory());
        return dto;
    }
}
