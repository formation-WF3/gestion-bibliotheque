package com.formation.gestionbibliotheque.controllers;

import com.formation.gestionbibliotheque.dtos.BookDto;
import com.formation.gestionbibliotheque.models.BookModel;
import com.formation.gestionbibliotheque.services.BookService;
import lombok.AllArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/books")
public class BookController {
    private BookService bookService;

    @GetMapping("/list")
    public List<BookDto> getAll() {
        return bookService.getAll();
    }

    @PostMapping("/create")
    public BookDto add(@RequestBody BookDto bookDto) {
        return bookService.add(bookDto);
    }

    @PutMapping("/update/{id}")
    public BookDto update(@RequestBody BookDto bookDto) {
        return bookService.update(bookDto);
    }
    @DeleteMapping("delete/{id}")
    public String delete(@PathVariable long id) {
        return bookService.delete(id);
    }

    @GetMapping("/id/{id}")
    public BookDto getById(@PathVariable long id) {
        // long idLong = Long.parseLong(id);
        return bookService.getById(id);
    }

    @GetMapping("/title/{title}")
    public BookDto getByTitle(@PathVariable String title) {
        return bookService.getByTitle(title);
    }

    @GetMapping("/term/{term}")
    public List<BookModel> getByTerm( @PathVariable String term) {
       return bookService.getByTerm(term);
       
    }
    @GetMapping("/totalitems")
    public ResponseEntity<Integer> getTotalItems() {
        int totalCopies = bookService.calculateTotalItems(null); // Vous devrez créer cette méthode dans votre service.
        return ResponseEntity.ok(totalCopies);
    }


}
