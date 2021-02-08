package com.revature.repositories;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.revature.models.Account;


@Repository
public interface AccountRepository extends JpaRepository<Account, Integer>{
    @Query(value="SELECT * FROM banking_app_spring.user_account WHERE user_id = :userId", nativeQuery = true)
    public List<Account> findAllByUserId(@Param("userId") int userId);
}
