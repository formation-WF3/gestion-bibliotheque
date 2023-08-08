package com.formation.gestionbibliotheque.models;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "book")
public class BookModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(length = 60, nullable = false)
    private String title;

    @Column(length = 50, nullable = false)
    private String author;

    @Column(nullable = false)
    private int total_items;

    @Column(nullable = false)
    private int remaining_items;

    @ManyToOne(optional = false)
    private CategoryModel category;
}
