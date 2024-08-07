package com.example.banktransaction.service;

import com.example.banktransaction.entity.Transaction;
import com.example.banktransaction.entity.TransactionType;
import com.example.banktransaction.entity.User;
import com.example.banktransaction.repository.TransactionRepository;
import com.example.banktransaction.repository.UserRepository;
import com.example.banktransaction.util.DiscountCalculator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TransactionService {
    private final TransactionRepository transactionRepository;
    private final UserRepository userRepository;
    private final DiscountCalculator discountCalculator;

    public Transaction doTransfer(String sourceAccount, String destinationAccount, Double amount) {
        // Find the user associated with the source account
        User user = userRepository.findByAccountNumber(sourceAccount);

        // Calculate discount
        Double discount = discountCalculator.calculateDiscount(user, amount, "TRANSFER");
        Double finalAmount = amount - discount;

        // Create and save transaction
        Transaction transaction = new Transaction();
        transaction.setSourceAccount(sourceAccount);
        transaction.setDestinationAccount(destinationAccount);
        transaction.setAmount(finalAmount);
        transaction.setTransactionType(TransactionType.TRANSFER);
        transaction.setDate(LocalDateTime.now());

        return transactionRepository.save(transaction);
    }

    public Transaction buyAirtime(String sourceAccount, String networkProvider, Double amount, String phoneNumber) {
        // Create and save airtime transaction (no discount)
        Transaction transaction = new Transaction();
        transaction.setSourceAccount(sourceAccount);
        transaction.setAmount(amount);
        transaction.setTransactionType(TransactionType.AIRTIME);
        transaction.setDate(LocalDateTime.now());

        return transactionRepository.save(transaction);
    }

    public List<Transaction> getTransactionHistory(String accountNumber) {
        // Fetch transaction history by account number
        return transactionRepository.findBySourceAccount(accountNumber);
    }
}
