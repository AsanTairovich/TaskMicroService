package com.example.taskmicrosrevice.controller;

import com.example.taskmicrosrevice.model.entity.Transaction;
import com.example.taskmicrosrevice.service.TransactionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transactions")
public class TransactionController {
    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @GetMapping
    public ResponseEntity<List<Transaction>> getAllTransactions() {
        List<Transaction> transactions = transactionService.getAllTransactions();
        return ResponseEntity.ok().body(transactions);
    }

    @PostMapping
    public ResponseEntity<Transaction> createTransaction(@RequestBody Transaction transaction) {
        Transaction savedTransaction = transactionService.saveTransaction(transaction);
        return ResponseEntity.ok().body(savedTransaction);
    }

    @GetMapping("/exceeded-limits")
    public ResponseEntity<List<Transaction>> getTransactionsExceedingLimits() {
        List<Transaction> transactions = transactionService.getTransactionsExceedingLimit();
        return ResponseEntity.ok().body(transactions);
    }
}
