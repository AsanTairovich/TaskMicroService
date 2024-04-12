INSERT INTO transactions (account_from, account_to, currency_short_name, sum, expense_category, datetime, limit_exceeded)
VALUES (1234567890, 9876543210, 'USD', 1000.00, 'product', current_date, true),
       (1234567891, 9876543211, 'KZT', 1000.00, 'product', current_date, true),
       (1234567892, 9876543212, 'RUB', 1000.00, 'product', current_date, true);

INSERT INTO limits (account_from, limit_sum, limit_datetime, limit_currency_short_name)
VALUES (1234567890, 1000.00, current_date, 'USD'),
       (1234567891, 1000.00, current_date, 'KZT'),
       (1234567892, 1000.00, current_date, 'RUB');

INSERT INTO exchange_rates (currency_pair, exchange_rate, exchange_date)
VALUES ('KZT/USD', 0.0025, current_date),
       ('KZT/RUB', 0.21, current_date),
       ('USD/RUB', 0.011, current_date);

