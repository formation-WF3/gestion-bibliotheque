package com.formation.gestionbibliotheque.services;

import com.formation.gestionbibliotheque.dtos.LoanDto;
import com.formation.gestionbibliotheque.models.BookModel;
import com.formation.gestionbibliotheque.models.LoanModel;
import com.formation.gestionbibliotheque.models.UserModel;
import com.formation.gestionbibliotheque.repositories.BookRepository;
import com.formation.gestionbibliotheque.repositories.LoanRepository;
import com.formation.gestionbibliotheque.repositories.UserRepository;
import com.formation.gestionbibliotheque.services.adapters.LoanAdapter;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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

    public LoanDto add(LoanDto loanDto) {
        String bookTitle = loanDto.getBookTitle();
        String userUsername = loanDto.getUserUsername();
        BookModel bookModel = null;
        UserModel userModel = null;

        if (bookTitle != null) {
            bookModel = bookRepository.findByTitleIgnoreCase(bookTitle).orElseThrow(() -> new RuntimeException("Livre non trouvé !"));
        }
        if (userUsername != null) {
            userModel = userRepository.findByUsername(userUsername)
                    .orElseThrow(() -> new RuntimeException("Utilisateur non trouvé !"));
        }

        LoanModel loanModel = loanAdapter.toModel(loanDto, bookModel, userModel);
        loanModel = loanRepository.save(loanModel);
        loanDto.setId(loanModel.getId());
        return loanDto;
    }

    public LoanDto update(LoanDto loanDto) {
        String bookTitle = loanDto.getBookTitle();
        String userUsername = loanDto.getUserUsername();
        BookModel bookModel = null;
        UserModel userModel = null;

        if (bookTitle != null) {
            bookModel = bookRepository.findByTitleIgnoreCase(bookTitle).orElseThrow(() -> new RuntimeException("Livre non trouvé !"));
        }
        if (userUsername != null) {
            userModel = userRepository.findByUsername(userUsername)
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
