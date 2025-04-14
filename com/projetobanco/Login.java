package com.projetobanco;

import java.sql.*;
import java.util.Scanner;

public class Login {
    public static int realizarLogin() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("Senha: ");
        String senha = scanner.nextLine();

        scanner.close();

        try (Connection conn = Conexao.conectar()) {
            String sql = "SELECT id FROM usuarios WHERE email = ? AND senha = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, email);
            stmt.setString(2, senha);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                System.out.println("Login realizado!");
                return rs.getInt("id");
            } else {
                System.out.println("Email ou senha incorretos.");
                return -1;
            }
        } catch (Exception e) {
            System.out.println("Erro no login: " + e.getMessage());
            return -1;
        }
    }
}
