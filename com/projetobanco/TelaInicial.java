package com.projetobanco;
import java.sql.*;
import java.util.Scanner;

public class TelaInicial {
    public static void mostrarMenu(int userId) {
        try (Connection conn = Conexao.conectar()) {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT saldo FROM usuarios WHERE id = " + userId);
            if (rs.next()) {
                System.out.println("Saldo atual: R$" + rs.getDouble("saldo"));
            }

            Scanner scanner = new Scanner(System.in);
            System.out.print("Email do destinatário: ");
            String emailDestino = scanner.nextLine();
            System.out.print("Valor a transferir (Pix): R$");
            double valor = scanner.nextDouble();

            scanner.close();
            
            conn.setAutoCommit(false);

            // Verifica saldo do remetente
            PreparedStatement getSaldo = conn.prepareStatement("SELECT saldo FROM usuarios WHERE id = ?");
            getSaldo.setInt(1, userId);
            ResultSet rsSaldo = getSaldo.executeQuery();
            if (rsSaldo.next() && rsSaldo.getDouble("saldo") >= valor) {
                // Deduz do remetente
                PreparedStatement deduz = conn.prepareStatement("UPDATE usuarios SET saldo = saldo - ? WHERE id = ?");
                deduz.setDouble(1, valor);
                deduz.setInt(2, userId);
                deduz.executeUpdate();

                // Adiciona ao destinatário
                PreparedStatement adiciona = conn.prepareStatement("UPDATE usuarios SET saldo = saldo + ? WHERE email = ?");
                adiciona.setDouble(1, valor);
                adiciona.setString(2, emailDestino);
                int rows = adiciona.executeUpdate();

                if (rows > 0) {
                    conn.commit();
                    System.out.println("Pix enviado com sucesso!");
                } else {
                    conn.rollback();
                    System.out.println("Usuário destinatário não encontrado.");
                }
            } else {
                System.out.println("Saldo insuficiente.");
            }
        } catch (Exception e) {
            System.out.println("Erro na transferência: " + e.getMessage());
        }
    }
}
