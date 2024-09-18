package com.example.Banking.Application.repository;

import com.example.Banking.Application.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


//Class name and PK data type
@Repository
public interface AccountRepository extends JpaRepository<Account,Long> {

    @Query(value = "Select * from accounts where total_balance> :amount", nativeQuery = true)
    List<Account> getAccountWithBalanceGreaterThan(@Param("amount")double amount);
}
