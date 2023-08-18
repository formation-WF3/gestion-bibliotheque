package com.formation.gestionbibliotheque.repositories;

import com.formation.gestionbibliotheque.models.BookModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<BookModel, Long> {
}
