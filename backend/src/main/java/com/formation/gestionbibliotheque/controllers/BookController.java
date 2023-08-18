package com.formation.gestionbibliotheque.controllers;

import com.formation.gestionbibliotheque.dtos.BookDto;
import com.formation.gestionbibliotheque.services.BookService;
import lombok.AllArgsConstructor;
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

    @GetMapping("/{id}")
    public BookDto getById(@PathVariable long id) {
        return bookService.getById(id);
    }

}
