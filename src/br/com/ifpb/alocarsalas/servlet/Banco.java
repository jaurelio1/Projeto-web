package br.com.ifpb.alocarsalas.servlet;

import java.util.ArrayList;
import java.util.List;

import br.com.ifpb.model.Professor;

public class Banco {
	private static List<Professor> lista = new ArrayList<>();
	
	
	public void adiciona(Professor professor) {
		Banco.lista.add(professor);
	}
	
	public List<Professor> getProfessores(){
		return Banco.lista;
	}

}
