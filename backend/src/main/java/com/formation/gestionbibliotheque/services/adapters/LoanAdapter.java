package com.formation.gestionbibliotheque.services.adapters;

import com.formation.gestionbibliotheque.dtos.LoanDto;
import com.formation.gestionbibliotheque.models.LoanModel;

public class LoanAdapter {

    public static LoanDto toDto(LoanModel model) {
        LoanDto dto = new LoanDto();
        dto.setId(model.getId());
        dto.setBorrowedAt(model.getBorrowedAt());
        dto.setReturnDate(model.getReturnDate());
        dto.setReturnedAt(model.getReturnedAt());
        dto.setBook(model.getBook());
        dto.setUser(model.getUser());
        return dto;
    }
}
