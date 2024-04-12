package com.example.taskmicrosrevice.repository;

import com.example.taskmicrosrevice.model.entity.ExchangeRate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Optional;
@Repository

public interface ExchangeRateRepository extends JpaRepository<ExchangeRate, Long> {
    Optional<ExchangeRate> findByCurrencyPairAndExchangeDate(String currencyPair, LocalDate exchangeDate);
}
