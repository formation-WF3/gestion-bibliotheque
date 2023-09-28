package com.formation.gestionbibliotheque.controllers;

import com.formation.gestionbibliotheque.dtos.LoanDto;

import com.formation.gestionbibliotheque.dtos.UserDto;

import com.formation.gestionbibliotheque.models.BookModel;
import com.formation.gestionbibliotheque.models.LoanModel;
import com.formation.gestionbibliotheque.models.UserModel;
import com.formation.gestionbibliotheque.payload.request.LoanRequest;
import com.formation.gestionbibliotheque.repositories.BookRepository;
import com.formation.gestionbibliotheque.repositories.LoanRepository;
import com.formation.gestionbibliotheque.repositories.UserRepository;
import com.formation.gestionbibliotheque.services.LoanService;
import com.formation.gestionbibliotheque.services.UserService;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/loans")
public class LoanController {
   
    private LoanService loanService;
    private UserService userService;

 
    // @GetMapping("/list")
    // public List<LoanDto> getAll() {
    //     return loanService.getAll();
    // }
    @GetMapping("/list")
    public ResponseEntity<List<LoanDto>> getAll() {
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
