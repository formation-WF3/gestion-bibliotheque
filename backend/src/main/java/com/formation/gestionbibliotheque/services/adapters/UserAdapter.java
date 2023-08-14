package com.formation.gestionbibliotheque.services.adapters;

import com.formation.gestionbibliotheque.dtos.UserDto;
import com.formation.gestionbibliotheque.models.UserModel;

public class UserAdapter {

    public static UserDto toDto(UserModel model) {
        return UserDto.builder()
                .id(model.getId())
                .username(model.getUsername())
                .lastname(model.getLastname())
                .firstname(model.getFirstname())
                .password(model.getPassword())
                .email(model.getEmail())
                .emailVerified(model.isEmailVerified())
                .canBorrow(model.isCanBorrow())
                .penaltyAmount(model.getPenaltyAmount())
                .role(model.getRole())
                .build();
    }
}
