package com.app.portfolio.services;

import com.app.portfolio.dao.QuotesDao;
import com.app.portfolio.model.Quotes;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class QuotesService {
    private final QuotesDao quotesDao;

    @Autowired
    public QuotesService(QuotesDao quotesDao) {
        this.quotesDao = quotesDao;
    }

    public List<Quotes> getAll() {
        return quotesDao.findAll();
    }

    @SneakyThrows
    public void update() {
        List<Quotes> quotes = quotesDao.getListOfQuotes();
        if (quotes.isEmpty()) {
            quotesDao.fillQuotes(quotes);
        }
        quotesDao.batchUpdate(quotes);
    }

    public Optional<Object> findBySymbol(String s) {
        return Optional.ofNullable(quotesDao.findBySymbol(s));
    }
}




