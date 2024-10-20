package com.example.balancems.controller;

import com.example.balancems.service.BalanceService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("/api/v1/balance")
@RequiredArgsConstructor
public class BalanceController {

    private final BalanceService balanceService;

    @GetMapping
    public BigDecimal getBalance() {
        return balanceService.getBalance();
    }

    @PostMapping("/update")
    public void updateBalance(@RequestBody BigDecimal amount) {
        balanceService.updateBalance(amount);
    }

}
