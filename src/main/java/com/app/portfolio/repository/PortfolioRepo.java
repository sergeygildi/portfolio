package com.app.portfolio.repository;

import com.app.portfolio.model.Portfolio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface PortfolioRepo extends JpaRepository<Portfolio, Long> {

    @Modifying
    @Query(value = "INSERT INTO portfolio(portfolio_name) values (:name)",
            nativeQuery = true)
    void save(@Param("name") String name);

    @Modifying
    @Query(value = "DELETE FROM portfolio WHERE portfolio_id = :id",
            nativeQuery = true)
    void deleteById(@Param("id") int id);

}
