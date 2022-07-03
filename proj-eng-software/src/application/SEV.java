package application;

import java.util.Scanner;

public class SEV {
	/*private static final List<Aluno> aluno = null;*/
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
		
		/*Scanner sc = new Scanner(System.in);
	       
        System.out.println("SISTEMA DE MATRICULA:");
        System.out.print("Nome do aluno: ");
        String name = sc.nextLine();
        System.out.print("Matricula do aluno: ");
        int matricula = sc.nextInt();

        Professor p = new Professor("mario", aluno);
         
        List<Aluno> alunos = p.addAluno(name, matricula);

        for(Aluno al: alunos){
            System.out.println("Nome: "+al.name+"\n"+
                                "Matricula: "+   al.matricula);
        }*/
	}
}
