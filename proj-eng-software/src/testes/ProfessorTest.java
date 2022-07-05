package testes;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import application.Disciplina;
import application.Professor;

class ProfessorTest {
	private Professor p1 = new Professor("p1","loginP1","senhaP1");
	private Disciplina d1 = new Disciplina("d1","p1","ementa 1");
	private Disciplina d2 = new Disciplina("d2","p2","ementa 2");
	
	@Test
	void testGerarMatriculaTemplateMethod() {
		p1.gerarMatriculaTemplateMethod(1, 2022);
		
		assertEquals(p1.getMatricula(),"PR122");
	}
	
	@Test
	void testDisciplinaExistente1() {
		p1.getDisciplinas().add(d1);
		
		assertEquals(p1.disciplinaExistente(d1),true);
	}
	
	@Test
	void testDisciplinaExistente2() {
		p1.getDisciplinas().add(d1);
		
		assertEquals(p1.disciplinaExistente(d2),false);
	}

}
