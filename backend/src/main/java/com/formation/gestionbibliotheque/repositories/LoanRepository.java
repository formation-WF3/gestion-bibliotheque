package com.formation.gestionbibliotheque.repositories;

import com.formation.gestionbibliotheque.models.LoanModel;
import com.formation.gestionbibliotheque.payload.request.LoanRequest;

import org.springframework.data.jpa.repository.JpaRepository;

public interface LoanRepository extends JpaRepository<LoanModel, Long> {

    LoanRequest save(LoanRequest loanmodel);
    
}
