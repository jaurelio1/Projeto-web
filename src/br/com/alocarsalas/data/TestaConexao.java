package br.com.alocarsalas.data;

import java.sql.SQLException;
import java.util.ArrayList;

import br.com.alocarsalas.dao.DisciplinaDAO;
import br.com.alocarsalas.model.Disciplina;

public class TestaConexao {

	public static void main(String[] args) throws SQLException {

 
       DisciplinaDAO dDAO = new DisciplinaDAO();
       

		ArrayList<Disciplina> lista = dDAO.listarTudo();
		
		System.out.println(lista.toString());
		
		 for (Disciplina item : lista) {
	            System.out.println(item.getNome());
	        }
       
	}
		
}


