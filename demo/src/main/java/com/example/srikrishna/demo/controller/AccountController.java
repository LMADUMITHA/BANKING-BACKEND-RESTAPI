package com.example.srikrishna.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import com.example.srikrishna.demo.model.Account;
import com.example.srikrishna.demo.service.AccountService;

@RestController
@RequestMapping("/account")
@CrossOrigin
public class AccountController {

   @Autowired
   private AccountService accountService;

   @PostMapping("/add")
   public String add(@RequestBody Account account) {
     accountService.saveAccount(account);
     return "New account is added";
   }

   @GetMapping("/getAll")
   public Page<Account> getAllAccounts(
       @RequestParam(defaultValue = "0") int page,
       @RequestParam(defaultValue = "10") int size,
       @RequestParam(defaultValue = "id") String sortBy,
       @RequestParam(defaultValue = "asc") String sortOrder
   ) {
       Sort sort = sortOrder.equalsIgnoreCase("desc") ? Sort.by(sortBy).descending() : Sort.by(sortBy).ascending();
       Pageable pageable = PageRequest.of(page, size, sort);
       return accountService.getAllAccounts(pageable);
   }

   @PutMapping("/update/{id}")
   public String updateAccount(@PathVariable int id, @RequestBody Account account) {
     account.setId((long) id);
     accountService.saveAccount(account);
     return "Account with ID " + id + " is updated";
   }                       
   
   @DeleteMapping("/delete/{id}")
   public String deleteAccount(@PathVariable Long id) {
     accountService.deleteAccount(id);
     return "Account with ID " + id + " is deleted";
   }
}
