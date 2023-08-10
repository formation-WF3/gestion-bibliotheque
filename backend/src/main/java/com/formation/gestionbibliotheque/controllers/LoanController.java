package com.formation.gestionbibliotheque.controllers;

import com.formation.gestionbibliotheque.dtos.LoanDto;
import com.formation.gestionbibliotheque.services.LoanService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/loans")
public class LoanController {
    private LoanService loanService;

    @GetMapping
    public List<LoanDto> getAll() {
        return loanService.getAll();
    }

    @GetMapping("/{id}")
    public LoanDto getById(@PathVariable String id) {
        return loanService.getById(id);
    }

}
