package br.com.ifpb.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.com.ifpb.alocarsalas.servlet.Aula;

public class Professor implements Aula{
	private String nomeProfessor;
	private int cargaHoraria;
	private Date diaAula;
	private int inicioAula, fimAula, hora, min;
	private Disciplina dis = new Disciplina();
	private List<Disciplina> disciplinas = new ArrayList<>();
	
	public void adicionaDisciplina(String nomeDisciplina, int quantidadeAlunos, int hrsAulas) {
		dis.setNomeDisciplina(nomeDisciplina);
		dis.setQntAlunos(quantidadeAlunos);
		dis.setHrsAulas(hrsAulas);
		disciplinas.add(dis);		
	}
	
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
