package com.formation.gestionbibliotheque.models;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.Instant;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "loan")
public class LoanModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @CreationTimestamp
    @Column(name = "borrowed_at", nullable = false)
    private Instant borrowedAt;

    @Column(name = "return_date")
    private Instant returnDate;

    @Column(name = "returned_at")
    private Instant returnedAt;

    @ManyToOne(optional = false)
    private BookModel book;

    @ManyToOne(optional = false)
    private UserModel user;
}
