package com.app.portfolio.dao;

import com.app.portfolio.model.Quotes;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.net.MalformedURLException;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.Callable;

@Component
@Slf4j
@NoArgsConstructor
public class QuotesDao implements CrudRepository<Quotes, Long> {

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

        return List.of(mapper.readValue(url, new TypeReference<>() {}));
    }


    @Override
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

    @Override
    public List<Quotes> findAll() {
        return jdbcTemplate.query("SELECT * FROM quotes", new BeanPropertyRowMapper<>(Quotes.class));
    }

    @Override
    public Optional<Quotes> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public void deleteAll() {
        jdbcTemplate.batchUpdate("DELETE FROM quotes");
    }

    @Override
    public void deleteById(@NonNull Long id) {
    }

    @Override
    public void deleteAll(Iterable<? extends Quotes> entities) {
    }

    @Override
    public Iterable<Quotes> findAllById(Iterable<Long> longs) {
        return null;
    }

    @Override
    public <S extends Quotes> Iterable<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void delete(Quotes entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Long> longs) {

    }
}
