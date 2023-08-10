package com.formation.gestionbibliotheque.models;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;

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

    @CreatedDate
    @Column(name = "borrowed_at", nullable = false, updatable = false)
    private Date borrowedAt;

    @Column(name = "return_date", nullable = false, updatable = false)
    private Date returnDate;

    @Column(name = "returned_at")
    private Date returnedAt;

    @ManyToOne(optional = false)
    private BookModel book;

    @ManyToOne(optional = false)
    private UserModel user;
}
