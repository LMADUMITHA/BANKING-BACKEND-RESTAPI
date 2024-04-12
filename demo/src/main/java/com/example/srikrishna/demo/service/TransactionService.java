package com.example.srikrishna.demo.service;

import com.example.srikrishna.demo.model.Transaction;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface TransactionService {
    public Transaction saveTransaction(Transaction transaction);
    public Page<Transaction> getAllTransactions(Pageable pageable);
    public void deleteTransaction(int id);
    public Transaction getTransactionById(int id);
}
