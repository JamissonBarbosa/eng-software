package application;

import java.util.Scanner;

import exceptions.DisciplinaExistenteException;
import exceptions.EntradaInvalidaException;
import exceptions.LimiteDisciplinaException;

public class MenuUsuarioFacade {
	private Professor professor;
	private Aluno aluno;
	private Scanner scFuncionalidade = new Scanner(System.in);

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

	public Scanner getScFuncionalidade() {
		return scFuncionalidade;
	}

	public MenuUsuarioFacade(){}
	
	
	public void MenuProfessor(BancoDeDados bd, String professorLogin) throws EntradaInvalidaException{
		Scanner scCriarDisciplina = new Scanner(System.in);
		this.setProfessor(professorLogin, bd);
		
		System.out.println("Login realizado com sucesso como Professor");

		
		boolean funcionalidadeFlag = true;
		
		while (funcionalidadeFlag == true) {
			System.out.println("0- Sair\n1- Listar disciplinas\n2- Criar nova disciplina\n3- Excluir disciplina");
			String funcionalidade = this.getScFuncionalidade().nextLine();
			
			switch(funcionalidade) {
			case "0":
				funcionalidadeFlag = false;
				break;
			case "1":
				this.getProfessor().listarDisciplinas();
				break;
			case "2":
				System.out.println("Nome da disciplina: ");
				String nomeDisciplina = scCriarDisciplina.nextLine();
				System.out.println("Ementa da disciplina: ");
				String ementaDisciplina = scCriarDisciplina.nextLine();
				Disciplina disciplina = new Disciplina(nomeDisciplina,this.professor.getNome(),ementaDisciplina);
				this.criarDisciplina(disciplina, bd);	
				break;
			case "3":
				break;
			default:
				throw new EntradaInvalidaException();
			}
		}
	}
	public void criarDisciplina(Disciplina disciplina, BancoDeDados bd) {
		try {
			if(this.getProfessor().disciplinaExistente(disciplina) == false) {
				try {
					this.getProfessor().adicionarDisciplina(disciplina, bd);
				} catch (LimiteDisciplinaException lde) {
					System.out.println(lde.getMessage()); 
				}
			}
		} catch (DisciplinaExistenteException dee) {
			System.out.println(dee.getMessage()); 
		}
	}
	
	public void MenuAluno(BancoDeDados bd, String alunoLogin) {
		Scanner scMatricula = new Scanner(System.in);
		this.setAluno(alunoLogin, bd);
		boolean funcionalidadeFlag = true;
		
		while (funcionalidadeFlag == true) {
			System.out.println("0- Sair\n1- Disciplinas matriculadas\n2- Matricular-se em disciplina");
			String funcionalidade = this.getScFuncionalidade().nextLine();
			
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
						System.out.println(indexDisciplina +"- "+ disciplina.getNome() + ", professor: "+disciplina.getProfessor()+", ementa: "+disciplina.getEmenta());
					}
					int matricula = scMatricula.nextInt();
					if (matricula == 0) {
						matriculaFlag = false;
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
