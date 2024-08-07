package com.example.banktransaction.repository;

import com.example.banktransaction.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    List<Transaction> findBySourceAccountAndDateBetween(String sourceAccount, LocalDateTime start, LocalDateTime end);
    List<Transaction> findBySourceAccount(String sourceAccount);
}
