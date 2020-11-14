package br.com.ifpb.model;

public class ProfessorDisciplina {
	
	private int idProfessor;
	
	private int idDisciplina;
	
	public ProfessorDisciplina() {
		
	}
	
	public ProfessorDisciplina(int idProfessor, int idDisciplina) {
		this.idProfessor = idProfessor;
		this.idDisciplina = idDisciplina;
	}

	public int getIdProfessor() {
		return idProfessor;
	}

	public void setIdProfessor(int idProfessor) {
		this.idProfessor = idProfessor;
	}

	public int getIdDisciplina() {
		return idDisciplina;
	}

	public void setIdDisciplina(int idDisciplina) {
		this.idDisciplina = idDisciplina;
	}
	
	

}
