package br.com.ifpb.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.ifpb.data.SingletonConexao;
import br.com.ifpb.model.Sala;

public class SalaDAO {

	public Sala buscar(int id) {
		
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
	            retorno.setNome(res.getString("nome"));
	        }

	    } catch (SQLException ex) {
	        System.out.println(ex);

	    }
		return retorno;
	}

	
	public void salvar(Sala sl) {
		
		String sql = "INSERT  INTO sala (id,nome) VALUES(?,?) ";

        PreparedStatement pst = SingletonConexao.getPreparedStatement(sql);

        try {

            pst.setInt(1, sl.getId());
            pst.setString(2, sl.getNome());
            pst.execute();
            pst.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
	}
	
	public ArrayList<Sala> listarTudo()  {
        String sql =  "SELECT * FROM sala";

        ArrayList<Sala> retorno = new ArrayList<Sala>();

        PreparedStatement pst =  SingletonConexao.getPreparedStatement(sql);

        ResultSet res = null;
        
        try {
            res = pst.executeQuery();

            while(res.next())
            {
                Sala item = new Sala();
                item.setId(res.getInt("id"));
                item.setNome(res.getString("nome"));
                
                retorno.add(item);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return retorno;

    }
	
	
    public	void remover(int id)  {

        String sql = "delete from sala where id=?";

        PreparedStatement pst = SingletonConexao.getPreparedStatement(sql);

        try {
            pst.setInt(1,id);
            pst.execute();
            pst.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
