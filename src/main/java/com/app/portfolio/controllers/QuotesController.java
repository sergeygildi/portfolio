package com.app.portfolio.controllers;

import com.app.portfolio.exceptions.EntityErrorResponse;
import com.app.portfolio.exceptions.EntityNotFoundException;
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
@ControllerAdvice
@RequestMapping("/quotes")
public class QuotesController {

    private final QuotesService service;

    @Autowired
    public QuotesController(QuotesService service) {
        this.service = service;
    }

    @GetMapping(value = "/")
    public ResponseEntity<List<Quotes>> getAll() {
        Optional<List<Quotes>> quotes = service.getAll();
        return quotes.isPresent() ?
                new ResponseEntity(quotes, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PatchMapping("/update")
    void update() {
        service.update();
    }

    @GetMapping("/{symbol}")
    List<Quotes> allQuotesEqualsUserInput(@PathVariable String symbol) {
        return service.findWhereSymbolLikeUserInput(symbol);
    }

    @ExceptionHandler({EntityNotFoundException.class})
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public EntityErrorResponse handleException() {
        return new EntityErrorResponse("Quote isn't found! Try to put a correct symbol");
    }

    @GetMapping(value = "/oups")
    public String triggerException() {
        throw new RuntimeException("Expected: controller used to showcase what happens when an exception is thrown");
    }
}
