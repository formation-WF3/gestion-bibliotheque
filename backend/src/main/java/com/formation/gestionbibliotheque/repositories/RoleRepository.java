package com.formation.gestionbibliotheque.repositories;

<<<<<<< HEAD
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.formation.gestionbibliotheque.models.ERole;
import com.formation.gestionbibliotheque.models.Role;


@Repository
public interface RoleRepository extends JpaRepository<Role, Long>{
    Optional<Role> findByName(ERole name);
=======
import com.formation.gestionbibliotheque.models.RoleModel;
import com.formation.gestionbibliotheque.models.enums.RoleEnum;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<RoleModel, Long> {

    Optional<RoleModel> findByName(RoleEnum name);
>>>>>>> develop
}
