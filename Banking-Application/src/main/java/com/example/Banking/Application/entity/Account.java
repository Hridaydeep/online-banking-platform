package com.example.Banking.Application.entity;

import net.bytebuddy.dynamic.loading.InjectionClassLoader;

import javax.persistence.*;

@Entity
@Table(name="accounts")
public class Account {

    @Id //PK
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Auto INC
    private Long id;
    @Column(name = "account_holder_name")
    private String accountHolderName;

    @Column(name="total_balance")
    private Double balance;
    @Column(name="phone_number")
    private String phoneNumber;
    @Column(name="date_of_birth")
    private String DOB;

    public Account() {
    }

    public Account(Long id, String accountHolderName, Double balance, String phoneNumber, String DOB) {
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
