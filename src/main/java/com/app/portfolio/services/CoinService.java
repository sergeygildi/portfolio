package com.app.portfolio.services;

import com.app.portfolio.model.Coin;
import com.app.portfolio.repository.CoinRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CoinService {

    private final CoinRepo coinRepo;

    public CoinService(CoinRepo coinRepo) {
        this.coinRepo = coinRepo;
    }

    public Optional<List<Coin>> getAllCoins() {
        return Optional.of(coinRepo.findAll());
    }

    public void add(Coin coin) {
        coinRepo.save(coin);
    }

    public void deleteCoin(int id) {
        coinRepo.deleteById((long) id);
    }

    public Optional<Coin> findCoinById(int id) {
        return coinRepo.findById((long) id);
    }
}
