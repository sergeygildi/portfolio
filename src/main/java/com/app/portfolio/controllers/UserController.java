package com.app.portfolio.controllers;

import com.app.portfolio.exceptions.EntityErrorResponse;
import com.app.portfolio.exceptions.EntityNotFoundException;
import com.app.portfolio.model.Quotes;
import com.app.portfolio.model.User;
import com.app.portfolio.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService service;

    @Autowired
    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping(value = "/")
    public ResponseEntity<List<Quotes>> getAll() {
        Optional<List<User>> quotes = service.getAll();
        return quotes.isPresent() ?
                new ResponseEntity(quotes, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/portfolio")
    public Optional<List> usersWithPortfolio() {
        return service.getUsersWithPortfolio();
    }

    @GetMapping("/{id}")
    Optional<User> userPage(@PathVariable int id) {
        return service.findById(id);
    }

    @PostMapping("/add")
    public void add(@ModelAttribute User user) {
        service.add(user);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable int id) {
        service.delete(id);
    }

    @ExceptionHandler({EntityNotFoundException.class})
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    private EntityErrorResponse handleException() {
        return new EntityErrorResponse("User isn't found!");
    }
}
