package application;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SEV {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		AutenticacaoFacade autenticacao = new AutenticacaoFacade();
		boolean sistemaFlag = true;
		
		while(sistemaFlag) {
		System.out.println("Bem-vindo!\nSelecione uma opcao no menu:\n0- Sair\n1- Login\n2- Cadastro");
		String opcao1 = scanner.nextLine();
		switch(opcao1){
			case "0":
				sistemaFlag = false;
				break;
			case "1":
				autenticacao.login();
				break;
			case "2":
				autenticacao.cadastro();
				break;
			default:
				System.out.println("erro");
				break;
		}
	}
}
}
