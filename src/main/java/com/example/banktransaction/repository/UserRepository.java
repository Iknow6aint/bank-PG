package com.example.banktransaction.repository;

import com.example.banktransaction.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByAccountNumber(String accountNumber);
}
