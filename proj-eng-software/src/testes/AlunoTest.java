package testes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import application.Aluno;

class AlunoTest {
	private Aluno a1 = new Aluno("a1","loginA1","senhaA1");

	@Test
	void testGerarMatriculaTemplateMethod() {
		a1.gerarMatriculaTemplateMethod(1, 2022);
		assertEquals(a1.getMatricula(),"AL122");
	}

}
