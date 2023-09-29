package com.formation.gestionbibliotheque.controllers;

import com.formation.gestionbibliotheque.dtos.LoanDto;
import com.formation.gestionbibliotheque.services.LoanService;
import com.formation.gestionbibliotheque.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/loans")
public class LoanController {
   
    private LoanService loanService;

    @GetMapping("/my-loans")
    public ResponseEntity<List<LoanDto>> getAll() {
        List<LoanDto> loans = loanService.getAllByUser();
        return new ResponseEntity<>(loans, HttpStatus.OK);
    }
    @GetMapping("/list")
    public ResponseEntity<List<LoanDto>> getAll2() {
        List<LoanDto> loans = loanService.getAll();
        return new ResponseEntity<>(loans, HttpStatus.OK);
    }
    @PostMapping("/create")
    public ResponseEntity<LoanDto> emprunterLivre(@RequestBody LoanDto loanDto) {
        LoanDto loan = loanService.emprunt(loanDto);


        return new ResponseEntity<>(loan, HttpStatus.CREATED);
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

    @GetMapping("/id/{id}")
    public LoanDto getById(@PathVariable long id) {
        return loanService.getById(id);
    }

}
