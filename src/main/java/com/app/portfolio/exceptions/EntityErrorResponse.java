package com.app.portfolio.exceptions;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Data
@Slf4j
public class EntityErrorResponse {
    private String message;

    public EntityErrorResponse(String message) {
        log.error(message);
        this.message = message;
    }
}
