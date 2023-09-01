package com.formation.gestionbibliotheque.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.formation.gestionbibliotheque.models.enums.RoleEnum;
import com.formation.gestionbibliotheque.models.RoleModel;

@Repository
public interface RoleRepository extends JpaRepository<RoleModel, Long>{
    Optional<RoleModel> findByName(RoleEnum roleEnum);

}
