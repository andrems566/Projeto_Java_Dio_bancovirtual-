package com.projetobanco;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao {
    public static Connection conectar() {
        try {
            String url = "jdbc:mysql://localhost:3306/banco";
            String user = "root";
            String password = "suaSenha";
            return DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            System.out.println("Erro na conexão: " + e.getMessage());
            return null;
        }
    }
}
