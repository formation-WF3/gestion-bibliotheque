package com.formation.gestionbibliotheque.services;

import com.formation.gestionbibliotheque.dtos.RoleDto;
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

    public List<RoleDto> getAll() {
        List<RoleDto> roleDtos = new ArrayList<>();
        roleRepository.findAll().forEach(
                model -> roleDtos.add(RoleAdapter.toDto(model))
        );
        return roleDtos;
    }

    public RoleDto getById(long id) {
        return roleRepository.findById(id)
                .map(RoleAdapter::toDto)
                .orElseThrow(() -> new RuntimeException("Role non trouvé !"));
    }
}
