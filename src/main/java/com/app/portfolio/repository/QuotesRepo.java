package com.app.portfolio.repository;

import com.app.portfolio.model.Quotes;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface QuotesRepo extends CrudRepository<Quotes, String> {

    @Modifying
    @Query("INSERT INTO quotes(symbol, price) values (:symbol, :price)")
    void save(@Param("symbol") String symbol,
              @Param("price") String price);

}
