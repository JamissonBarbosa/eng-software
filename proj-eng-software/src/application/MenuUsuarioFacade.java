package application;

import java.util.Scanner;

public class MenuUsuarioFacade {
	private Professor professor;
	private Aluno aluno;
	
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

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(String alunoLogin, BancoDeDados bd) {
		for (Aluno aluno : bd.getAlunos()) {
			if(aluno.getLogin().equals(alunoLogin)) {
				this.aluno = aluno;
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
				for(Disciplina disciplina : this.getProfessor().getDisciplinas()) {
					System.out.println(this.getProfessor().getDisciplinas().indexOf(disciplina)+1 +"- "+ disciplina.getNome());
				}
				break;
			case "2":
				System.out.println("Nome da disciplina: ");
				String nomeDaDisciplina = sc.nextLine();
				Disciplina disciplina = new Disciplina(nomeDaDisciplina,this.professor.getNome());
				if(this.getProfessor().getDisciplinas().contains(disciplina)) {
					System.out.println("Disciplina ja existente.");
				}
				else {
					this.getProfessor().getDisciplinas().add(disciplina);
					bd.getDisciplinas().add(disciplina);
					System.out.println("Disciplina criada com sucesso!");
				}	
				break;
			case "3":
				break;
			default:
				System.out.println("Insira um valor valido!");
				break;
			}
		}
		
		
	}
	
	public void MenuAluno(Scanner sc,BancoDeDados bd, String alunoLogin) {
		this.setAluno(alunoLogin, bd);
		boolean funcionalidadeFlag = true;
		
		while (funcionalidadeFlag == true) {
			System.out.println("0- Sair\n1- Disciplinas matriculadas\n2- Matricular-se em disciplina");
			String funcionalidade = sc.nextLine();
			
			switch(funcionalidade) {
			case "0":
				funcionalidadeFlag = false;
				break;
			case "1":
				for(Disciplina disciplina : this.getAluno().getDisciplinas()) {
					int indexDisciplina = this.getAluno().getDisciplinas().indexOf(disciplina)+1;
					System.out.println( indexDisciplina +"- "+ disciplina.getNome());
				}
				break;
			case "2":
				boolean matriculaFlag = true;
				
				while(matriculaFlag == true) {
					System.out.println("Selecione as disciplinas que deseja matricular-se:\n0- Sair");
					for (Disciplina disciplina : bd.getDisciplinas()) {
						int indexDisciplina = bd.getDisciplinas().indexOf(disciplina)+1;
						System.out.println(indexDisciplina +"- "+ disciplina.getNome() + ", professor: "+disciplina.getProfessor());
					}
					int matricula = sc.nextInt();
					if (matricula == 0) {
						matriculaFlag = false;
						break;
					}else {
						for(Disciplina disciplina : bd.getDisciplinas()) {
							if (bd.getDisciplinas().indexOf(disciplina)==matricula-1) {
								if (this.getAluno().getDisciplinas().contains(disciplina)){
									System.out.println("Voce ja esta matriculado nesta disciplina");
									break;
								}else {
									aluno.getDisciplinas().add(disciplina);
									System.out.println("A matricula na disciplina "+ disciplina.getNome() +" foi realizada com sucesso.");
								}
							break;
							}

						}
					}
				}
				break;
				default:
					System.out.println("Opcao invalida");
			}
		}
	}
	
}
