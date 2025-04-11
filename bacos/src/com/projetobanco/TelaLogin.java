package com.projetobanco;
import java.util.Scanner;

public class TelaLogin {
    public static void cadastro() {
		Scanner scanner = new Scanner(System.in);
        
        System.out.println("Digite seu nome de usuário:");
		String usuarioext = scanner.nextLine();//ext seria abreviação de existente

        System.out.println("Digite sua senha:");
        String senhaext = scanner.nextLine();//ext seria abreviação de existente

		scanner.close();
	}
}
