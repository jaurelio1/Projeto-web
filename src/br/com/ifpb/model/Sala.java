package br.com.ifpb.model;

public class Sala {
	
	private int id;
	
	private String nome;
	
	public Sala() {
		
	}

	public Sala(int id, String nome) {
		this.id = id;
		this.nome = nome;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
}
