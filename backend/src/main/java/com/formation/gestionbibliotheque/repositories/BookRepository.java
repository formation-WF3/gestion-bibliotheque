package com.formation.gestionbibliotheque.repositories;

import com.formation.gestionbibliotheque.models.BookModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BookRepository extends JpaRepository<BookModel, Long> {

    Optional<BookModel> findByTitleIgnoreCase(String title);
}
