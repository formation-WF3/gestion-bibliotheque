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
@Builder
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
    @JoinColumn(name = "book_id")
    private BookModel book;

    @ManyToOne(optional = false)
    @JoinColumn(name = "user_id")
    private UserModel user;

    public void setUser_id(Long user_id2) {
    }

    public void setBook_id(Long book_id2) {
    }

}
