package testes;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import application.Aluno;

class AlunoTest {
	private Aluno aluno = new Aluno("a","a","a");
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

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
