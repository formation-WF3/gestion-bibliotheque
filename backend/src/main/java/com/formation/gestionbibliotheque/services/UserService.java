package com.formation.gestionbibliotheque.services;

import com.formation.gestionbibliotheque.dtos.UserDto;
import com.formation.gestionbibliotheque.models.ERole;
import com.formation.gestionbibliotheque.models.Role;
import com.formation.gestionbibliotheque.models.User;
import com.formation.gestionbibliotheque.repositories.RoleRepository;
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

    private UserAdapter userAdapter;

    private RoleRepository roleRepository;

    public List<UserDto> getAll() {
        List<UserDto> userDtos = new ArrayList<>();
        userRepository.findAll().forEach(
                model -> userDtos.add(userAdapter.toDto(model))
        );
        return userDtos;
    }

    public UserDto add(UserDto userDto) {
        String roleName = userDto.getRole();
        Role roleModel = null;

        if (roleName != null) {
            roleModel = roleRepository.findByName(ERole.valueOf(roleName))
                    .orElseThrow(() -> new RuntimeException("Role non trouvée !"));
        }

        User userModel = userAdapter.toModel(userDto, roleModel);
        userModel = userRepository.save(userModel);
        userDto.setId(userModel.getId());
        return userDto;
    }

    public UserDto update(UserDto userDto) {
        String roleName = userDto.getRole();
        Role roleModel = null;

        if (roleName != null) {
            roleModel = roleRepository.findByName(ERole.valueOf(roleName))
                .orElseThrow(() -> new RuntimeException("Role non trouvé !"));
        }

        User userModel = userAdapter.toModel(userDto, roleModel);
        return userRepository.findById(userDto.getId())
                .map(u -> userAdapter.toDto(userRepository.save(userModel)))
                .orElseThrow(() -> new RuntimeException("Utilisateur non trouvé !"));
    }

    public String delete(long id) {
        if (userRepository.findById(id).isEmpty()) {
            throw new RuntimeException("Utilisateur non trouvé !");
        } else {
            userRepository.deleteById(id);
            return "Utilisateur supprimé !";
        }
    }

    public UserDto getById(long id) {
        return userRepository.findById(id)
                .map(userAdapter::toDto)
                .orElseThrow(() -> new RuntimeException("Utilisateur non trouvé !"));
    }
}
