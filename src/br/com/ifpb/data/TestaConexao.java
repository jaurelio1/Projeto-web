package br.com.ifpb.data;

import java.sql.SQLException;

import br.com.ifpb.dao.SalaDAO;
import br.com.ifpb.model.Sala;

public class TestaConexao {

	public static void main(String[] args) throws SQLException {

 
       SalaDAO salaDAO = new SalaDAO();
       
       salaDAO.save(new Sala(24));
       
	}
		
}


