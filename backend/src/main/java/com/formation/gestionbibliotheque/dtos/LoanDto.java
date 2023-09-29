package com.formation.gestionbibliotheque.dtos;
import lombok.*;

import java.sql.Date;
import java.time.Instant;
import java.time.LocalDate;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class LoanDto {
    private long id;
    private LocalDate borrowedAt;
    private LocalDate returnDate;
    private LocalDate returnedAt;
    private Long book_id;
    private String title;
    private Long user_id;
}
