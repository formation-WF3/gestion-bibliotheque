package com.formation.gestionbibliotheque.controllers;

import com.formation.gestionbibliotheque.dtos.LoanDto;
import com.formation.gestionbibliotheque.services.LoanService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping
    public LoanDto add(@RequestBody LoanDto loanDto) {
        return loanService.add(loanDto);
    }

    @PutMapping
    public LoanDto update(@RequestBody LoanDto loanDto) {
        return loanService.update(loanDto);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable long id) {
        return loanService.delete(id);
    }

    @GetMapping("/{id}")
    public LoanDto getById(@PathVariable long id) {
        return loanService.getById(id);
    }

}
