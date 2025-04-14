package com.projetobanco;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("1 - Cadastro\n2 - Login");
        int escolha = scanner.nextInt();
        scanner.nextLine(); // consumir \n

        scanner.close();

        if (escolha == 1) {
            Cadastro.realizarCadastro();
        } else if (escolha == 2) {
            int userId = Login.realizarLogin();
            if (userId != -1) {
                TelaInicial.mostrarMenu(userId);
            }
        } else {
            System.out.println("Opção inválida");
        }
    }
}
