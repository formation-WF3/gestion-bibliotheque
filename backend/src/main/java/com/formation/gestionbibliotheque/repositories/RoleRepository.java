package com.formation.gestionbibliotheque.repositories;

import com.formation.gestionbibliotheque.models.RoleModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<RoleModel, Long> {
}
