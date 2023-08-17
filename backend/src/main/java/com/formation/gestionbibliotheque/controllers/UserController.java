package com.formation.gestionbibliotheque.controllers;

import com.formation.gestionbibliotheque.dtos.UserDto;
import com.formation.gestionbibliotheque.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/users")
public class UserController {
    private UserService userService;

    @GetMapping
    public List<UserDto> getAll() {
        return userService.getAll();
    }

    @PostMapping
    public UserDto add(@RequestBody UserDto userDto) {
        return userService.add(userDto);
    }

    @PutMapping
    public UserDto update(@RequestBody UserDto userDto) {
        return userService.update(userDto);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable long id) {
        return userService.delete(id);
    }

    @GetMapping("/{id}")
    public UserDto getById(@PathVariable long id) {
        return userService.getById(id);
    }

}
