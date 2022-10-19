package com.app.portfolio.controllers;

import com.app.portfolio.exceptions.QuotesNotFoundException;
import com.app.portfolio.model.Quotes;
import com.app.portfolio.services.QuotesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class QuotesController {

    private final QuotesService service;

    @Autowired
    public QuotesController(QuotesService service) {
        this.service = service;
    }

    @GetMapping(value = "/")
    public ResponseEntity<List<Quotes>> read() {
        List<Quotes> quotes = service.getAll();
        return quotes != null && !quotes.isEmpty() ?
                new ResponseEntity<>(quotes, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/all")
    List<Quotes> all() {
        return service.getAll();
    }

    @PutMapping("/update")
    void update() {
        service.update();
    }

    @GetMapping("/{symbol}")
    Object one(@PathVariable String symbol) {
        service.update();
        return service.findBySymbol(symbol);
    }
}
