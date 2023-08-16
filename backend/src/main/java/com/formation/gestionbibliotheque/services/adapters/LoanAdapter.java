package com.formation.gestionbibliotheque.services.adapters;

import com.formation.gestionbibliotheque.dtos.LoanDto;
import com.formation.gestionbibliotheque.models.LoanModel;

public class LoanAdapter {

    public static LoanDto toDto(LoanModel model) {
        return LoanDto.builder()
                .id(model.getId())
                .borrowedAt(model.getBorrowedAt())
                .returnDate(model.getReturnDate())
                .returnedAt(model.getReturnedAt())
                .bookTitle(model.getBook().getTitle())
                .userUsername(model.getUser().getUsername())
                .build();
    }
}
