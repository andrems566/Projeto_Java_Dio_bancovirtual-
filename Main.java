package com.projetobanco; 
//import javax.swing.JFrame;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		System.out.println("Bem-vindo ao muubank!");

		telaPrincipal();
	}
	
	public static void telaPrincipal() {
        System.out.println("Escolha como prosseguir");
        Scanner scanner = new Scanner(System.in);

        System.out.println("1 -- Login");
        System.out.println("2 -- Cadastro");
        int opcao = scanner.nextInt();

        
        if (opcao == 1) {
            TelaLogin.cadastro(); 
        } else if (opcao == 2) {
            Cadastro.realizarCadastro(); 
        }
        else{
            System.out.println("Erro... opção inválida");
        }
        scanner.close();
	}
	
}

