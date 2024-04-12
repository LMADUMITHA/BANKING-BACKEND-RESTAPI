// package com.example.srikrishna.demo.service;

// import com.example.srikrishna.demo.model.Account;
// import org.springframework.data.domain.Page;
// import org.springframework.data.domain.Pageable;

// public interface AccountService {
//     public Account saveAccount(Account account);
//     public Page<Account> getAllAccounts(Pageable pageable);
//     public void deleteAccount(int id);
//     public Account getAccountById(int id);
// }


package com.example.srikrishna.demo.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.srikrishna.demo.model.Account;

public interface AccountService {

    Account saveAccount(Account account);

    Page<Account> getAllAccounts(Pageable pageable);

    void deleteAccount(Long id);

    Account getAccountById(Long id);
}

