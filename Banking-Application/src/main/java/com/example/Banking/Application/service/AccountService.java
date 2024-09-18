package com.example.Banking.Application.service;

import com.example.Banking.Application.dto.AccountDto;

import java.util.List;

public interface AccountService {


    AccountDto createAccount(AccountDto account);
    AccountDto getAccountById(Long id);

    AccountDto deposit(Long id, double Amount);

    AccountDto withdraw(Long id, double Amount);

    List<AccountDto> allAccountInfo();

    String deleteAccount(Long id);
    List<AccountDto> amountGreaterThan(double amount);
    String transferMoneyTo(Long senderId,Long receiverId,Double amount);

}
