package application;

import java.util.Calendar;
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
			
			if (this.getBd().consultarLogin(login) == true){
				System.out.println("Login ja existente, tente novamente");
			}else {
				switch(tipoUsuario) {
				case "1":
					
					Aluno aluno = new Aluno(nome,login,senha);
					this.getBd().cadastrarAluno(aluno);
					aluno.gerarMatriculaTemplateMethod(this.getBd().recuperarMatriculasAlunos().size(),Calendar.getInstance().get(Calendar.YEAR));
					cadastroFlag = false;
					break;
				case "2":
					Professor professor = new Professor(nome,login,senha);
					this.getBd().cadastrarProfessor(professor);
					professor.gerarMatriculaTemplateMethod(this.getBd().recuperarMatriculasProfessores().size(),Calendar.getInstance().get(Calendar.YEAR));
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
		/*disciplinas e aluno de teste*/
		Disciplina d1 = new Disciplina("d1","abc","abc");
		this.getBd().getDisciplinas().add(d1);
		Disciplina d2 = new Disciplina("d2","abc","abc");
		this.getBd().getDisciplinas().add(d2);
		Aluno a1 = new Aluno("a1","a1","a1");
		this.getBd().getAlunos().add(a1);
		
		boolean loginFlag = true;
		
		while(loginFlag == true) {
			System.out.println("Voce e aluno ou professor?\n1- Aluno\n2-Professor");
			String tipoUsuario = this.getScanner().nextLine();
			
			System.out.println("login:");
			String login = this.getScanner().nextLine();
			System.out.println("senha:");
			String senha = this.getScanner().nextLine();
			
			
			if (this.getBd().consultarLogin(login) == false) {
				System.out.println("Usuario nao encontrado");
			}
			else {
				switch(tipoUsuario) {
				case "1":
					if(this.getBd().validarSenhaAluno(login, senha) == false) {
						System.out.println("Senha invalida para Aluno");
					}else {
						System.out.println("Login realizado com sucesso como Aluno");
						this.getMenuUsuario().MenuAluno(this.getBd(), login);
						loginFlag = false;
					}
					break;
				case "2":
					if(this.getBd().validarSenhaProfessor(login, senha) == false) {
						System.out.println("Senha invalida para Professor");
					}else {
						System.out.println("Login realizado com sucesso como Professor");
						this.getMenuUsuario().MenuProfessor(this.getBd(), login);
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
