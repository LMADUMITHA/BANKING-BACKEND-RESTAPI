


package com.example.srikrishna.demo.service;

// // import org.hibernate.query.Page;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
// import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Sort;
// import org.springframework.data.domain.Page;
// // import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Sort;
// import org.springframework.data.domain.PageRequest;
// import org.springframework.stereotype.Service;

// import com.example.srikrishna.demo.model.Account;
// import com.example.srikrishna.demo.model.Bank;
// import com.example.srikrishna.demo.model.Transaction;
// import com.example.srikrishna.demo.repository.AccountRepository;
// import com.example.srikrishna.demo.repository.BankRepository;
// import com.example.srikrishna.demo.repository.TransactionRepository;

// import jakarta.transaction.Transactional;

// import java.util.List;
// import java.util.Map;
// import java.util.Optional;

// @Service
// public class CustomService {

//     @Autowired
//     private BankRepository bankRepository;

//     @Autowired
//     private AccountRepository accountRepository;

//     @Autowired
//     private TransactionRepository transactionRepository;

//     public void createEntities(Map<String, Object> requestData) {
//         // Extract data for bank, account, and transaction entities from the requestData map
//         Map<String, Object> bankData = (Map<String, Object>) requestData.get("bank");
//         Map<String, Object> accountData = (Map<String, Object>) requestData.get("account");
//         Map<String, Object> transactionData = (Map<String, Object>) requestData.get("transaction");

//         // Create bank entity
//         Bank bank = new Bank();
//         bank.setUserName((String) bankData.get("userName"));
//         bank.setEmail((String) bankData.get("email"));
//         bank.setBankAccNumber((String) bankData.get("bankAccNumber"));
//         bankRepository.save(bank);

//         // Create account entity
//         Account account = new Account();
//         account.setAccountNumber((String) accountData.get("accountNumber"));
//         account.setBalance((Double) accountData.get("balance"));
//         account.setBank(bank); // Assuming bank is associated with account
//         accountRepository.save(account);
        
//         // Create transaction entity
//         Transaction transaction = new Transaction();
//         transaction.setAmount((Double) transactionData.get("amount"));
//         transaction.setAccount(account); // Assuming transaction is associated with account
//         transactionRepository.save(transaction);
//     }

//     // public void updateEntity(Long id, Map<String, Object> requestData) {
//     //     // Implement update logic based on entity ID and request data
//     //     Optional<Account> accountOptional = accountRepository.findById(id);
//     //     if (accountOptional.isPresent()) {
//     //         Account account = accountOptional.get();
//     //         // Update account properties based on requestData
//     //         // Example:
//     //         // account.setBalance((Double) requestData.get("balance"));
//     //         accountRepository.save(account);
//     //     }
//     // }

//     @Transactional
//     public void updateEntity(Long id, Map<String, Object> requestData) {
//         Optional<Account> accountOptional = accountRepository.findById(id);
//         if (accountOptional.isPresent()) {
//             Account account = accountOptional.get();
            
//             // Update account properties based on requestData
//             if (requestData.containsKey("balance")) {
//                 account.setBalance((Double) requestData.get("balance"));
//             }
//             // if (requestData.containsKey("userName")) {
//             //     account.setUserName((String) requestData.get("userName"));
//             // }
            
//             accountRepository.save(account);
//         }
//     }
    
    

//     // public void deleteEntity(int id) {
//     //     accountRepository.deleteById(id);
//     // }
//     // public void deleteEntity(Integer id) {
//     //     accountRepository.deleteById(id);
//     // }

//     @Transactional
//     public void deleteEntity(Long id) {
//         accountRepository.deleteById(id);
//     }
    
    
//     public Account getEntity(Long id) {
//         Optional<Account> accountOptional = accountRepository.findById(id);
//         return accountOptional.orElse(null);
//     }

//     public List<Account> getAllEntities() {
//         return accountRepository.findAll();
//     }


//     public Page<Account> getAllEntities(int pageNumber, int pageSize, String sortBy) {
//         Pageable pageable = PageRequest.of(pageNumber, pageSize, Sort.by(sortBy));
//         return accountRepository.findAll(pageable);
//     }
// }


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import com.example.srikrishna.demo.model.Account;
import com.example.srikrishna.demo.model.Bank;
import com.example.srikrishna.demo.model.Transaction;
import com.example.srikrishna.demo.repository.AccountRepository;
import com.example.srikrishna.demo.repository.BankRepository;
import com.example.srikrishna.demo.repository.TransactionRepository;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class CustomService {

    @Autowired
    private BankRepository bankRepository;

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private TransactionRepository transactionRepository;

    public void createEntities(Map<String, Object> requestData) {
        // Extract data for bank, account, and transaction entities from the requestData map
        Map<String, Object> bankData = (Map<String, Object>) requestData.get("bank");
        Map<String, Object> accountData = (Map<String, Object>) requestData.get("account");
        Map<String, Object> transactionData = (Map<String, Object>) requestData.get("transaction");

        // Create bank entity
        Bank bank = new Bank();
        bank.setUserName((String) bankData.get("userName"));
        bank.setEmail((String) bankData.get("email"));
        bank.setBankAccNumber((String) bankData.get("bankAccNumber"));
        bankRepository.save(bank);

        // Create account entity
        Account account = new Account();
        account.setAccountNumber((String) accountData.get("accountNumber"));
        account.setBalance((Double) accountData.get("balance"));
        account.setBank(bank); // Assuming bank is associated with account
        accountRepository.save(account);
        
        // Create transaction entity
        Transaction transaction = new Transaction();
        transaction.setAmount((Double) transactionData.get("amount"));
        transaction.setAccount(account); // Assuming transaction is associated with account
        transactionRepository.save(transaction);
    }

    @Transactional
    public void updateEntity(Long id, Map<String, Object> requestData) {
        Optional<Account> accountOptional = accountRepository.findById(id);
        if (accountOptional.isPresent()) {
            Account account = accountOptional.get();
            
            // Update account properties based on requestData
            if (requestData.containsKey("balance")) {
                account.setBalance((Double) requestData.get("balance"));
            }
            
            accountRepository.save(account);
        }
    }
    
    @Transactional
    public void deleteEntity(Long id) {
        accountRepository.deleteById(id);
    }
    
    public Account getEntity(Long id) {
        Optional<Account> accountOptional = accountRepository.findById(id);
        return accountOptional.orElse(null);
    }

    public List<Account> getAllEntities() {
        return accountRepository.findAll();
    }

    public Page<Account> getAllEntities(int pageNumber, int pageSize, String sortBy) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize, Sort.by(sortBy));
        return accountRepository.findAll(pageable);
    }


    public List<Account> findAccountsByBalanceRange(double minBalance, double maxBalance) {
        return accountRepository.findAccountsByBalanceRange(minBalance, maxBalance);
    }
}

