package br.com.ifpb.model;

public class Disciplina {
	private String nome;
	private int quantidadeAlunos;
	private int cargaHoraria;
	private Professor professor;
	private String diaAula;
	private int inicioAula, fimAula, hora, min;
	private Sala sala;
	
	public Disciplina(String nome, int quantidadeAlunos, int cargaHoraria, String diaAula, Sala sala, Professor professor) {
		this.nome = nome;
		this.quantidadeAlunos = quantidadeAlunos;
		this.cargaHoraria = cargaHoraria;
		this.diaAula = diaAula;
		this.sala = sala;
		this.professor = professor;
		
		
	}
	public Sala getSala() {
		return sala;
	}
	public Professor getProfessor() {
		return professor;
	}
	
	public int getIDProfessor() {
		return this.professor.getMatricula();
	}
	public void setProfessor(Professor professor) {
		this.professor = professor;
	}
	public void setSala(Sala sala) {
		this.sala = sala;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getQuantidadeAlunos() {
		return quantidadeAlunos;
	}
	public void setQuantidadeAlunos(int quantidadeAlunos) {
		this.quantidadeAlunos = quantidadeAlunos;
	}
	public int getCargaHoraria() {
		return cargaHoraria;
	}
	public void setCargaHoraria(int cargaHoraria) {
		this.cargaHoraria = cargaHoraria;
	}
	
	public String getDiaAula() {
		return this.diaAula;
	}

	public void setDiaAula(String diaAula) {
		this.diaAula = diaAula;		
	}
	
	public int getInicioAula() {
		return this.inicioAula;
	}

	//recebe a string e transforma em um inteiro informando em minutos o inicio da aula em min
	public void setInicioAula(String inicioAula) {
		this.hora = Integer.parseInt(inicioAula.substring(0, 2));
		this.min = Integer.parseInt(inicioAula.substring(3, 5));
		this.inicioAula = (this.hora*60)+this.min;		
	}

	public int getFimAula() {
		return this.fimAula;
	}
	
	public void setFimAula(String fimAula) {
		this.hora = Integer.parseInt(fimAula.substring(0, 2));
		this.min = Integer.parseInt(fimAula.substring(3, 5));
		this.fimAula = (this.hora*60)+this.min;		
	}
	
	
}
