package com.app.portfolio.dao;

import com.app.portfolio.model.Quotes;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Component
@Slf4j
@NoArgsConstructor
public class QuotesDao {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public QuotesDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void batchUpdate(List<Quotes> quotes) {
        jdbcTemplate.batchUpdate(
                "UPDATE quotes SET price = ? WHERE symbol = ?",
                new BatchPreparedStatementSetter() {

                    public void setValues(@NonNull PreparedStatement ps, int i) throws SQLException {
                        ps.setString(1, quotes.get(i).getPrice());
                        ps.setString(2, quotes.get(i).getSymbol());
                    }

                    public int getBatchSize() {
                        return quotes.size();
                    }
                });
    }

    @SneakyThrows
    public List<Quotes> getListOfQuotes() {
        ObjectMapper mapper = new ObjectMapper();
        URL url =
                Optional.of(
                                new URL("https://www.binance.com/api/v3/ticker/price"))
                        .get();

        return List.of(mapper.readValue(url, new TypeReference<>() {
        }));
    }


    public Optional<Quotes> save(Quotes quotes) {
        jdbcTemplate.update("INSERT INTO quotes (symbol, price) VALUES (?, ?)",
                quotes.getSymbol(), quotes.getPrice());
        return Optional.of(quotes);
    }

    @SneakyThrows
    public void fillQuotes(List<Quotes> quotes) {
        jdbcTemplate.batchUpdate("INSERT INTO quotes (symbol, price) VALUES (?, ?)",
                new BatchPreparedStatementSetter() {

                    public void setValues(@NonNull PreparedStatement ps, int i) throws SQLException {
                        ps.setString(1, quotes.get(i).getSymbol());
                        ps.setString(2, quotes.get(i).getPrice());
                    }

                    public int getBatchSize() {
                        return quotes.size();
                    }
                });
    }

    public Optional<Quotes> findBySymbol(String symbol) {
        return jdbcTemplate.query("SELECT * FROM quotes WHERE symbol = ?",
                        new Object[]{symbol},
                        new BeanPropertyRowMapper<>(Quotes.class))
                .stream().findAny();
    }

    public List<Quotes> findAll() {
        return jdbcTemplate.query("SELECT * FROM quotes", new BeanPropertyRowMapper<>(Quotes.class));
    }

    public void deleteAll() {
        jdbcTemplate.batchUpdate("DELETE FROM quotes");
    }

}
