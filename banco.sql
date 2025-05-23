CREATE DATABASE IF NOT EXISTS banco;
USE banco;

CREATE TABLE IF NOT EXISTS usuarios (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    senha VARCHAR(100) NOT NULL,
    saldo DECIMAL(10, 2) NOT NULL DEFAULT 10.00
);
