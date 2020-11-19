package br.com.alocarsalas.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.alocarsalas.data.ConexaoBancoDeDados;
import br.com.alocarsalas.model.Sala;

public class SalaDAO {

	public Sala buscar(int codigo) {
		
		String sql = "SELECT * FROM sala WHERE codigo=?";

	    Sala retorno = null;

	    PreparedStatement pst =  ConexaoBancoDeDados.getPreparedStatement(sql);
	    try {

	    	pst.setInt(1, codigo);
	        ResultSet res = pst.executeQuery();

	        if(res.next())
	        {
	            retorno = new Sala();
	            retorno.setCodigo(res.getInt("codigo"));
	            retorno.setNome(res.getString("nome"));
	        }
	        
	        pst.close();
	        res.close();
	        
	    } catch (SQLException ex) {
	        System.out.println(ex);

	    }
	    ConexaoBancoDeDados.closeConexao();
		return retorno;
	}

	
	public void salvar(Sala sala) {
		
		String sql = "INSERT  INTO sala (codigo,nome) VALUES(?,?) ";

        PreparedStatement pst = ConexaoBancoDeDados.getPreparedStatement(sql);

        try {

            pst.setInt(1, sala.getCodigo());
            pst.setString(2, sala.getNome());
            pst.execute();
            pst.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        ConexaoBancoDeDados.closeConexao();
	}
	
	public ArrayList<Sala> listarTudo()  {
        String sql =  "SELECT * FROM sala";

        ArrayList<Sala> retorno = new ArrayList<Sala>();

        PreparedStatement pst =  ConexaoBancoDeDados.getPreparedStatement(sql);

        ResultSet res = null;
        
        try {
            res = pst.executeQuery();

            while(res.next())
            {
                Sala item = new Sala();
                item.setCodigo(res.getInt("codigo"));
                item.setNome(res.getString("nome"));
                
                retorno.add(item);

            }
            
            pst.close();
            res.close();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        ConexaoBancoDeDados.closeConexao();
        return retorno;

    }
	
	
    public	void remover(int codigo)  {

        String sql = "delete from sala where codigo=?";

        PreparedStatement pst = ConexaoBancoDeDados.getPreparedStatement(sql);

        try {
            pst.setInt(1,codigo);
            pst.execute();
            pst.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        ConexaoBancoDeDados.closeConexao();
    }
    
    public	void editar(Sala sala)  {
    	
    	if (this.buscar(sala.getCodigo()) == null) {
    		this.salvar(sala);
    	}
    	else {
    		 String sql = "update sala set codigo =?, nome =? where codigo=?";
    		 
    		 PreparedStatement pst = ConexaoBancoDeDados.getPreparedStatement(sql);
    	        try {
    	            pst.setInt(1,sala.getCodigo());
    	            pst.setString(2,sala.getNome());
    	            pst.setInt(3,sala.getCodigo());
    	            pst.execute();
    	            pst.close();
    	        } catch (SQLException e) {
    	            e.printStackTrace();
    	        }
    	}
    	 ConexaoBancoDeDados.closeConexao();
    }
    
}
