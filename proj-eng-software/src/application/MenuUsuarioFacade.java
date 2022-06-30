package application;

import java.util.Scanner;

public class MenuUsuarioFacade {
	private Professor professor;
	
	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(String professorLogin, BancoDeDados bd) {
		for (Professor professor : bd.getProfessores()) {
			if(professor.getLogin().equals(professorLogin)) {
				this.professor = professor;
				break;
			}
		}
	}

	public MenuUsuarioFacade(){}
	
	
	public void MenuProfessor(Scanner sc,BancoDeDados bd, String professorLogin) {
		
		this.setProfessor(professorLogin, bd);
		boolean funcionalidadeFlag = true;
		
		while (funcionalidadeFlag == true) {
			System.out.println("0- Sair\n1- Listar disciplinas\n2- Criar nova disciplina\n3- Excluir disciplina");
			String funcionalidade = sc.nextLine();
			
			switch(funcionalidade) {
			case "0":
				funcionalidadeFlag = false;
				break;
			case "1":
				break;
			case "2":
				System.out.println("Nome da disciplina: ");
				String nomeDaDisciplina = sc.nextLine();
				Disciplina disciplina = new Disciplina(nomeDaDisciplina,this.professor.getNome());
				this.professor.getDisciplinas().add(disciplina);
				System.out.println("Disciplina criada com sucesso!");
				break;
			case "3":
				break;
			default:
				System.out.println("Insira um valor válido!");
				break;
			}
		}
		
		
	}
	
	public void MenuAluno() {
		
	}
	
}
