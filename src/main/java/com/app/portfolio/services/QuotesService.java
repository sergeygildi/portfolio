package com.app.portfolio.services;

import com.app.portfolio.exceptions.EntityNotFoundException;
import com.app.portfolio.model.Quotes;
import com.app.portfolio.repository.QuotesRepo;
import com.app.portfolio.util.ActualQuotes;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Slf4j
@Service
@Transactional(readOnly = true)
public class QuotesService {

    private final QuotesRepo quotesRepo;
    private final ActualQuotes actualQuotes;

    @Autowired
    public QuotesService(QuotesRepo quotesRepo, ActualQuotes actualQuotes) {
        this.quotesRepo = quotesRepo;
        this.actualQuotes = actualQuotes;
    }

    @Transactional(readOnly = true)
    public void update() {
        Optional<List<Quotes>> quotes = actualQuotes.getActualQuoterList();
        log.info("Try to update quotes ...");

        if (quotes.isEmpty()) {
            log.error("Failed to get/update current quotes by Binance API");
            throw new EntityNotFoundException();
        } else quotes.ifPresent(quotesRepo::saveAll);

        log.info("Quotes successfully updated.");
    }

    @Transactional(readOnly = true)
    public Optional<List<Quotes>> getAll() {
        update();

        log.info("Try to return all actual quotes from database ...");

        List<Quotes> quotes =
                StreamSupport.stream(
                                quotesRepo.findAll().spliterator(), false)
                        .collect(Collectors.toList());

        if (quotes.isEmpty()) {
            log.error("Failed to return all actual quotes from database.");
            throw new EntityNotFoundException();
        }

        log.info("All actual quotes from the database were successfully returned.");

        return Optional.of(quotes);
    }

    @Transactional(readOnly = true)
    public List<Quotes> findWhereSymbolLikeUserInput(String symbol) {
        update();

        String aCase = symbol.toUpperCase();
        log.info("Try to return symbol {} from database ...", aCase);

        List<Quotes> quotes = quotesRepo.findWhereSymbolLikeUserInput(aCase);

        if (quotes == null || quotes.isEmpty()) {
            log.error("Symbol {} isn't present.", aCase);
            throw new EntityNotFoundException();
        } else {
            log.info("Quotes {} was successfully returned from database.", aCase);
            return quotes;
        }
    }

}
