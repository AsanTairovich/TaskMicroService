package com.example.taskmicrosrevice.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "limits")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Limit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "account_from")
    private Long accountFrom;
    @Column(name = "limit_sum")
    private BigDecimal limitSum;
    @Column(name = "limit_datetime")
    private LocalDateTime limitDatetime;
    @Column(name = "limit_currency_short_name")
    private String limitCurrencyShortName;
}
