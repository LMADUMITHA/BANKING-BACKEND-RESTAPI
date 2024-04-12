// package com.example.srikrishna.demo.service;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.data.domain.Page;
// import org.springframework.data.domain.Pageable;
// import org.springframework.stereotype.Service;

// import com.example.srikrishna.demo.model.Account;
// import com.example.srikrishna.demo.repository.AccountRepository;

// @Service
// public class AccountServiceImpl implements AccountService {

//     private final AccountRepository accountRepository;

//     @Autowired
//     public AccountServiceImpl(AccountRepository accountRepository) {
//         this.accountRepository = accountRepository;
//     }

//     @Override
//     public Account saveAccount(Account account) {
//         return accountRepository.save(account);
//     }

//     @Override
//     public Page<Account> getAllAccounts(Pageable pageable) {
//         return accountRepository.findAll(pageable);
//     }

//     @Override
//     public void deleteAccount(int id) {
//         accountRepository.deleteById((long) id);
//     }

//     @Override
//     public Account getAccountById(int id) {
//         return accountRepository.findById((long) id).orElse(null);
//     }
// }


package com.example.srikrishna.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.srikrishna.demo.model.Account;
import com.example.srikrishna.demo.repository.AccountRepository;

@Service
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;

    @Autowired
    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public Account saveAccount(Account account) {
        return accountRepository.save(account);
    }

    @Override
    public Page<Account> getAllAccounts(Pageable pageable) {
        return accountRepository.findAll(pageable);
    }

    @Override
    public void deleteAccount(Long id) {
        accountRepository.deleteById(id);
    }

    @Override
    public Account getAccountById(Long id) {
        return accountRepository.findById(id).orElse(null);
    }
}
