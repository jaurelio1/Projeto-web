package br.com.ifpb.alocarsalas.servlet;

import java.time.LocalDateTime;
import java.util.Date;

public class Professor extends Disciplina implements Aula{
	private String nomeProfessor;
	private int cargaHoraria;
	private Date diaAula;
	private int inicioAula, fimAula, hora, min;
	
	public void setNome(String nome) {
		this.nomeProfessor = nome;		
	}
	
	public String getNome() {
		return this.nomeProfessor;
	}
	
	public void setCargaHoraria(int cargaHoraria) {
		this.cargaHoraria = cargaHoraria;		
	}
	
	public int getCargaHoraria() {
		return this.cargaHoraria;
	}

	@Override
	public Date getDiaAula() {
		return this.diaAula;
	}

	@Override
	public void setDiaAula(Date diaAula) {
		this.diaAula = diaAula;		
	}

	@Override
	public int getInicioAula() {
		return this.inicioAula;
	}

	@Override
	//recebe a string e transforma em um inteiro informando em minutos o inicio da aula em min
	public void setInicioAula(String inicioAula) {
		this.hora = Integer.parseInt(inicioAula.substring(0, 2));
		this.min = Integer.parseInt(inicioAula.substring(3, 5));
		this.inicioAula = (this.hora*60)+this.min;		
	}

	@Override
	public int getFimAula() {
		return this.fimAula;
	}

	@Override
	public void setFimAula(String fimAula) {
		this.hora = Integer.parseInt(fimAula.substring(0, 2));
		this.min = Integer.parseInt(fimAula.substring(3, 5));
		this.fimAula = (this.hora*60)+this.min;		
	}
	
	

}
