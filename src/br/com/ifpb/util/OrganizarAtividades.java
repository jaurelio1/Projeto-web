package br.com.ifpb.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import br.com.ifpb.model.Disciplina;

public class OrganizarAtividades{
	private Banco banco = new Banco();
	private List<Disciplina> lista = banco.getDisciplina();
	private List<Disciplina> novalista = new ArrayList<>();
	
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
	
	public List<Disciplina> getSelectedActivity(){
		return this.novalista;
	}

	

}
