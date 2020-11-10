package br.com.ifpb.util;

import java.util.Comparator;

import br.com.ifpb.model.Disciplina;

public class SortByRoll implements Comparator<Disciplina>{
	@Override
	public int compare(Disciplina a, Disciplina b) {
		return a.getInicioAula() - b.getInicioAula();
	}
}