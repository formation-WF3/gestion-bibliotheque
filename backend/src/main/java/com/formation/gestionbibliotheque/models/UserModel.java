package com.formation.gestionbibliotheque.models;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
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

    @Column(name = "email_verified", columnDefinition = "boolean default false")
    private boolean emailVerified;

    @Column(name = "can_borrow", columnDefinition = "boolean default false")
    private boolean canBorrow;

    @Column(name = "penalty_amount", nullable = false)
    private double penaltyAmount;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private RoleModel role;
}
