package com.projetobanco;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class Cadastro {
    public static void realizarCadastro() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("Senha: ");
        String senha = scanner.nextLine();

        scanner.close();

        double saldoInicial = 10.0;

        try (Connection conn = Conexao.conectar()) {
            String sql = "INSERT INTO usuarios (nome, email, senha, saldo) VALUES (?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, nome);
            stmt.setString(2, email);
            stmt.setString(3, senha);
            stmt.setDouble(4, saldoInicial);
            stmt.executeUpdate();
            System.out.println("Cadastro realizado com sucesso!");
        } catch (Exception e) {
            System.out.println("Erro no cadastro: " + e.getMessage());
        }
    }
}
