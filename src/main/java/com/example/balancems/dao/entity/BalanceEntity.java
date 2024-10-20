package com.example.balancems.dao.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "balance")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BalanceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private BigDecimal balance;

}
