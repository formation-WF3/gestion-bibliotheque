package com.formation.gestionbibliotheque.services;

import com.formation.gestionbibliotheque.dtos.RoleDto;
import com.formation.gestionbibliotheque.models.ERole;
import com.formation.gestionbibliotheque.repositories.RoleRepository;
import com.formation.gestionbibliotheque.services.adapters.RoleAdapter;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Service
public class RoleService {
    private RoleRepository roleRepository;

    private RoleAdapter roleAdapter;

    public List<RoleDto> getAll() {
        List<RoleDto> roleDtos = new ArrayList<>();
        roleRepository.findAll().forEach(
                model -> roleDtos.add(roleAdapter.toDto(model))
        );
        return roleDtos;
    }

    public RoleDto getById(long id) {
        return roleRepository.findById(id)
                .map(roleAdapter::toDto)
                .orElseThrow(() -> new RuntimeException("Role non trouvé !"));
    }

    public RoleDto getByName(String name) {
        return roleRepository.findByName(ERole.valueOf(name))
                .map(roleAdapter::toDto)
                .orElseThrow(() -> new RuntimeException("Role non trouvé !"));
    }
}
