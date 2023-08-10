package com.formation.gestionbibliotheque.services.adapters;

import com.formation.gestionbibliotheque.dtos.UserDto;
import com.formation.gestionbibliotheque.models.UserModel;

public class UserAdapter {

    public static UserDto toDto(UserModel model) {
        UserDto dto = new UserDto();
        dto.setId(model.getId());
        dto.setUsername(model.getUsername());
        dto.setLastname(model.getLastname());
        dto.setFirstname(model.getFirstname());
        dto.setPassword(model.getPassword());
        dto.setEmail(model.getEmail());
        dto.setEmailVerified(model.isEmailVerified());
        dto.setCanBorrow(model.isCanBorrow());
        dto.setPenaltyAmount(model.getPenaltyAmount());
        dto.setRole(model.getRole());
        return dto;
    }
}
