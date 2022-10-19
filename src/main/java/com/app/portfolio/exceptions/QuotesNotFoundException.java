package com.app.portfolio.exceptions;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class QuotesNotFoundException {
    public QuotesNotFoundException(String symbol) {
        log.error("Symbol: {} is not found.", symbol);
        throw new RuntimeException();
    }
}
