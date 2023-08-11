package com.formation.gestionbibliotheque.repositories;

import com.formation.gestionbibliotheque.models.CategoryModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<CategoryModel, Long> {
}
