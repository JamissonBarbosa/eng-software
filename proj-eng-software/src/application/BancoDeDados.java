package application;
import java.util.ArrayList;

public class BancoDeDados {
	private ArrayList<Aluno> alunos = new ArrayList<Aluno>();
	private ArrayList<Professor> professores = new ArrayList<Professor>();
	
	public ArrayList<Aluno> getAlunos() {
		return alunos;
	}
	public void setAlunos(ArrayList<Aluno> alunos) {
		this.alunos = alunos;
	}
	public ArrayList<Professor> getProfessores() {
		return professores;
	}
	public void setProfessores(ArrayList<Professor> professores) {
		this.professores = professores;
	}

	public void cadastrarAluno(Aluno novoAluno) {
		getAlunos().add(novoAluno);
	}
	
	public boolean consultarAluno(Aluno aluno) {
		if(getAlunos().contains(aluno)) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public void cadastrarProfessor(Professor novoProfessor) {
		getProfessores().add(novoProfessor);
	}
	
	public boolean consultarProfessor(Professor professor) {
		if(getProfessores().contains(professor)) {
			return true;
		}
		else {
			return false;
		}
	}
}
