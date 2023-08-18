package com.formation.gestionbibliotheque.dtos;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class UserDto {
    private long id;
    private String username;
    private String lastname;
    private String firstname;
    private String password;
    private String email;
    private boolean emailVerified;
    private boolean canBorrow;
    private double penaltyAmount;
    private String roleName;
}
