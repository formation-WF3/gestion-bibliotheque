package com.formation.gestionbibliotheque.models;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Date;
import java.time.Instant;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
@Entity
@Table(name = "loan")
public class LoanModel {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @CreationTimestamp
    @Column(name = "borrowed_at", nullable = false)
    private LocalDate borrowedAt;

    @Column(name = "return_date")
    private LocalDate returnDate;

    @Column(name = "returned_at")
    private LocalDate returnedAt;

    @ManyToOne(optional = false)
    @JoinColumn(name = "book_id")
    private BookModel book;

    @ManyToOne(optional = false)
    @JoinColumn(name = "user_id")
    private UserModel user;

    public void setUser(Object user_id) {
    }

    public void setBook(Object book_id) {
    }


}
