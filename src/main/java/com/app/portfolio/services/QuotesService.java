package com.app.portfolio.services;

import com.app.portfolio.dao.QuotesDao;
import com.app.portfolio.model.Quotes;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class QuotesService {
    private final QuotesDao quotesDao;

    @Autowired
    public QuotesService(QuotesDao quotesDao) {
        this.quotesDao = quotesDao;
    }

    public List<Quotes> getAll() {
        log.info("Get all coins");
        return quotesDao.findAll();
    }

    public Quotes save(Quotes quote) {
        log.info("Save new quote: {} : {}", quote.getSymbol(), quote.getPrice());
        quotesDao.save(quote);
        return quote;
    }

//    public static void main(String[] args) {
//        QuotesService service = new QuotesService(new QuotesDao());
//        List<Quotes> aMapOfCurrentQuotes = service.getCurrentQuotesList();
//        for (Quotes aMapOfCurrentQuote : aMapOfCurrentQuotes) {
//            log.info("{} : {}", aMapOfCurrentQuote.getSymbol(), aMapOfCurrentQuote.getPrice());
//        }
//    }

}




