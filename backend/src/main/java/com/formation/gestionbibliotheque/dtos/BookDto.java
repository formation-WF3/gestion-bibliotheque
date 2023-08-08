package com.formation.gestionbibliotheque.dtos;


import com.formation.gestionbibliotheque.models.CategoryModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class BookDto {
    private long id;
    private String title;
    private String author;
    private int total_items;
    private int remaining_items;
    private CategoryModel category;
}
