package com.formation.gestionbibliotheque.models;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name ="user")
public class UserModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(length = 30, nullable = false)
    private String username;

    @Column(length = 30, nullable = false)
    private String lastname;

    @Column(length = 30, nullable = false)
    private String firstname;

    @Column(nullable = false)
    private String password;

    @Column(length = 50, nullable = false)
    private String email;

    @Column(columnDefinition = "boolean default false")
    private boolean email_verified;

    @Column(columnDefinition = "boolean default false")
    private boolean can_borrow;

    @Column(nullable = false)
    private double penalty_amount;

    @ManyToOne(optional = false)
    private RoleModel role;
}
