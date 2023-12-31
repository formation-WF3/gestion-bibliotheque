package com.formation.gestionbibliotheque.payload.request;
import java.time.LocalDate;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class LoanRequest {
    @NotBlank
    private Long user_id;
    @NotBlank
    private Long book_id;
    
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

   public LoanRequest(@NotBlank Long user_id, @NotBlank Long book_id) {
		super();
		this.user_id = user_id;
		this.book_id = book_id;
	}

public LoanRequest() {
}
   
}
