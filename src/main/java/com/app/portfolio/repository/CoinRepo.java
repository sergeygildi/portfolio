package com.app.portfolio.repository;

import com.app.portfolio.model.Coin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CoinRepo extends JpaRepository<Coin, String> {

    @Modifying
    @Query(value = "INSERT INTO coins(coin_symbol, coin_buy_price) values (:symbol, :price)", nativeQuery = true)
    void save(@Param("symbol") String symbol,
              @Param("price") String price);

    @Override
    @Query(value = "SELECT c FROM coins c", nativeQuery = true)
    Optional<Coin> findById(String s);

}
