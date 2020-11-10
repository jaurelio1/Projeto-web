package br.com.ifpb.model;

public class Disciplina {
	private String nome;
	private int codigo;
	private int quantidadeAlunos;
	private int cargaHoraria;
	private String diaAula;
	private int inicioAula, fimAula, hora, min;
	private Sala sala;
	private Professor professor;
	
	public Disciplina(String nome,int codigo ,int quantidadeAlunos, int cargaHoraria, String diaAula, Sala sala, Professor professor) {
		this.nome = nome;
		this.codigo = codigo;
		this.quantidadeAlunos = quantidadeAlunos;
		this.cargaHoraria = cargaHoraria;
		this.diaAula = diaAula;
		this.sala = sala;
		this.professor = professor;
	}
	
	public Disciplina() {
		
	}
	
	public String getNome() {
		return nome;
	}

	public int getCodigo() {
		return codigo;
	}

	public int getQuantidadeAlunos() {
		return quantidadeAlunos;
	}

	public int getCargaHoraria() {
		return cargaHoraria;
	}

	public String getDiaAula() {
		return diaAula;
	}

	public Sala getSala() {
		return sala;
	}

	public Professor getProfessor() {
		return professor;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public void setQuantidadeAlunos(int quantidadeAlunos) {
		this.quantidadeAlunos = quantidadeAlunos;
	}

	public void setCargaHoraria(int cargaHoraria) {
		this.cargaHoraria = cargaHoraria;
	}

	public void setDiaAula(String diaAula) {
		this.diaAula = diaAula;
	}

	public void setInicioAula(int inicioAula) {
		this.inicioAula = inicioAula;
	}

	public void setFimAula(int fimAula) {
		this.fimAula = fimAula;
	}

	public void setSala(Sala sala) {
		this.sala = sala;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
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
