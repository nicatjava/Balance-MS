package com.example.balancems.service;

import java.math.BigDecimal;

public interface BalanceService {
    BigDecimal getBalance();
    void updateBalance(BigDecimal newBalance);
}
