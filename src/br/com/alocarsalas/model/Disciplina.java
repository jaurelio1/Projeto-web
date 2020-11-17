package br.com.alocarsalas.model;

public class Disciplina {
	private String nome;
	private int codigo;
	private int quantidadeAlunos;
	private int cargaHoraria;
	private String diaAula;
	private String inicioAula, fimAula;
	private Sala sala;
	
	public Disciplina() {
		
	}
	
	public Disciplina(String nome, int codigo, int quantidadeAlunos, int cargaHoraria, String diaAula, String inicioAula, String fimAula, Sala sala){
		this.nome = nome;
		this.codigo = codigo;
		this.quantidadeAlunos = quantidadeAlunos;
		this.cargaHoraria = cargaHoraria;
		this.diaAula = diaAula;
		this.inicioAula = inicioAula;
		this.fimAula = fimAula;
		this.sala = sala;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
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
		return diaAula;
	}

	public void setDiaAula(String diaAula) {
		this.diaAula = diaAula;
	}

	public String getInicioAula() {
		return inicioAula;
	}

	public void setInicioAula(String inicioAula) {
		this.inicioAula = inicioAula;
	}

	public String getFimAula() {
		return fimAula;
	}

	public void setFimAula(String fimAula) {
		this.fimAula = fimAula;
	}

	public Sala getSala() {
		return sala;
	}

	public void setSala(Sala sala) {
		this.sala = sala;
	}
	
}
