package application;

import java.util.Scanner;

public class MenuUsuarioFacade {

	public MenuUsuarioFacade(){}
	
	public void MenuProfessor(Scanner sc,BancoDeDados bd, String professorLogin) {
		
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
				
				for (Professor professor : bd.getProfessores()) {
					if(professor.getLogin().equals(professorLogin)) {
						Disciplina disciplina = new Disciplina(nomeDaDisciplina,professor.getNome());
						professor.getDisciplinas().add(disciplina);
					}
				}
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
