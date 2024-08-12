
-- MCC
CREATE TABLE IF NOT EXISTS mcc (
    mcc integer PRIMARY KEY,
    category VARCHAR(255) NOT NULL
);

-- MERCHANT
CREATE TABLE IF NOT EXISTS merchant (
    id uuid PRIMARY KEY,
    name VARCHAR(255) NOT NULL UNIQUE,
    category VARCHAR(255) NOT NULL
);

-- ACCOUNT
CREATE TABLE IF NOT EXISTS account (
    accountId uuid NOT NULL,
    category VARCHAR(255) NOT NULL,
    PRIMARY KEY (accountId, category),
    balance DECIMAL(10, 2) NOT NULL
);

-- TRANSACTION
CREATE TABLE IF NOT EXISTS transaction (
    id uuid PRIMARY KEY,
    accountId uuid NOT NULL,
    merchant VARCHAR(255) NOT NULL,
    amount DECIMAL(10, 2) NOT NULL,
    createdAt TIMESTAMP NOT NULL);
