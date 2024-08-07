package com.example.banktransaction.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String sourceAccount;
    private String destinationAccount;
    private Double amount;

    @Enumerated(EnumType.STRING)
    private TransactionType transactionType; // TRANSFER or AIRTIME
    private LocalDateTime date;
}
