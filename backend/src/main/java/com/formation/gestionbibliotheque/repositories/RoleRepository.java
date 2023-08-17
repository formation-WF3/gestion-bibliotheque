package com.formation.gestionbibliotheque.repositories;

import com.formation.gestionbibliotheque.models.RoleModel;
import com.formation.gestionbibliotheque.models.enums.RoleEnum;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<RoleModel, Long> {

    Optional<RoleModel> findByName(RoleEnum name);
}
