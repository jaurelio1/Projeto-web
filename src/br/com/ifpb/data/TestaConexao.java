package br.com.ifpb.data;

import java.sql.SQLException;
import java.util.ArrayList;

import br.com.ifpb.dao.DisciplinaDAO;
import br.com.ifpb.dao.SalaDAO;
import br.com.ifpb.model.Disciplina;
import br.com.ifpb.model.Sala;

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


