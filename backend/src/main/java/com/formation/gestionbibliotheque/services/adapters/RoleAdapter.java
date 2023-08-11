package com.formation.gestionbibliotheque.services.adapters;

import com.formation.gestionbibliotheque.dtos.RoleDto;
import com.formation.gestionbibliotheque.models.RoleModel;

public class RoleAdapter {

    public static RoleDto toDto(RoleModel model) {
        RoleDto dto = new RoleDto();
        dto.setId(model.getId());
        dto.setName(model.getName());
        return dto;
    }
}
