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

    @Column(name = "total_items", nullable = false)
    private int totalItems;

    @Column(name = "remaining_items", nullable = false)
    private int remainingItems;

    @ManyToOne(optional = false)
    private CategoryModel category;
}
