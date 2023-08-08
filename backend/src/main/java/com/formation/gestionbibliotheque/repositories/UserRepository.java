package com.formation.gestionbibliotheque.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.formation.gestionbibliotheque.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
    
}
