package application;


public class Professor extends Usuario{

    public Professor(String nome, String login, String senha){
    	super(nome, login, senha);

    }

	@Override
	public void prefixo() {
		this.setMatricula("PR");
		
	}



    /*public List<Aluno> addAluno(String name, int matricula){
        Aluno a = new Aluno(name, matricula);

        List<Aluno> aluno = new ArrayList<Aluno>();

        aluno.add(a);
        return aluno;
    }*/
}
