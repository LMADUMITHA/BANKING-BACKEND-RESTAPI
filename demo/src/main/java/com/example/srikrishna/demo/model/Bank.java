

// import jakarta.persistence.Entity;
// import jakarta.persistence.GeneratedValue;
// import jakarta.persistence.GenerationType;
// import jakarta.persistence.Id;

// @Entity
// public class Bank {
   
//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private int id;
//     private String name;
//     private String address;
//     private String email;
//     private int contactNumber;
    
//     public Bank() {
//     }

//     public int getId() {
//         return id;
//     }

//     public void setId(int id) {
//         this.id = id;
//     }

//     public String getName() {
//         return name;
//     }

//     public void setName(String name) {
//         this.name = name;
//     }

//     public String getAddress() {
//         return address;
//     }

//     public void setAddress(String address) {
//         this.address = address;
//     }

//     public String getEmail() {
//         return email;
//     }

//     public void setEmail(String email) {
//         this.email = email;
//     }

//     public int getContactNumber() {
//          return contactNumber;
//     }

//     public void setContactNumber(int contactNumber) {
//         this.contactNumber = contactNumber;
//     }
// }



// package com.example.srikrishna.demo.model;

// import jakarta.persistence.Entity;
// import jakarta.persistence.GeneratedValue;
// import jakarta.persistence.GenerationType;
// import jakarta.persistence.Id;

// @Entity
// public class Bank {
   
//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private int id;
//     private String userName; // Changed from 'name' to 'userName'
//     private String email;
//     private int accountNumber; // Changed from 'contactNumber' to 'accountNumber'
    
//     public Bank() {
//     }

//     public int getId() {
//         return id;
//     }

//     public void setId(int id) {
//         this.id = id;
//     }

//     public String getUserName() { // Changed from 'getName()' to 'getUserName()'
//         return userName;
//     }

//     public void setUserName(String userName) { // Changed from 'setName()' to 'setUserName()'
//         this.userName = userName;
//     }

//     public String getEmail() {
//         return email;
//     }

//     public void setEmail(String email) {
//         this.email = email;
//     }

//     public int getAccountNumber() { // Changed from 'getContactNumber()' to 'getAccountNumber()'
//          return accountNumber;
//     }

//     public void setAccountNumber(int accountNumber) { // Changed from 'setContactNumber()' to 'setAccountNumber()'
//         this.accountNumber = accountNumber;
//     }
// }



// package com.example.srikrishna.demo.model;

// import jakarta.persistence.Entity;
// import jakarta.persistence.GeneratedValue;
// import jakarta.persistence.GenerationType;
// import jakarta.persistence.Id;

// @Entity
// public class Bank {
   
//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private int id;
//     private String userName; // Changed from 'name' to 'userName'
//     private String email;
//     private int bankAccNumber; // Changed from 'accountNumber' to 'bankAccNumber'
    
//     public Bank() {
//     }

//     public int getId() {
//         return id;
//     }

//     public void setId(int id) {
//         this.id = id;
//     }

//     public String getUserName() { // Changed from 'getName()' to 'getUserName()'
//         return userName;
//     }

//     public void setUserName(String userName) { // Changed from 'setName()' to 'setUserName()'
//         this.userName = userName;
//     }

//     public String getEmail() {
//         return email;
//     }

//     public void setEmail(String email) {
//         this.email = email;
//     }

//     public int getBankAccNumber() { // Changed from 'getAccountNumber()' to 'getBankAccNumber()'
//          return bankAccNumber;
//     }

//     public void setBankAccNumber(int bankAccNumber) { // Changed from 'setAccountNumber()' to 'setBankAccNumber()'
//         this.bankAccNumber = bankAccNumber;
//     }
// }


package com.example.srikrishna.demo.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Bank {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String userName;
    private String email;
    private String bankAccNumber;

    @OneToMany(mappedBy = "bank")

    @JsonIgnore
    private List<Account> accounts;

    public Bank() {
        // Default constructor
    }

    public Bank(String userName, String email, String bankAccNumber) {
        this.userName = userName;
        this.email = email;
        this.bankAccNumber = bankAccNumber;
    }

    // Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBankAccNumber() {
        return bankAccNumber;
    }

    public void setBankAccNumber(String bankAccNumber) {
        this.bankAccNumber = bankAccNumber;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }
}
