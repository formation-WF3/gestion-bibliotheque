package com.formation.gestionbibliotheque.repositories;

import com.formation.gestionbibliotheque.models.LoanModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoanRepository extends JpaRepository<LoanModel, String> {
}
