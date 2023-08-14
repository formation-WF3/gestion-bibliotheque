package com.formation.gestionbibliotheque.models;

import com.formation.gestionbibliotheque.models.enums.CategoryName;
import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
@Entity
@Table(name = "category")
public class CategoryModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(unique = true, length = 30, nullable = false)
    private String name;

}
