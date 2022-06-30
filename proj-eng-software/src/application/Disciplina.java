package application;

import java.util.ArrayList;

public class Disciplina {
	private String nome;
	private String professor;
	private ArrayList<Aluno> alunos = new ArrayList<Aluno>();
	public Disciplina(String nome, String professor){
		this.nome = nome;
		this.professor = professor;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getProfessor() {
		return professor;
	}
	public void setProfessor(String professor) {
		this.professor = professor;
	}
	public ArrayList<Aluno> getAlunos() {
		return alunos;
	}
	public void setAlunos(ArrayList<Aluno> alunos) {
		this.alunos = alunos;
	}
}
