package com.example.taskmicrosrevice.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "transactions")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "account_from")
    private Long accountFrom;
    @Column(name = "account_to")
    private Long accountTo;
    @Column(name = "currency_short_name")
    private String currencyShortName;
    private BigDecimal sum;
    @Column(name = "expense_category")
    private String expenseCategory;
    private LocalDateTime datetime;
    @Column(name = "limit_exceeded")
    private boolean limitExceeded;

}
