package com.formation.gestionbibliotheque.controllers;

import com.formation.gestionbibliotheque.dtos.LoanDto;
import com.formation.gestionbibliotheque.models.BookModel;
import com.formation.gestionbibliotheque.models.LoanModel;
import com.formation.gestionbibliotheque.models.UserModel;
import com.formation.gestionbibliotheque.payload.request.LoanRequest;
import com.formation.gestionbibliotheque.repositories.BookRepository;
import com.formation.gestionbibliotheque.repositories.LoanRepository;
import com.formation.gestionbibliotheque.repositories.UserRepository;
import com.formation.gestionbibliotheque.services.LoanService;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/loans")
public class LoanController {
     private final UserRepository userRepository;
    private final BookRepository bookRepository;
    private final LoanRepository loanRepository;
    private LoanService loanService;

    @GetMapping("/list")
    public List<LoanDto> getAll() {
        return loanService.getAll();
    }
    @PostMapping("/create")
    public ResponseEntity<String> emprunterLivre(@RequestBody LoanRequest empruntRequest) {
        UserModel user = userRepository.findById(empruntRequest.getUser_id())
            .orElseThrow(() -> new EntityNotFoundException("Utilisateur non trouvé"));

        BookModel book = bookRepository.findById(empruntRequest.getBook_id())
            .orElseThrow(() -> new EntityNotFoundException("Livre non trouvé"));

        LoanModel emprunt = new LoanModel();
        emprunt.setUser(user);
        emprunt.setBook(book);
        emprunt.setBorrowedAt(empruntRequest.getBorrowedAt());
        emprunt.setReturnDate(empruntRequest.getReturnDate());

        loanRepository.save(emprunt);

        return ResponseEntity.ok("Emprunt créé avec succès");
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
