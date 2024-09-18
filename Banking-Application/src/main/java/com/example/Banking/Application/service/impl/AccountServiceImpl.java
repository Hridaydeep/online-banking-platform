package com.example.Banking.Application.service.impl;

import com.example.Banking.Application.dto.AccountDto;
import com.example.Banking.Application.entity.Account;
import com.example.Banking.Application.repository.AccountRepository;
import com.example.Banking.Application.service.AccountService;
import com.example.Banking.Application.utility.AccountMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountRepository accountRepository;  //Autowiring the JPA repo

    @Override
    public AccountDto createAccount( AccountDto accountDto) {
        Account account= AccountMapper.mapToAccount(accountDto);
        Account savedAccount= accountRepository.save(account);
        return AccountMapper.mapToAccountDto(savedAccount);
    }

    @Override
    public AccountDto getAccountById(Long id) {
        return AccountMapper.mapToAccountDto(accountRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Account does not exist"))
        );

        //if the ID is not found then exception will be thrown
        //else Account obj of that id will be return
        //then that obj is converted to AccountDto

    }

    @Override
    public AccountDto deposit(Long id, double Amount) {

        Account account=accountRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Account does not exist"));
        double totalbalance=account.getBalance()+Amount;
        account.setBalance(totalbalance);

        return AccountMapper.mapToAccountDto(accountRepository.save(account));
    }



    @Override
    public List<AccountDto> allAccountInfo() {
        List<AccountDto> accountDtoList=accountRepository.findAll().stream().map((account) ->
                AccountMapper.mapToAccountDto(account))
                .collect(Collectors.toList());
        return accountDtoList;
    }

    @Override
    public String deleteAccount(Long id) {
        if(accountRepository.existsById(id)) {
            accountRepository.deleteById(id);
            return "Successful";
        }
        return "Failed";
    }

    @Override
    public List<AccountDto> amountGreaterThan(double amount) {
        List<AccountDto> accountDtoList=accountRepository.getAccountWithBalanceGreaterThan(amount).stream().map((account) ->
                        AccountMapper.mapToAccountDto(account))
                .collect(Collectors.toList());
        return accountDtoList;
    }

    @Override
    public AccountDto withdraw(Long id, double Amount) {
        Account account=accountRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Account does not exist"));
        double totalbalance=account.getBalance()-Amount;
        if(totalbalance<0) return null;

        account.setBalance(totalbalance);
        return AccountMapper.mapToAccountDto(accountRepository.save(account));
    }

    @Override
    public String transferMoneyTo(Long senderId, Long recieverId, Double amount) {
        if(accountRepository.existsById(senderId)&&accountRepository.existsById(recieverId)){
            Account receiverAccount=accountRepository.findById(recieverId)
                    .orElseThrow(()-> new RuntimeException("Account does not exist"));
            Account senderAccount=accountRepository.findById(senderId)
                    .orElseThrow(()-> new RuntimeException("Account does not exist"));
            if(senderAccount.getBalance()<amount) return "Insufficient Balance";
            Double senderTotal=senderAccount.getBalance()-amount;
            Double receiveTotal=receiverAccount.getBalance()+amount;
            senderAccount.setBalance(senderTotal);
            receiverAccount.setBalance(receiveTotal);
            accountRepository.save(senderAccount);
            accountRepository.save(receiverAccount);

            return "Transaction Successful";

        }
        return "Invalid User ID";

    }


}
