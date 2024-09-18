package com.example.Banking.Application.controlller;


import com.example.Banking.Application.dto.AccountDto;
import com.example.Banking.Application.entity.Account;
import com.example.Banking.Application.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/REST-API/accounts")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @PostMapping("/newUser")
    public ResponseEntity<AccountDto> addAccount(@RequestBody AccountDto accountDto){
        return new ResponseEntity<>(accountService.createAccount(accountDto), HttpStatus.CREATED);
    }

    @GetMapping("/findBy/{id}")
    public ResponseEntity<AccountDto> findById(@PathVariable Long id){
        AccountDto accountDto= accountService.getAccountById(id);
        return ResponseEntity.ok(accountDto);
    }

    @PostMapping("/Self-Deposit/{id}")
    public ResponseEntity<AccountDto> selfDeposit(@PathVariable Long id, @RequestBody Map<String, Double> request){
        AccountDto accountDto= accountService.deposit(id,request.get("amount"));
        return ResponseEntity.ok(accountDto);
    }
    @PostMapping("/Withdraw/{id}")
    public ResponseEntity<AccountDto> withdraw(@PathVariable Long id, @RequestBody Map<String, Double> request){
        AccountDto accountDto= accountService.deposit(id,request.get("amount"));
        return ResponseEntity.ok(accountDto);
    }

    @GetMapping("/All-User-Info")
    public ResponseEntity<List<AccountDto>> getAllAccounts(){
        List<AccountDto> accountDtoList= accountService.allAccountInfo();
        return ResponseEntity.ok(accountDtoList);
    }

    @GetMapping("/Delete-Account/{id}")
    public ResponseEntity<String> deleteAccount(@PathVariable Long id){
        return ResponseEntity.ok(accountService.deleteAccount(id));
    }

    @GetMapping("/ListOfAccountGreater/{amount}")
    public ResponseEntity<List<AccountDto>> listOfAccount(@PathVariable Double amount){
        return ResponseEntity.ok(accountService.amountGreaterThan(amount));
    }

    @PostMapping("/{id}/moneyTransfer")
    public ResponseEntity<String> moneyTransferTo(@PathVariable Long id, @RequestBody Map<String,Double> request){
        return ResponseEntity.ok(accountService.transferMoneyTo(id,request.get("ID").longValue(),request.get("Amount")));
    }
}
