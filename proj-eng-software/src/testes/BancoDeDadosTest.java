package testes;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import application.Aluno;
import application.BancoDeDados;
import application.Disciplina;
import application.Professor;

class BancoDeDadosTest {
	
	private BancoDeDados bd = new BancoDeDados();
	private Aluno a1 = new Aluno("a1","loginA1","senhaA1");
	private Aluno a2 = new Aluno("a2","loginA2","senhaA2");
	private Professor p1 = new Professor("p1","loginP1","senhaP1");
	private Professor p2 = new Professor("p2","loginP2","senhaP2");
	private Disciplina d1 = new Disciplina("d1","p1","ementa 1");
	private Disciplina d2 = new Disciplina("d2","p2","ementa 2");

	@Test
	void testCadastrarAluno1() {
		bd.cadastrarAluno(a1);
		assertEquals(bd.getAlunos().contains(a1),true);
	}
	@Test
	void testCadastrarAluno2() {
		bd.cadastrarAluno(a1);
		assertEquals(bd.getAlunos().contains(a2),false);
	}

	@Test
	void testConsultarAluno1() {
		bd.cadastrarAluno(a1);
		assertEquals(bd.consultarAluno(a1),true);	
	}
	@Test
	void testConsultarAluno2() {
		bd.cadastrarAluno(a1);
		assertEquals(bd.consultarAluno(a2),false);	
	}

	@Test
	void testRecuperarMatriculasAlunos() {
		bd.cadastrarAluno(a1);
		bd.cadastrarAluno(a2);
		
		a1.gerarMatriculaTemplateMethod(1, 2022);
		a2.gerarMatriculaTemplateMethod(2, 2022);
		
		ArrayList<String> matriculasAlunos = new ArrayList<String>();
		matriculasAlunos.add(a1.getMatricula());
		matriculasAlunos.add(a2.getMatricula());
		
		assertEquals(matriculasAlunos,bd.recuperarMatriculasAlunos());
	}

	@Test
	void testCadastrarProfessor1() {
		bd.cadastrarProfessor(p1);
		assertEquals(bd.getProfessores().contains(p1),true);
	}
	@Test
	void testCadastrarProfessor2() {
		bd.cadastrarProfessor(p1);
		assertEquals(bd.getProfessores().contains(p2),false);
	}

	@Test
	void testConsultarProfessor1() {
		bd.cadastrarProfessor(p1);
		assertEquals(bd.consultarProfessor(p1),true);	
	}
	@Test
	void testConsultarProfessor2() {
		bd.cadastrarProfessor(p1);
		assertEquals(bd.consultarProfessor(p2),false);	
	}
	@Test
	void testRecuperarMatriculasProfessores() {
		bd.cadastrarProfessor(p1);
		bd.cadastrarProfessor(p2);
		
		p1.gerarMatriculaTemplateMethod(1, 2022);
		p2.gerarMatriculaTemplateMethod(2, 2022);
		
		ArrayList<String> matriculasProfessores = new ArrayList<String>();
		matriculasProfessores.add(p1.getMatricula());
		matriculasProfessores.add(p2.getMatricula());
		
		assertEquals(matriculasProfessores,bd.recuperarMatriculasProfessores());
	}

	@Test
	void testConsultarLogin1() {
		bd.cadastrarAluno(a1);
		
		assertEquals(bd.consultarLogin(a1.getLogin()),true);
	}
	@Test
	void testConsultarLogin2() {
		bd.cadastrarProfessor(p1);
		
		assertEquals(bd.consultarLogin(p1.getLogin()),true);
	}
	@Test
	void testConsultarLogin3() {
		bd.cadastrarAluno(a1);
		
		assertEquals(bd.consultarLogin(a2.getLogin()),false);
	}

	@Test
	void testValidarSenhaProfessor1() {
		
		bd.cadastrarProfessor(p1);
		
		assertEquals(bd.validarSenhaProfessor(p1.getLogin(), p1.getSenha()),true);
	}
	
	@Test
	void testValidarSenhaProfessor2() {
		
		bd.cadastrarProfessor(p1);

		assertEquals(bd.validarSenhaProfessor(p2.getLogin(), p2.getSenha()),false);
	}

	@Test
	void testValidarSenhaAluno1() {
		bd.cadastrarAluno(a1);
		
		assertEquals(bd.validarSenhaAluno(a1.getLogin(), a1.getSenha()),true);

	}
	@Test
	void testValidarSenhaAluno2() {
		bd.cadastrarAluno(a1);
		
		assertEquals(bd.validarSenhaAluno(a2.getLogin(), a2.getSenha()),false);

	}

	@Test
	void testCadastrarDisciplina() {
		bd.cadastrarDisciplina(d1);
		
		assertEquals(bd.getDisciplinas().contains(d1),true);
	}
	@Test
	void testCadastrarDisciplina2() {
		bd.cadastrarDisciplina(d1);
		
		assertEquals(bd.getDisciplinas().contains(d2),false);
	}

}
