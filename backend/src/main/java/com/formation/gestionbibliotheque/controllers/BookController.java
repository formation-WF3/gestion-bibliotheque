package com.formation.gestionbibliotheque.controllers;

import com.formation.gestionbibliotheque.dtos.BookDto;
import com.formation.gestionbibliotheque.models.BookModel;
import com.formation.gestionbibliotheque.services.BookService;
import org.springframework.ui.Model;
import lombok.AllArgsConstructor;

import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/books")
public class BookController {
    private BookService bookService;

    @GetMapping
    public List<BookDto> getAll() {
        return bookService.getAll();
    }

    @PostMapping
    public BookDto add(@RequestBody BookDto bookDto) {
        return bookService.add(bookDto);
    }

    @PutMapping
    public BookDto update(@RequestBody BookDto bookDto) {
        return bookService.update(bookDto);
    }

    @DeleteMapping("/{id}")
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
    public BookDto getByTerm(@PathVariable String term) {
       return bookService.getByTerm(term);
          
       
    }

}
