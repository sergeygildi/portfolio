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
public interface PortfolioRepo extends CrudRepository<Quotes, String> {

    @Modifying
    @Query(value = "INSERT INTO portfolio(portfolio_name) values (:name)", nativeQuery = true)
    void save(@Param("name") String name);



}
