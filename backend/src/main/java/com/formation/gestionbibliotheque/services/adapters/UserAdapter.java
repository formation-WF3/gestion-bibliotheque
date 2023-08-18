package com.formation.gestionbibliotheque.services.adapters;

import com.formation.gestionbibliotheque.dtos.UserDto;
import com.formation.gestionbibliotheque.models.Role;
import com.formation.gestionbibliotheque.models.User;
import lombok.AllArgsConstructor;

import java.util.Set;

import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class UserAdapter {

    public UserDto toDto(User model) {
        return UserDto.builder()
                .id(model.getId())
                .username(model.getUsername())
                .lastname(model.getlastname())
                .firstname(model.getfirstname())
                .password(model.getPassword())
                .email(model.getEmail())
                .emailVerified(model.isEmailVerified())
                .canBorrow(model.isCanBorrow())
                .penaltyAmount(model.getPenaltyAmount())
                .role(((Role) model.getRoles()).getName().toString())
                .build();
    }

    public User toModel(UserDto dto, Set<Role> role) {
        if (dto == null) {
            return null;
        }

        return User.builder()
                .id(dto.getId())
                .username(dto.getUsername())
                .lastname(dto.getLastname())
                .firstname(dto.getFirstname())
                .password(dto.getPassword())
                .email(dto.getEmail())
                .canBorrow(dto.isCanBorrow())
                .penaltyAmount(dto.getPenaltyAmount())
                .roles(role)
                .build();
    }

    public User toModel(UserDto userDto, Role roleModel) {
        return null;
    }
}
