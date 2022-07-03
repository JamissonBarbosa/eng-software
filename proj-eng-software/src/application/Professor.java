package application;


public class Professor extends Usuario{

    public Professor(String nome, String login, String senha){
    	super(nome, login, senha);

    }

	@Override
	public void prefixo() {
		this.setMatricula("PR");
		
	}
	
	public boolean disciplinaExistente(Disciplina novaDisciplina){
		for(Disciplina disciplina : this.getDisciplinas()) {
			if (disciplina.getNome().equals(novaDisciplina.getNome())){
				return true;
			}
		}
		return false;
		
	}



    /*public List<Aluno> addAluno(String name, int matricula){
        Aluno a = new Aluno(name, matricula);

        List<Aluno> aluno = new ArrayList<Aluno>();

        aluno.add(a);
        return aluno;
    }*/
}
