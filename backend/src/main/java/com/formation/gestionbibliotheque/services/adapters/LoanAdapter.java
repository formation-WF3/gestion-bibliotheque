package com.formation.gestionbibliotheque.services.adapters;

import com.formation.gestionbibliotheque.dtos.LoanDto;
import com.formation.gestionbibliotheque.models.BookModel;
import com.formation.gestionbibliotheque.models.LoanModel;
import com.formation.gestionbibliotheque.models.UserModel;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class LoanAdapter {

    public LoanDto toDto(LoanModel model) {
        if (model == null) {
            return null;
        }
        return LoanDto.builder()
                .id(model.getId())
                .borrowedAt(model.getBorrowedAt())
                .returnDate(model.getReturnDate())
                .returnedAt(model.getReturnedAt())
                .book_id(model.getBook().getId())
                .user_id(model.getUser().getId())
                .build();
    }

    public LoanModel toModel(LoanDto dto, BookModel bookModel, UserModel userModel) {
        if (dto == null) {
            return null;
        }

        return LoanModel.builder()
                .id(dto.getId())
                .borrowedAt(dto.getBorrowedAt())
                .returnDate(dto.getReturnDate())
                .returnedAt(dto.getReturnedAt())
                .book(bookModel)
                .user(userModel)
                .build();
    }
}
