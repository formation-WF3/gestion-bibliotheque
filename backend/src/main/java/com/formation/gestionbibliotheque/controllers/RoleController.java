package com.formation.gestionbibliotheque.controllers;

import com.formation.gestionbibliotheque.dtos.RoleDto;
import com.formation.gestionbibliotheque.services.RoleService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/roles")
public class RoleController {
    private RoleService roleService;

    @GetMapping
    public List<RoleDto> getAll() {
        return roleService.getAll();
    }

    @GetMapping("/{id}")
    public RoleDto getById(@PathVariable long id) {
        return roleService.getById(id);
    }
}
