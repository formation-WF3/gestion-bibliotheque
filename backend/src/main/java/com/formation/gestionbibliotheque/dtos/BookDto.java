package com.formation.gestionbibliotheque.dtos;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class BookDto {
    private long id;
    private String title;
    private String author;
    private int totalItems;
    private int remainingItems;
    private String categoryName;
}
