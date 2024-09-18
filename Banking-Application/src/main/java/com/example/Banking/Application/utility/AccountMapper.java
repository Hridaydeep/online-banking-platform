package com.example.Banking.Application.utility;

import com.example.Banking.Application.dto.AccountDto;
import com.example.Banking.Application.entity.Account;

public class AccountMapper {

    public static Account mapToAccount(AccountDto accountDto){
        Account account= new Account(
                accountDto.getId(),
                accountDto.getAccountHolderName(),
                accountDto.getBalance(),
                accountDto.getPhoneNumber(),
                accountDto.getDOB()
        );
        return account;
    }

    public static AccountDto mapToAccountDto(Account account){
        AccountDto accountDto= new AccountDto(
                account.getId(),
                account.getAccountHolderName(),
                account.getBalance(),
                account.getPhoneNumber(),
                account.getDOB()
        );
        return accountDto;
    }
}
