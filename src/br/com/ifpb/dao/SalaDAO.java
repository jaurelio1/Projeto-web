package br.com.ifpb.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.ifpb.data.SingletonConexao;
import br.com.ifpb.model.Sala;

public class SalaDAO {

	public Sala find(int id) {
		
		String sql = "SELECT * FROM sala WHERE id=?";

	    Sala retorno = null;

	    PreparedStatement pst =  SingletonConexao.getPreparedStatement(sql);
	    try {

	    	pst.setInt(1, id);
	        ResultSet res = pst.executeQuery();

	        if(res.next())
	        {
	            retorno = new Sala();
	            retorno.setId(res.getInt("id"));
	        }

	    } catch (SQLException ex) {
	        System.out.println(ex);

	    }
		return retorno;
	}

	
	public void save(Sala sl) {
		
		String sql = "INSERT  INTO sala (id) VALUES(?) ";

        PreparedStatement pst = SingletonConexao.getPreparedStatement(sql);

        try {

            pst.setInt(1, sl.getId());
            pst.execute();
            pst.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
	}
}
