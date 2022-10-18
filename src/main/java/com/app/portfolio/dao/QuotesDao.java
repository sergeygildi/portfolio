package com.app.portfolio.dao;

import com.app.portfolio.model.Quotes;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Slf4j
@NoArgsConstructor
public class QuotesDao {

    private JdbcTemplate jdbcTemplate;

//    private static final String URL_BINANCE = "https://www.binance.com/api/v3/ticker/price";
//    private ObjectMapper mapper;

    @Autowired
    public QuotesDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    //    @SneakyThrows
    public void update() {
//        mapper = new ObjectMapper();
//        URL url = new URL(URL_BINANCE);
//
//        List<Quotes> quotesList = List.of(mapper.readValue(url, new TypeReference<>() {
//        }));

//        if (!quotesList.isEmpty()) {
//            setList(new ArrayList<>(quotesList));
//        }
    }

    public Quotes save(Quotes quotes) {
        jdbcTemplate.update("INSERT INTO quotes (id, symbol, price) VALUES (?, ?, ?)",
                quotes.getId(), quotes.getSymbol(), quotes.getPrice());
        return quotes;
    }

    @SneakyThrows
    public <S extends Quotes> Iterable<S> saveAll(@NonNull Iterable<S> entities) {

//        jdbcTemplate.batchUpdate("INSERT INTO quotes (symbol, price) VALUES (?, ?)",
//                String.valueOf(entities));
        return entities;
    }


    public List<Quotes> findAll() {
        return jdbcTemplate.query("SELECT * FROM quotes", new BeanPropertyRowMapper<>(Quotes.class));
    }
}
