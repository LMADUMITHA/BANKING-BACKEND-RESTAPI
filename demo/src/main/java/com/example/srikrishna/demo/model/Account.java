package com.example.srikrishna.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

// import jakarta.persistence.Entity;
// import jakarta.persistence.GeneratedValue;
// import jakarta.persistence.GenerationType;
// import jakarta.persistence.Id;
// import jakarta.persistence.JoinColumn;
// import jakarta.persistence.ManyToOne;

// @Entity
// public class Account {

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     // private int id;
//     private int id;
//     private String accountNumber;
//     private double balance;

//     @ManyToOne
//     @JoinColumn(name = "bank_id")
//     private Bank bank;

//     public long getId() {
//         return id;
//     }

//     public void setId(int id) {
//         this.id = id;
//     }

//     public String getAccountNumber() {
//         return accountNumber;
//     }

//     public void setAccountNumber(String accountNumber) {
//         this.accountNumber = accountNumber;
//     }

//     public double getBalance() {
//         return balance;
//     }

//     public void setBalance(double balance) {
//         this.balance = balance;
//     }

//     public Bank getBank() {
//         return bank;
//     }

//     public void setBank(Bank bank) {
//         this.bank = bank;
//     }

//     public Account(int id, String accountNumber, double balance, Bank bank) {
//         this.id = id;
//         this.accountNumber = accountNumber;
//         this.balance = balance;
//         this.bank = bank;
//     }

//     public Account() {
//         // Default constructor
//     }
    
    
// }




import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Changed data type to Long

    private String accountNumber;
    private double balance;

    @ManyToOne
    @JoinColumn(name = "bank_id")
    @JsonIgnore
    private Bank bank;

    public Long getId() { // Changed return type to Long
        return id;
    }

    public void setId(Long id) { // Changed parameter type to Long
        this.id = id;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    public Account(Long id, String accountNumber, double balance, Bank bank) { // Changed constructor parameter type to Long
        this.id = id;
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.bank = bank;
    }

    public Account() {
        // Default constructor
    }

    public void setUserName(String string) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setUserName'");
    }   
}

