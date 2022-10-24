package com.app.portfolio.util;

import com.app.portfolio.model.Quotes;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.springframework.stereotype.Component;

import java.net.URL;
import java.util.List;
import java.util.Optional;

@Component
public class ActualQuotes {

    @SneakyThrows
    public List<Quotes> getActualQuoterList() {
        ObjectMapper mapper = new ObjectMapper();
        URL url =
                Optional.of(
                                new URL("https://www.binance.com/api/v3/ticker/price"))
                        .get();

        return List.of(mapper.readValue(url, new TypeReference<>() {
        }));
    }
}
