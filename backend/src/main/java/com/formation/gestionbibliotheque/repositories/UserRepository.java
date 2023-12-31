package com.formation.gestionbibliotheque.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.formation.gestionbibliotheque.models.UserModel;

@Repository
public interface UserRepository extends JpaRepository<UserModel, Long> {

    UserModel findByUsername(String username);

    Boolean existsByUsername(String username);

    Boolean existsByEmail(String email);

}
