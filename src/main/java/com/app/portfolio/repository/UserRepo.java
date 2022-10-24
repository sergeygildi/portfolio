package com.app.portfolio.repository;

import com.app.portfolio.model.Quotes;
import lombok.NonNull;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface UserRepo extends CrudRepository<Quotes, String> {

    @Modifying
    @Query("INSERT INTO users(user_name) values (:name)")
    void save(@Param("name") String name);

    @Modifying
    @Query("DELETE FROM users WHERE user_id = :id")
    void deleteById(@Param("id") @NonNull String id);

}
