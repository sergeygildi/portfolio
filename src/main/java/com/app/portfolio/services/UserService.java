package com.app.portfolio.services;

import com.app.portfolio.exceptions.EntityNotFoundException;
import com.app.portfolio.model.User;
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
@Service
@Transactional
public class UserService {

    private final UserRepo userRepo;

    @Autowired
    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public Optional<List<User>> getAll() {

        log.info("Try to return all users from database ...");

        Optional<List<User>> result =
                Optional.ofNullable(Optional.of(StreamSupport.stream(userRepo.findAll().spliterator(), false).collect(Collectors.toList()))
                        .orElseThrow(EntityNotFoundException::new));

        log.info("All users from the database were successfully returned.");

        return result;
    }

    public Optional<User> findById(int id) {
        log.info("Trying to return user with id: {} from database ...", id);

        return Optional.ofNullable(userRepo.findById(id)
                .orElseThrow(EntityNotFoundException::new));
    }

    public void add(User user) {
        log.info("Trying to create new User ...");
        userRepo.save(user.getUsersName(), user.getUserPassword());
        log.info("User is successfully created.");
    }

    public void delete(int id) {
        log.info("Trying to delete User with id: {} ...", id);
        userRepo.deleteById(id);
        log.info("User with id: {} is successfully delete.", id);
    }

    public Optional<List> getUsersWithPortfolio() {
        log.info("Trying to get List of Users with portfolio ...");

        List users = userRepo.usersWithPortfolio();

        log.info("User with his portfolio is successfully return.");
        return Optional.ofNullable(Optional.of(users)
                .orElseThrow(EntityNotFoundException::new));
    }
}
