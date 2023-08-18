package com.formation.gestionbibliotheque.services.adapters;

import com.formation.gestionbibliotheque.dtos.UserDto;
import com.formation.gestionbibliotheque.models.RoleModel;
import com.formation.gestionbibliotheque.models.UserModel;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class UserAdapter {

    public UserDto toDto(UserModel model) {
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
                .roleName(model.getRole().getName().toString())
                .build();
    }

    public UserModel toModel(UserDto dto, RoleModel roleModel) {
        if (dto == null) {
            return null;
        }

        return UserModel.builder()
                .id(dto.getId())
                .username(dto.getUsername())
                .lastname(dto.getLastname())
                .firstname(dto.getFirstname())
                .password(dto.getPassword())
                .email(dto.getEmail())
                .canBorrow(dto.isCanBorrow())
                .penaltyAmount(dto.getPenaltyAmount())
                .role(roleModel)
                .build();
    }
}
