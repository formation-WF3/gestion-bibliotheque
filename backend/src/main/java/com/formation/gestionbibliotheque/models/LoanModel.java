package com.formation.gestionbibliotheque.models;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Date;

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

    @Column(name = "borrowed_at", nullable = false, updatable = false)
    private Date borrowedAt = new Date();
//    private Date borrowedAt = LocalDateTime.now();

    @Column(name = "return_date")
    private Date returnDate;

    @Column(name = "returned_at")
    private Date returnedAt;

    @ManyToOne(optional = false)
    private BookModel book;

    @ManyToOne(optional = false)
    private UserModel user;
}
