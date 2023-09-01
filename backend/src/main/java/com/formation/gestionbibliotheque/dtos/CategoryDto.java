package com.formation.gestionbibliotheque.dtos;


import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class CategoryDto {
    private long id;
    private String name;
}
