package com.formation.gestionbibliotheque.repositories;

import com.formation.gestionbibliotheque.models.CategoryModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository<CategoryModel, Long> {

    Optional<CategoryModel> findByNameIgnoreCase(String name);
}
