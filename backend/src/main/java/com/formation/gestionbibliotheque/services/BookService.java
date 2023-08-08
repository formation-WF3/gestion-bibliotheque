package com.formation.gestionbibliotheque.services;

import com.formation.gestionbibliotheque.dtos.BookDto;
import com.formation.gestionbibliotheque.repositories.BookRepository;
import com.formation.gestionbibliotheque.services.adapters.BookAdapter;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Service
public class BookService {
    private BookRepository bookRepository;

    public List<BookDto> getAll() {
        List<BookDto> bookDtos = new ArrayList<>();
        bookRepository.findAll().forEach(
                model -> bookDtos.add(BookAdapter.toDto(model))
        );
        return bookDtos;
    }
}
