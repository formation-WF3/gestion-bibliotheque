package com.formation.gestionbibliotheque.services.adapters;

import com.formation.gestionbibliotheque.dtos.RoleDto;
import com.formation.gestionbibliotheque.models.RoleModel;

public class RoleAdapter {

    public static RoleDto toDto(RoleModel model) {
        return RoleDto.builder()
                .id(model.getId())
                .name(model.getName())
                .build();
    }
}
