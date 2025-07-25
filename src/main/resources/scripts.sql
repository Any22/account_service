DROP TABLE IF EXISTS account_table;

CREATE TABLE account_table (
    account_id BIGSERIAL PRIMARY KEY,
    customer_id BIGINT NOT NULL,
    user_name VARCHAR(50) NOT NULL UNIQUE,
    currency VARCHAR(50) NOT NULL,
    amount NUMERIC NOT NULL  -- matches Java field type BigDecimal
);
