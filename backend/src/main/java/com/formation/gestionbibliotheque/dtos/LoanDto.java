package com.formation.gestionbibliotheque.dtos;
import lombok.*;
import java.time.Instant;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class LoanDto {
    private long id;
    private Instant borrowedAt;
    private Instant returnDate;
    private Instant returnedAt;
    private Long book_id;
    private Long user_id;
}
