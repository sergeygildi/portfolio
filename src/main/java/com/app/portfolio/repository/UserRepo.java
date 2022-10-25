package com.app.portfolio.repository;

import com.app.portfolio.model.Quotes;
import lombok.NonNull;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface UserRepo extends CrudRepository<Quotes, String> {

    @Modifying
    @Query(value = "INSERT INTO users(user_name) values (:name)", nativeQuery = true)
    void save(@Param("name") String name);

    @Modifying
    @Query(value = "DELETE FROM users WHERE user_id = :id", nativeQuery = true)
    void deleteById(@Param("id") @NonNull String id);

}
