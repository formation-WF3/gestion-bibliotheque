package com.formation.gestionbibliotheque.models;

import com.formation.gestionbibliotheque.models.enums.RoleEnum;
import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
@Entity
@Table(name = "role")
public class RoleModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Enumerated(EnumType.STRING)
    @Column(unique = true, length = 10, nullable = false)
    private RoleEnum name;
}
