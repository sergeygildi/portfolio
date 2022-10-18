package com.app.portfolio.controllers;

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

    @PostMapping("/quotes")
    Quotes newEmployee(@RequestBody Quotes quotes) {
        return service.save(quotes);
    }

    // Single item

    @GetMapping("/quotes/{id}")
    Quotes one(@PathVariable Long id) {

//        return repository.findById(id)
//                .orElseThrow(() -> new QuotesNotFoundException(id));
        return null;
    }

//    @PutMapping("/quotes/{id}")
//    Quotes replaceEmployee(@RequestBody Quotes newQuotes, @PathVariable Long id) {
//
//        return service.findById(id)
//                .map(quotes -> {
//                    quotes.setSymbol(newQuotes.getSymbol());
//                    quotes.setPrice(newQuotes.getPrice());
//                    return service.save(quotes);
//                })
//                .orElseGet(() -> {
//                    newQuotes.setId(id);
//                    return service.save(newQuotes);
//                });
//    }
//
//    @DeleteMapping("/quotes/{id}")
//    void deleteEmployee(@PathVariable Long id) {
//        service.deleteById(id);
//    }
}
