package com.formation.gestionbibliotheque.services;

import com.formation.gestionbibliotheque.dtos.UserDto;
import com.formation.gestionbibliotheque.models.enums.RoleEnum;
import com.formation.gestionbibliotheque.models.RoleModel;
import com.formation.gestionbibliotheque.models.UserModel;
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
        RoleModel roleModel = null;

        if (roleName != null) {
            roleModel = roleRepository.findByName(RoleEnum.valueOf(roleName))
                    .orElseThrow(() -> new RuntimeException("Role non trouvée !"));
        }

        UserModel userModel = userAdapter.toModel(userDto, roleModel);
        userModel = userRepository.save(userModel);
        userDto.setId(userModel.getId());
        return userDto;
    }

    public UserDto update(UserDto userDto) {
        String roleName = userDto.getRole();
        RoleModel roleModel = null;

        if (roleName != null) {
            roleModel = roleRepository.findByName(RoleEnum.valueOf(roleName))
                .orElseThrow(() -> new RuntimeException("Role non trouvé !"));
        }

        UserModel userModel = userAdapter.toModel(userDto, roleModel);
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

    public UserDto getByUsername(String username) {
        return userRepository.findByUsername(username)
                .map(userAdapter::toDto)
                .orElseThrow(() -> new RuntimeException("Utilisateur non trouvé !"));
    }
}
