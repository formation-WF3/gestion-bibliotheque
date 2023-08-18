package com.formation.gestionbibliotheque.services.adapters;

import com.formation.gestionbibliotheque.dtos.RoleDto;
import com.formation.gestionbibliotheque.models.Role;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class RoleAdapter {

    public RoleDto toDto(Role model) {
        return RoleDto.builder()
                .id(model.getId())
                .name(model.getName().toString())
                .build();
    }
}
