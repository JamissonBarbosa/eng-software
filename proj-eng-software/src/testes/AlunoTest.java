package testes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import application.Aluno;

class AlunoTest {
	private Aluno aluno = new Aluno("a","a","a");

	@Test
	void testGetMatricula() {
		aluno.gerarMatriculaTemplateMethod(1, 2022);
		assertEquals(aluno.getMatricula(),"AL122");
	}

	@Test
	void testGetNome() {
		aluno.getNome();
		assertEquals(aluno.getNome(),"a");
	}
	

	
	
	

}
