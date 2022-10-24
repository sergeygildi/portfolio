package com.app.portfolio.dao;

import com.app.portfolio.model.Quotes;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

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

}
