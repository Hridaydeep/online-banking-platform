package com.example.Banking.Application.dto;

import javax.persistence.Column;

public class AccountDto {

    private Long id;
    private String accountHolderName;
    private Double balance;
    private String phoneNumber;
    private String DOB;

    public AccountDto() {
    }

    public AccountDto(Long id, String accountHolderName, Double balance, String phoneNumber, String DOB) {
        this.id = id;
        this.accountHolderName = accountHolderName;
        this.balance = balance;
        this.phoneNumber = phoneNumber;
        this.DOB = DOB;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public void setAccountHolderName(String accountHolderName) {
        this.accountHolderName = accountHolderName;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getDOB() {
        return DOB;
    }

    public void setDOB(String DOB) {
        this.DOB = DOB;
    }
}
