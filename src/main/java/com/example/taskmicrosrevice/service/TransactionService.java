package com.example.taskmicrosrevice.service;

import com.example.taskmicrosrevice.model.entity.ExchangeRate;
import com.example.taskmicrosrevice.model.entity.Limit;
import com.example.taskmicrosrevice.model.entity.Transaction;
import com.example.taskmicrosrevice.repository.ExchangeRateRepository;
import com.example.taskmicrosrevice.repository.LimitRepository;
import com.example.taskmicrosrevice.repository.TransactionRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TransactionService {
    private final TransactionRepository transactionRepository;
    private final LimitRepository limitRepository;
    private final ExchangeRateRepository exchangeRateRepository;

    public TransactionService(TransactionRepository transactionRepository,
                              LimitRepository limitRepository,
                              ExchangeRateRepository exchangeRateRepository) {
        this.transactionRepository = transactionRepository;
        this.limitRepository = limitRepository;
        this.exchangeRateRepository = exchangeRateRepository;
    }

    public List<Transaction> getAllTransactions() {
        return transactionRepository.findAll();
    }

    public Transaction saveTransaction(Transaction transaction) {
        return transactionRepository.save(transaction);
    }

    public List<Transaction> getTransactionsExceedingLimit() {
        List<Transaction> transactions = new ArrayList<>();
        List<Limit> limits = limitRepository.findAll();

        for (Limit limit : limits) {
            BigDecimal totalSumInUSD = BigDecimal.ZERO;
            BigDecimal limitSumInUSD = limit.getLimitSum();

            List<Transaction> transactionsForLimit = transactionRepository.findByAccountFromAndDatetimeAfter(
                    limit.getAccountFrom(),
                    limit.getLimitDatetime()
            );

            for (Transaction transaction : transactionsForLimit) {
                BigDecimal exchangeRate = getExchangeRate(transaction.getCurrencyShortName(), transaction.getDatetime().toLocalDate());
                BigDecimal transactionSumInUSD = transaction.getSum().multiply(exchangeRate);
                totalSumInUSD = totalSumInUSD.add(transactionSumInUSD);

                if (totalSumInUSD.compareTo(limitSumInUSD) > 0) {
                    transaction.setLimitExceeded(true);
                    transactions.add(transaction);
                }
            }
        }

        return transactions;
    }

    private BigDecimal getExchangeRate(String baseCurrency, LocalDate date) {
        Optional<ExchangeRate> exchangeRate = exchangeRateRepository.findByCurrencyPairAndExchangeDate(baseCurrency + "/" + "USD", date);

        if (exchangeRate.isPresent()) {
            return exchangeRate.get().getExchangeRate();
        } else {
            return BigDecimal.ONE;
        }
    }
}
