package com.app.portfolio.controllers;

import com.app.portfolio.exceptions.EntityErrorResponse;
import com.app.portfolio.exceptions.EntityNotFoundException;
import com.app.portfolio.model.Coin;
import com.app.portfolio.model.Portfolio;
import com.app.portfolio.model.Quotes;
import com.app.portfolio.model.User;
import com.app.portfolio.services.CoinService;
import com.app.portfolio.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;
    private final CoinService coinService;

    @Autowired
    public UserController(UserService userService, CoinService coinService) {
        this.userService = userService;
        this.coinService = coinService;
    }

    @GetMapping(value = "/")
    public ResponseEntity<List<Quotes>> getAll() {
        Optional<List<User>> quotes = userService.getAll();
        return quotes.isPresent() ?
                new ResponseEntity(quotes, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/{id}")
    Optional<User> userPage(@PathVariable int id) {
        return userService.findById(id);
    }

    @PutMapping("/add")
    public void add(@ModelAttribute User user) {
        userService.add(user);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable int id) {
        userService.delete(id);
    }

    // PortfolioController
    @GetMapping(value = "/portfolio")
    public Optional<List<Portfolio>> usersWithPortfolio() {
        return userService.getAllPortfolios();
    }

    @PutMapping("/portfolio/add")
    public void add(@ModelAttribute Portfolio portfolio) {
        userService.add(portfolio);
    }

    @DeleteMapping("/portfolio/delete/{id}")
    public void deletePortfolio(@PathVariable int id) {
        userService.deletePortfolio(id);
    }

    @GetMapping("/portfolio/{id}")
    Optional<Portfolio> portfolioPage(@PathVariable int id) {
        return userService.findPortfolioById(id);
    }

    // coin controllers
    @GetMapping(value = "/coin")
    public Optional<List<Coin>> showAllCoins() {
        return coinService.getAllCoins();
    }

    @PutMapping("/coin/add")
    public void add(@ModelAttribute Coin coin) {
        coinService.add(coin);
    }

    @DeleteMapping("/coin/delete/{id}")
    public void deleteCoin(@PathVariable int id) {
        coinService.deleteCoin(id);
    }

    @GetMapping("/coin/{id}")
    Optional<Coin> coinPage(@PathVariable int id) {
        return coinService.findCoinById(id);
    }

    @ExceptionHandler({EntityNotFoundException.class})
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    private EntityErrorResponse handleException() {
        return new EntityErrorResponse("Entity isn't found!");
    }
}
