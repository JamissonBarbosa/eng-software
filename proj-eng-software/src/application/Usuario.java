package application;

import java.util.ArrayList;

public class Usuario{
	private String nome;
	private String matricula;
	private String login;
	private String senha;
    private ArrayList<Disciplina> disciplinas = new ArrayList<Disciplina>();

	
	public Usuario(String nome,String login, String senha){
		this.setNome(nome);
		this.setLogin(login);
		this.setSenha(senha);
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public ArrayList<Disciplina> getDisciplinas() {
		return disciplinas;
	}

	public void setDisciplinas(ArrayList<Disciplina> disciplinas) {
		this.disciplinas = disciplinas;
	}

	public void gerarMatricula(String usuario, ArrayList<String> matriculas) {
		String codigo;
		int tamanho = matriculas.size();
		String matricula;
		
		if (usuario == "Aluno") {
			codigo = "AL";
		}
		else {
			codigo = "PR";
		}
		matricula = codigo + Integer.toString(tamanho);
		
		setMatricula(matricula);
		
	}
	

}