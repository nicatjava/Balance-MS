package com.example.balancems.service.impl;

import com.example.balancems.dao.entity.BalanceEntity;
import com.example.balancems.dao.repository.BalanceRepository;
import com.example.balancems.exception.BalanceNotFoundException;
import com.example.balancems.service.BalanceService;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class BalanceServiceImpl implements BalanceService {

    private final BalanceRepository balanceRepository;

    @Override
    public BigDecimal getBalance() {
        // Balance Id only
        BalanceEntity balanceEntity = balanceRepository.findById(1L)
                .orElseThrow(() -> new BalanceNotFoundException("Balance not found"));
        return balanceEntity.getBalance();
    }

    public void updateBalance(BigDecimal newBalance) {
        BalanceEntity balanceEntity = balanceRepository.findById(1L)
                .orElseThrow(() -> new BalanceNotFoundException("Balance not found"));
        balanceEntity.setBalance(newBalance);
        balanceRepository.save(balanceEntity);
    }

    //If Balance Not Exist Create It
    @PostConstruct
    public void initializeBalance() {
        if (!balanceRepository.existsById(1L)) {
            BalanceEntity initialBalance = new BalanceEntity();
            initialBalance.setId(1L);
            initialBalance.setBalance(BigDecimal.ZERO);
            balanceRepository.save(initialBalance);
        }
    }
}
