package com.formation.gestionbibliotheque.dtos;


import com.formation.gestionbibliotheque.models.enums.CategoryName;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class CategoryDto {
    private long id;
    private String name;
}
