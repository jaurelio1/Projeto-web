package br.com.ifpb.alocarsalas.servlet;

import java.util.Comparator;

public class SortByRoll implements Comparator<Professor>{
	@Override
	public int compare(Professor a, Professor b) {
		return a.getInicioAula() - b.getInicioAula();
	}
}