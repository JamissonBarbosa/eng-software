package application;

import java.util.ArrayList;
import java.util.List;

public class Professor extends Usuario{
	private String name;
    private List<Aluno> alunos;

    public Professor(String name, List<Aluno> alunos){
    	super();
        this.name = name;
        this.alunos = alunos;
    }

    public List<Aluno> addAluno(String name, int matricula){
        Aluno a = new Aluno(name, matricula);

        List<Aluno> aluno = new ArrayList<Aluno>();

        aluno.add(a);
        return aluno;
    }
}
