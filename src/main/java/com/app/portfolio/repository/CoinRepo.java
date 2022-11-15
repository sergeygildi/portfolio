package com.app.portfolio.repository;

import com.app.portfolio.model.Coin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CoinRepo extends JpaRepository<Coin, Long> {

    @Modifying
    @Query(value = "INSERT INTO coins(coin_symbol, coin_buy_price) values (:symbol, :price)", nativeQuery = true)
    void save(@Param("symbol") String symbol,
              @Param("price") String price);


}
