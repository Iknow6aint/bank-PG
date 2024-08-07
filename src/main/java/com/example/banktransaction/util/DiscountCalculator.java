package com.example.banktransaction.util;

import com.example.banktransaction.entity.User;
import com.example.banktransaction.entity.UserType;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.Period;

@Component
public class DiscountCalculator {

    public Double calculateDiscount(User user, Double amount, String transactionType) {
        double discount = 0.0;

        if ("TRANSFER".equals(transactionType)) {
            if (user.getUserType() == UserType.BUSINESS && amount > 150000) {
                discount = 0.27 * amount;
            } else if (user.getUserType() == UserType.RETAIL && amount > 50000) {
                discount = 0.18 * amount;
            }

            if (Period.between(user.getJoinDate(), LocalDate.now()).getYears() > 4) {
                discount += 0.10 * amount;
            }
        }

        return discount;
    }
}
