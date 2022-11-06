package com.app.portfolio.services;

import com.app.portfolio.exceptions.EntityNotFoundException;
import com.app.portfolio.model.Coin;
import com.app.portfolio.model.Portfolio;
import com.app.portfolio.model.User;
import com.app.portfolio.repository.CoinRepo;
import com.app.portfolio.repository.PortfolioRepo;
import com.app.portfolio.repository.UserRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Slf4j
@Service("userService")
public class UserService {

    private final UserRepo userRepo;
    private final PortfolioRepo portfolioRepo;
    private final CoinRepo coinRepo;

    @Autowired
    public UserService(UserRepo userRepo, PortfolioRepo portfolioRepo, CoinRepo coinRepo) {
        this.userRepo = userRepo;
        this.portfolioRepo = portfolioRepo;
        this.coinRepo = coinRepo;
    }

    //    UserService
    @Transactional(readOnly = true)
    public Optional<List<User>> getAll() {

        log.info("Try to return all users from database ...");

        Optional<List<User>> result =
                Optional.ofNullable(Optional.of(StreamSupport.stream(userRepo.findAll().spliterator(), false).collect(Collectors.toList()))
                        .orElseThrow(EntityNotFoundException::new));

        log.info("All users from the database were successfully returned.");

        return result;
    }

    @Transactional(readOnly = true)
    public Optional<User> findById(int id) {
        log.info("Trying to return user with id: {} from database ...", id);

        return Optional.ofNullable(userRepo.findById(id)
                .orElseThrow(EntityNotFoundException::new));
    }

    @Transactional
    public void add(User user) {
        log.info("Trying to create new User ...");
        userRepo.save(user.getUsersName(), user.getUserPassword());
        log.info("User is successfully created.");
    }

    @Transactional
    public void delete(int id) {
        log.info("Trying to delete User with id: {} ...", id);
        userRepo.deleteById(id);
        log.info("User with id: {} is successfully delete.", id);
    }

    @Transactional(readOnly = true)
    public Optional<List> getUsersWithPortfolio() {
        log.info("Trying to get List of Users with portfolio ...");

        List users = userRepo.usersWithPortfolio();

        log.info("User with his portfolio is successfully return.");
        return Optional.ofNullable(Optional.of(users)
                .orElseThrow(EntityNotFoundException::new));
    }

    //    PortfolioService

    @Transactional(readOnly = true)
    public Optional<List<Portfolio>> getAllPortfolios() {
        return Optional.of(portfolioRepo.findAll());
    }

    @Transactional
    public void add(Portfolio portfolio) {
        log.info("Trying to create new Portfolio ...");
        portfolioRepo.save(portfolio);
        log.info("Portfolio is successfully created.");
    }

    @Transactional(readOnly = true)
    public Optional<Portfolio> findPortfolioById(int id) {
        log.info("Trying to return portfolio with id: {} from database ...", id);

        return Optional.ofNullable(portfolioRepo.findById((long) id)
                .orElseThrow(EntityNotFoundException::new));
    }

    @Transactional
    public void deletePortfolio(int id) {
        log.info("Trying to delete Portfolio with id: {} ...", id);
        portfolioRepo.deleteById(id);
        log.info("Portfolio with id: {} is successfully delete.", id);
    }

    @Transactional(readOnly = true)
    public Optional<List<Coin>> getAllCoins() {
        return Optional.of(coinRepo.findAll());
    }

}
