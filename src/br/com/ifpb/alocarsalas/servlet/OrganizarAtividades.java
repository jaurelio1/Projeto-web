package br.com.ifpb.alocarsalas.servlet;

import java.util.Comparator;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class OrganizarAtividades{
	private Banco banco = new Banco();
	private List<Professor> lista = banco.getProfessores();
	private List<Professor> novalista = new ArrayList<>();
	
	public void ordenaHorarios() {
		Collections.sort(lista, new SortByRoll());
	}
	
	public void selectActivity() {
		int i = 0;
		novalista.add(lista.get(i));
		for(int j = 1; j < lista.size(); j++) {
			if(lista.get(j).getInicioAula() >= lista.get(i).getFimAula()) {				
				novalista.add(lista.get(j));
				i = j;
			}
			
		}		
	}
	
	public List<Professor> getSelectedActivity(){
		return this.novalista;
	}

	

}
