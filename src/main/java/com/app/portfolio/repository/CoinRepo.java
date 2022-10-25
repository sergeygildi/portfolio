package com.app.portfolio.repository;

import com.app.portfolio.model.Quotes;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface CoinRepo extends CrudRepository<Quotes, String> {

    @Modifying
    @Query(value = "INSERT INTO coins(coin_symbol, coin_buy_price) values (:symbol, :price)", nativeQuery = true)
    void save(@Param("symbol") String symbol,
              @Param("price") String price);

}
