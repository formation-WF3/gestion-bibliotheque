package com.formation.gestionbibliotheque.repositories;

import com.formation.gestionbibliotheque.models.BookModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface BookRepository extends JpaRepository<BookModel, Long> {

    Optional<BookModel> findByTitleIgnoreCase(String title);
    // Optional<BookModel> findByTermIgnoreCase(String term);
    @Query(value = "SELECT * FROM book WHERE CONCAT(title, author) LIKE %?1%", nativeQuery = true)
    List<BookModel> findBysearch(String term);
   
}
