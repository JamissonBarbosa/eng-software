package application;

import java.util.Scanner;

public class AutenticacaoFacade {
	private Scanner scanner = new Scanner(System.in);
	private BancoDeDados bd = new BancoDeDados();
	private MenuUsuarioFacade menuUsuario = new MenuUsuarioFacade();

	
	public Scanner getScanner() {
		return scanner;
	}
	public BancoDeDados getBd() {
		return bd;
	}
	public void setBd(BancoDeDados bd) {
		this.bd = bd;
	}
	
	public MenuUsuarioFacade getMenuUsuario() {
		return menuUsuario;
	}
	public void setMenuUsuario(MenuUsuarioFacade menuUsuario) {
		this.menuUsuario = menuUsuario;
	}
	public AutenticacaoFacade(){
	}
	public void cadastro() {
		
		System.out.println("Voce e um:\n1- Aluno\n2- Professor");
		String tipoUsuario = this.getScanner().nextLine();
		
		boolean cadastroFlag = true;
		
		while(cadastroFlag == true) {
			System.out.println("Nome: ");
			String nome = this.getScanner().nextLine();
			System.out.println("login: ");
			String login = this.getScanner().nextLine();
			System.out.println("senha: ");
			String senha = this.getScanner().nextLine();
			
			if (bd.consultarLogin(login) == true){
				System.out.println("Login ja existente, tente novamente");
			}else {
				switch(tipoUsuario) {
				case "1":
					
					Aluno aluno = new Aluno(nome,login,senha);
					getBd().cadastrarAluno(aluno);
					aluno.gerarMatricula("Aluno",getBd().recuperarMatriculasAlunos());
					System.out.println("Cadastro concluido com sucesso!\nSua matricula: ");
					System.out.println(aluno.getMatricula());
					cadastroFlag = false;
					break;
				case "2":
					Professor professor = new Professor(nome,login,senha);

					getBd().cadastrarProfessor(professor);
					professor.gerarMatricula("Professor",getBd().recuperarMatriculasProfessores());
					System.out.println("Cadastro concluido com sucesso!\nSua matricula: ");
					System.out.println(professor.getMatricula());
					cadastroFlag = false;
					break;
				case "0":
					cadastroFlag = false;
					break;
				default:
					System.out.println("erro");
					break;
				}
			}			
		}		
	}
	
	public void login() {
		
		boolean loginFlag = true;
		
		while(loginFlag == true) {
			System.out.println("Voce e aluno ou professor?\n1- Aluno\n2-Professor");
			String tipoUsuario = this.getScanner().nextLine();
			
			System.out.println("login:");
			String login = this.getScanner().nextLine();
			System.out.println("senha:");
			String senha = this.getScanner().nextLine();
			
			
			if (bd.consultarLogin(login) == false) {
				System.out.println("Usuario não encontrado");
			}
			else {
				switch(tipoUsuario) {
				case "1":
					if(bd.validarSenhaAluno(login, senha) == false) {
						System.out.println("Senha invalida para Aluno");
					}else {
						System.out.println("Login realizado com sucesso como Aluno");
						loginFlag = false;
					}
					break;
				case "2":
					if(bd.validarSenhaProfessor(login, senha) == false) {
						System.out.println("Senha invalida para Professor");
					}else {
						System.out.println("Login realizado com sucesso como Professor");
						this.getMenuUsuario().MenuProfessor(this.getScanner(), bd, login);
						loginFlag = false;
						
					}
					break;
				case "0":
					loginFlag = false;
					break;
				default:
					System.out.println("erro");
				}
			}
		}
	}
}
