package com.formation.gestionbibliotheque.dtos;

import com.formation.gestionbibliotheque.models.enums.RoleEnum;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class RoleDto {
    private long id;
    private Enum<RoleEnum> name;
}
