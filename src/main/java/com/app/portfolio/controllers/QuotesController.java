package com.app.portfolio.controllers;

import com.app.portfolio.model.Quotes;
import com.app.portfolio.services.QuotesService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@Slf4j
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
        log.debug("All updated!");
    }

    @PutMapping("/add")
    Optional<Quotes> add(
            @RequestParam String symbol,
            @RequestParam String price) {
        service.add(symbol, price);
        return service.findBySymbol(symbol);
    }

    @GetMapping("/{symbol}")
    Object one(@PathVariable String symbol) {
        service.update();
        log.info("All updated!");
        return service.findBySymbol(symbol);
    }

    @GetMapping("/all/{symbol}")
    Object allUsdt(@PathVariable String symbol) {
        return service.findWhereSymbolLikeUserInput(symbol);
    }

    @DeleteMapping("/delete/all")
    void deleteAll() {
        service.deleteAll();
        log.info("All delete!");
    }
}
