package com.formation.gestionbibliotheque.services;

import com.formation.gestionbibliotheque.dtos.UserDto;
import com.formation.gestionbibliotheque.repositories.UserRepository;
import com.formation.gestionbibliotheque.services.adapters.UserAdapter;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Service
public class UserService {
    private UserRepository userRepository;

    public List<UserDto> getAll() {
        List<UserDto> userDtos = new ArrayList<>();
        userRepository.findAll().forEach(
                model -> userDtos.add(UserAdapter.toDto(model))
        );
        return userDtos;
    }

    public UserDto getById(String id) {
        return userRepository.findById(id)
                .map(UserAdapter::toDto)
                .orElseThrow(() -> new RuntimeException("Utilisateur non trouvé !"));
    }
}
