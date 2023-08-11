package com.formation.gestionbibliotheque.repositories;

import com.formation.gestionbibliotheque.models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserModel, Long> {
}
