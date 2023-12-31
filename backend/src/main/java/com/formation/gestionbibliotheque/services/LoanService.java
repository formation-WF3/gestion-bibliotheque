package com.formation.gestionbibliotheque.services;

import com.formation.gestionbibliotheque.dtos.LoanDto;
import com.formation.gestionbibliotheque.models.BookModel;
import com.formation.gestionbibliotheque.models.LoanModel;
import com.formation.gestionbibliotheque.models.UserModel;
import com.formation.gestionbibliotheque.repositories.BookRepository;
import com.formation.gestionbibliotheque.repositories.LoanRepository;
import com.formation.gestionbibliotheque.repositories.UserRepository;
import com.formation.gestionbibliotheque.services.adapters.LoanAdapter;

import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class LoanService {
    private LoanRepository loanRepository;

    private LoanAdapter loanAdapter;

    private BookRepository bookRepository;

    private UserRepository userRepository;

    public List<LoanDto> getAll() {
        List<LoanDto> loanDtos = new ArrayList<>();
        loanRepository.findAll().forEach(
                model -> loanDtos.add(loanAdapter.toDto(model))
        );
        return loanDtos;
    }
    public List<LoanDto> getAllByUser() {

        UserModel currentUser = userRepository.findByUsername(SecurityContextHolder.getContext().getAuthentication().getName());
        List<LoanModel> loanList = loanRepository.findByUser(currentUser); 
        return loanList.stream().map(loanAdapter::toDto)
        .collect(Collectors.toList());
    }
    public LoanDto emprunt(LoanDto loanDto) {
        UserModel user = userRepository.findById(loanDto.getUser_id()).orElseThrow(() -> new EntityNotFoundException("Utilisateur introuvable"));
        BookModel book = bookRepository.findById(loanDto.getBook_id()).orElseThrow(() -> new EntityNotFoundException("Livre introuvable"));
        if (book.getTotalItems() <= 0) {
            throw new RuntimeException("Aucun exemplaire disponible pour ce livre");
        }
        LoanModel loan = loanAdapter.toModel(loanDto, book, user);
        loan.setReturnDate(LocalDate.now().plusDays(14));
        // Décrémenter le nombre d'exemplaires disponibles
        book.setTotalItems(book.getTotalItems() - 1);
        bookRepository.save(book);
        loan = loanRepository.save(loan);

        return loanAdapter.toDto(loan);
    }

    public LoanDto retour(LoanDto loanDto) {
        UserModel user = userRepository.findById(loanDto.getUser_id())
                .orElseThrow(() -> new EntityNotFoundException("Utilisateur introuvable"));
        BookModel book = bookRepository.findById(loanDto.getBook_id())
                .orElseThrow(() -> new EntityNotFoundException("Livre introuvable"));
    
        LoanModel loan = loanAdapter.toModel(loanDto, book, user);
    
        // Incrémenter le nombre d'exemplaires disponibles
        book.setTotalItems(book.getTotalItems() + 1);
        bookRepository.save(book);
    
        // Mettre à jour la date de retour dans l'emprunt
        loan.setReturnDate(LocalDate.now());
        loanRepository.save(loan);
    
        return loanAdapter.toDto(loan);
    }

    public LoanDto add(LoanDto loanDto) {
        Long book_id = loanDto.getBook_id();
        Long user_id = loanDto.getUser_id();
        BookModel bookModel = null;
        UserModel userModel = null;

        if (book_id != null) {
            bookModel = bookRepository.findById(book_id).orElseThrow(() -> new RuntimeException("Livre non trouvé !"));
        }
        if (user_id != null) {
            userModel = userRepository.findById(user_id)
                    .orElseThrow(() -> new RuntimeException("Utilisateur non trouvé !"));
        }

        LoanModel loanModel = loanAdapter.toModel(loanDto, bookModel, userModel);
        loanModel = loanRepository.save(loanModel);
        loanDto.setId(loanModel.getId());
        return loanDto;
    }
   
    public LoanDto update(LoanDto loanDto) {
        Long book_id = loanDto.getBook_id();
        Long user_id = loanDto.getUser_id();
        BookModel bookModel = null;
        UserModel userModel = null;

        if (book_id != null) {
            bookModel = bookRepository.findById(book_id).orElseThrow(() -> new RuntimeException("Livre non trouvé !"));
        }
        if (user_id != null) {
            userModel = userRepository.findById(user_id)
                    .orElseThrow(() -> new RuntimeException("Utilisateur non trouvé !"));
        }

        LoanModel loanModel = loanAdapter.toModel(loanDto, bookModel, userModel);
        return loanRepository.findById(loanDto.getId())
                .map(l -> loanAdapter.toDto(loanRepository.save(loanModel)))
                .orElseThrow(() -> new RuntimeException("Emprunt non trouvé !"));
    }

    public String delete(long id) {
        if (loanRepository.findById(id).isEmpty()) {
            throw new RuntimeException("Emprunt non trouvé !");
        } else {
            loanRepository.deleteById(id);
            return "Emprunt supprimé !";
        }
    }

    public LoanDto getById(long id) {
        return loanRepository.findById(id)
                .map(loanAdapter::toDto)
                .orElseThrow(() -> new RuntimeException("Emprunt non trouvé !"));
    }
}
