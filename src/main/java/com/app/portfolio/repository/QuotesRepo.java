package com.app.portfolio.repository;

import com.app.portfolio.model.Quotes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface QuotesRepo extends JpaRepository<Quotes, String> {

    @Modifying
    @Query(value = "INSERT INTO Quotes (symbol, price) values (:symbol, :price)",
            nativeQuery = true)
    void save(@Param("symbol") String symbol,
              @Param("price") Double price);

    @Query(value = "from Quotes q where q.symbol like %:income%")
    List<Quotes> findWhereSymbolLikeUserInput(@Param("income") String symbol);


}
