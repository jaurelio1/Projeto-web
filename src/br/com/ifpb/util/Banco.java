package br.com.ifpb.util;

import java.util.ArrayList;
import java.util.List;

import br.com.ifpb.model.Disciplina;
import br.com.ifpb.model.Professor;

public class Banco {
	private static List<Professor> lista = new ArrayList<>();
	private static List<Disciplina> listaDisciplina = new ArrayList<>();
	
	
	public void adiciona(Professor professor) {
		Banco.lista.add(professor);
	}
	
	public List<Professor> getProfessores(){
		return Banco.lista;
	}
	
	
	public void adicionaDisciplina(Disciplina disciplina) {
		Banco.listaDisciplina.add(disciplina);
	}
	
	public List<Disciplina> getDisciplina(){
		return Banco.listaDisciplina;
	}

}
