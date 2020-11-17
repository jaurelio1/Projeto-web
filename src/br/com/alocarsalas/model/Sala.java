package br.com.alocarsalas.model;

public class Sala {
	
	private int codigo;
	
	private String nome;
	
	public Sala() {
		
	}

	public Sala(int codigo, String nome) {
		this.codigo = codigo;
		this.nome = nome;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int id) {
		this.codigo = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
}
