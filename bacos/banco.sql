CREATE DATABASE banco_cadastros;

USE banco_cadastros;

CREATE  TABLE usuarios(
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR (100),
    email VARCHAR (100),
    senha VARCHAR (100)
);

INSERT INTO usuarios (nome, email, senha) VALUES (Cadastro.java) 