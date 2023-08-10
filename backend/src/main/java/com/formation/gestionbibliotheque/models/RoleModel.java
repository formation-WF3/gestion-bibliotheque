package com.formation.gestionbibliotheque.models;

import com.formation.gestionbibliotheque.models.enums.RoleName;
import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table(name = "role")
public class RoleModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Enumerated(EnumType.STRING)
    @Column(length = 10, nullable = false)
    private RoleName name;
}
