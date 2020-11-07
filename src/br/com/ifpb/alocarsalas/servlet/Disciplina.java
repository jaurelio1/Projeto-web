package br.com.ifpb.alocarsalas.servlet;

public class Disciplina {
	private String nomeDisciplina;
	private int qntAlunos;
	private int hrsAulas;
	
	public String getNomeDisciplina() {
		return nomeDisciplina;
	}
	public void setNomeDisciplina(String nomeDisciplina) {
		this.nomeDisciplina = nomeDisciplina;
	}
	public int getQntAlunos() {
		return qntAlunos;
	}
	public void setQntAlunos(int qtnAlunos) {
		this.qntAlunos = qtnAlunos;
	}
	public int getHrsAulas() {
		return hrsAulas;
	}
	public void setHrsAulas(int hrsAulas) {
		this.hrsAulas = hrsAulas;
	}

}
