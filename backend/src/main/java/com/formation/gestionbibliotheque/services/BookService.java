package com.formation.gestionbibliotheque.services;

import com.formation.gestionbibliotheque.dtos.BookDto;
import com.formation.gestionbibliotheque.dtos.LoanDto;
import com.formation.gestionbibliotheque.models.BookModel;
import com.formation.gestionbibliotheque.models.CategoryModel;
import com.formation.gestionbibliotheque.models.LoanModel;
import com.formation.gestionbibliotheque.models.UserModel;
import com.formation.gestionbibliotheque.repositories.BookRepository;
import com.formation.gestionbibliotheque.repositories.CategoryRepository;
import com.formation.gestionbibliotheque.services.adapters.BookAdapter;

import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@AllArgsConstructor
@Service
public class BookService {

    private BookRepository bookRepository;

    private BookAdapter bookAdapter;

    private CategoryRepository categoryRepository;


    public List<BookDto> getAll() {
        List<BookDto> bookDtos = new ArrayList<>();
        bookRepository.findAll().forEach(
                model -> bookDtos.add(bookAdapter.toDto(model))
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
                .map(bookAdapter::toDto)
                .orElseThrow(() -> new RuntimeException("Livre non trouvé !"));
    }

    public BookDto getByTitle(String title) {
        return bookRepository.findByTitleIgnoreCase(title)
                .map(bookAdapter::toDto)
                .orElseThrow(() -> new RuntimeException("Livre non trouvé !"));
    }
   
    public List<BookModel> getByTerm(String term) {
        if (!term.isEmpty()) {
           List<BookModel> listBook =  bookRepository.findBysearch(term);
           if(listBook.isEmpty()) {
               throw new RuntimeException("Pas de livre trouvé");
           }
           return listBook;
        }
        return bookRepository.findAll();
    }
   
    public int calculateTotalItems(Long id) {
        BookDto bookModel = bookRepository.findById(id)
                .map(bookAdapter::toDto)
                .orElseThrow(() -> new RuntimeException("Livre non trouvé !"));
        return bookModel.getRemainingItems();
    }

}
