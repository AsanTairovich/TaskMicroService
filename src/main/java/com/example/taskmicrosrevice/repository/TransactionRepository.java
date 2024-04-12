package com.example.taskmicrosrevice.repository;

import com.example.taskmicrosrevice.model.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    List<Transaction> findByAccountFromAndDatetimeAfter(Long accountFrom, LocalDateTime datetime);
}
