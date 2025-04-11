package com.projetobanco;
import java.util.Scanner;


public class Cadastro {
    public static String[] realizarCadastro() {
        Scanner scanner = new Scanner(System.in);
        String[] dados = new String[3];

        System.out.println("Nome e Sobrenome:");
        dados[0] = scanner.nextLine();

        System.out.println("Endereço de email:");
        dados[1] = scanner.nextLine();
        
        System.out.println("Senha:");
        dados[2] = scanner.nextLine();

        scanner.close();
        
        System.out.println("nome: " + dados[0]);
        System.out.println("email: " + dados[1]);
        System.out.println("senha: " + dados[2].length() + " digitos");



        return dados; 
    }
}
