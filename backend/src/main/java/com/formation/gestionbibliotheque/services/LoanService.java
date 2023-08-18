package com.formation.gestionbibliotheque.services;

import com.formation.gestionbibliotheque.dtos.LoanDto;
import com.formation.gestionbibliotheque.repositories.LoanRepository;
import com.formation.gestionbibliotheque.services.adapters.LoanAdapter;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Service
public class LoanService {
    private LoanRepository loanRepository;

    public List<LoanDto> getAll() {
        List<LoanDto> loanDtos = new ArrayList<>();
        loanRepository.findAll().forEach(
                model -> loanDtos.add(LoanAdapter.toDto(model))
        );
        return loanDtos;
    }

    public LoanDto getById(long id) {
        return loanRepository.findById(id)
                .map(LoanAdapter::toDto)
                .orElseThrow(() -> new RuntimeException("Emprunt non trouvé !"));
    }
}
