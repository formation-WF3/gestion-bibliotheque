package com.formation.gestionbibliotheque.security.services;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface UserdetailService {
    UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;
}
