package com.app.portfolio.util;

import com.app.portfolio.model.Quotes;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

@Component
public class ActualQuotes {

    private final ObjectMapper mapper;

    @Autowired
    public ActualQuotes(ObjectMapper mapper) {
        this.mapper = mapper;
    }

    @SneakyThrows
    @JsonDeserialize
    public List<Quotes> getActualQuoterList() {
        return mapper.readValue(getUrl(), new TypeReference<>() {
        });
    }

    static URL getUrl() throws MalformedURLException {
        return new URL("https://www.binance.com/api/v3/ticker/price");
    }
}
