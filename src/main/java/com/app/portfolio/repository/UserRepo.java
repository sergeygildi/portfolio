package com.app.portfolio.repository;

import com.app.portfolio.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface UserRepo extends JpaRepository<User, Integer> {

    @Modifying
    @Query(value = "INSERT INTO users (user_name, user_password) VALUES (:name, :password)",
            nativeQuery = true)
    void save(@Param("name") String name,
              @Param("password") String password);

    @Modifying
    @Query(value = "DELETE FROM users WHERE user_id = :id",
            nativeQuery = true)
    void deleteById(@Param("id") int id);

    @Query(value = "SELECT user_name, user_password, portfolio_name FROM users JOIN portfolio p on p.portfolio_id = users.portfolio_id",
            nativeQuery = true)
    List usersWithPortfolio();
}
