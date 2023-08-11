package com.formation.gestionbibliotheque.dtos;

import com.formation.gestionbibliotheque.models.enums.RoleName;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class RoleDto {
    private long id;
    private Enum<RoleName> name;
}
