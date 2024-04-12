package com.example.srikrishna.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import com.example.srikrishna.demo.model.Transaction;
import com.example.srikrishna.demo.service.TransactionService;

@RestController
@RequestMapping("/transaction")
@CrossOrigin
public class TransactionController {

   @Autowired
   private TransactionService transactionService;

   @PostMapping("/add")
   public String add(@RequestBody Transaction transaction) {
     transactionService.saveTransaction(transaction);
     return "New transaction is added";
   }

   @GetMapping("/getAll")
   public Page<Transaction> getAllTransactions(
       @RequestParam(defaultValue = "0") int page,
       @RequestParam(defaultValue = "10") int size,
       @RequestParam(defaultValue = "id") String sortBy,
       @RequestParam(defaultValue = "asc") String sortOrder
   ) {
       Sort sort = sortOrder.equalsIgnoreCase("desc") ? Sort.by(sortBy).descending() : Sort.by(sortBy).ascending();
       Pageable pageable = PageRequest.of(page, size, sort);
       return transactionService.getAllTransactions(pageable);
   }

   @DeleteMapping("/delete/{id}")
   public String deleteTransaction(@PathVariable int id) {
     transactionService.deleteTransaction(id);
     return "Transaction with ID " + id + " is deleted";
   }
}
