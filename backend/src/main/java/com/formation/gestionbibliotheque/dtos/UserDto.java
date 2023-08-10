package com.formation.gestionbibliotheque.dtos;

import com.formation.gestionbibliotheque.models.RoleModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserDto {
    private long id;
    private String username;
    private String lastname;
    private String firstname;
    private String password;
    private String email;
    private boolean email_verified;
    private boolean can_borrow;
    private double penalty_amount;
    private RoleModel role;
}
