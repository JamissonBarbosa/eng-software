package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AutenticacaoFacade {
	private Scanner scanner = new Scanner(System.in);
	private BancoDeDados bd = new BancoDeDados();

	
	public Scanner getScanner() {
		return scanner;
	}
	public BancoDeDados getBd() {
		return bd;
	}
	public void setBd(BancoDeDados bd) {
		this.bd = bd;
	}
	
	public AutenticacaoFacade(){
	}
	public void cadastro() {
		String tipoUsuario = "Aluno";
		List<String> matriculas;

		System.out.println("Nome: ");
		String nome = this.getScanner().nextLine();
		System.out.println("login: ");
		String login = this.getScanner().nextLine();
		System.out.println("senha: ");
		String senha = this.getScanner().nextLine();
		
		Aluno aluno = new Aluno(nome,login,senha);
		
		getBd().cadastrarAluno(aluno);
		matriculas = new ArrayList<String>();
		
		aluno.gerarMatricula(tipoUsuario,matriculas);
		System.out.println("Sua matricula: ");
		System.out.println(aluno.getMatricula());
	}
	
	public void login() {
		System.out.println("implementar");

	}

}
