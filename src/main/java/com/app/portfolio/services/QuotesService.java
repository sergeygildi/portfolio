package com.app.portfolio.services;

import com.app.portfolio.model.Quotes;
import com.app.portfolio.repository.QuotesRepo;
import com.app.portfolio.util.ActualQuotes;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class QuotesService {
    private final QuotesRepo quotesRepo;
    private final ActualQuotes actualQuotes;

    @Autowired
    public QuotesService(QuotesRepo quotesRepo, ActualQuotes actualQuotes) {
        this.quotesRepo = quotesRepo;
        this.actualQuotes = actualQuotes;
    }

    public List<Quotes> getAll() {
        return (List<Quotes>) quotesRepo.findAll();
    }

    public void add(String symbol, String price) {
        quotesRepo.save(symbol, price);
    }

    public void update() {
        List<Quotes> quotes = actualQuotes.getActualQuoterList();

        quotesRepo.saveAll(quotes);
    }

    public Optional<List<Quotes>> findWhereSymbolLikeUserInput(String symbol) {
        if (symbol.isEmpty() || symbol.isBlank()) {
            log.debug("Empty String. Method: {}", this);
            throw new RuntimeException();
        }
        return Optional.of(quotesRepo.findWhereSymbolLikeUserInput(symbol));
    }

}
