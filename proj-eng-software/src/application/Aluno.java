package application;

public class Aluno extends Usuario{;

    public Aluno(String nome, String login, String senha){
    	super(nome, login, senha);

    }

	@Override
	public void prefixo() {
		this.setMatricula("AL");
		
	}

}
