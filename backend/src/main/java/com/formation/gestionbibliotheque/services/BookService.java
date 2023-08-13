package com.formation.gestionbibliotheque.services;

import com.formation.gestionbibliotheque.dtos.BookDto;
import com.formation.gestionbibliotheque.models.BookModel;
import com.formation.gestionbibliotheque.models.CategoryModel;
import com.formation.gestionbibliotheque.repositories.BookRepository;
import com.formation.gestionbibliotheque.repositories.CategoryRepository;
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

    public BookDto add(BookDto bookDto) {
        String categoryName = bookDto.getCategoryName();
        CategoryModel categoryModel = null;

        if (categoryName != null) {
            categoryModel = categoryRepository.findByNameIgnoreCase(categoryName)
                    .orElseThrow(() -> new RuntimeException("Categorie non trouvée !"));
        }

        BookModel bookModel = bookAdapter.toModel(bookDto, categoryModel);
        bookModel = bookRepository.save(bookModel);
        bookDto.setId(bookModel.getId());
        return bookDto;
    }

    public BookDto update(BookDto bookDto) {
        String categoryName = bookDto.getCategoryName();
        CategoryModel categoryModel = null;

        if (categoryName != null) {
            categoryModel = categoryRepository.findByNameIgnoreCase(categoryName)
                    .orElseThrow(() -> new RuntimeException("Categorie non trouvée !"));
        }

        BookModel bookModel = bookAdapter.toModel(bookDto, categoryModel);
        return bookRepository.findById(bookDto.getId())
                .map(b -> bookAdapter.toDto(bookRepository.save(bookModel)))
                .orElseThrow(() -> new RuntimeException("Livre non trouvé !"));
    }

    public String delete(long id) {
        if (bookRepository.findById(id).isEmpty()) {
            throw new RuntimeException("Livre non trouvé !");
        } else {
            bookRepository.deleteById(id);
            return "Livre supprimé !";
        }
    }

    public BookDto getById(long id) {
        return bookRepository.findById(id)
                .map(BookAdapter::toDto)
                .orElseThrow(() -> new RuntimeException("Livre non trouvé !"));
    }
}
