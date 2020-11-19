package br.com.alocarsalas.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.alocarsalas.data.ConexaoBancoDeDados;
import br.com.alocarsalas.model.Professor;

public class ProfessorDAO {

	public	void salvar(Professor p)  {

        String sql = "INSERT  INTO professor (nome,matricula,cargaHoraria) VALUES(?,?,?) ";

        PreparedStatement pst = ConexaoBancoDeDados.getPreparedStatement(sql);

        try {

            pst.setString(1,p.getNome());
            pst.setInt(2,p.getMatricula());
            pst.setInt(3,p.getCargaHoraria());
            pst.execute();
            pst.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        ConexaoBancoDeDados.closeConexao();
    }
	
	
	public Professor buscar(int id) {
		
		String sql = "SELECT * FROM professor WHERE matricula=?";

	    Professor retorno = null;

	    PreparedStatement pst =  ConexaoBancoDeDados.getPreparedStatement(sql);
	    try {

	    	pst.setInt(1, id);
	        ResultSet res = pst.executeQuery();

	        if(res.next())
	        {
	            retorno = new Professor();
	            retorno.setMatricula(res.getInt("matricula"));
	            retorno.setNome(res.getString("nome"));
	            retorno.setCargaHoraria(res.getInt("cargaHoraria"));
	        }
	        
	        pst.close();
	        res.close();

	    } catch (SQLException ex) {
	        System.out.println(ex);

	    }
	    ConexaoBancoDeDados.closeConexao();
		return retorno;
	}
	
	public ArrayList<Professor> listarTudo()  {
        String sql =  "SELECT * FROM professor";

        ArrayList<Professor> retorno = new ArrayList<Professor>();

        PreparedStatement pst =  ConexaoBancoDeDados.getPreparedStatement(sql);
        
        ResultSet res = null;
        
        try {
            res = pst.executeQuery();

            while(res.next())
            {
                Professor item = new Professor();
                item.setMatricula(res.getInt("matricula"));
                item.setCargaHoraria(res.getInt("cargaHoraria"));
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
	
	  public void remover(int matricula)  {

	        String sql = "delete from professor where matricula=?";

	        PreparedStatement pst = ConexaoBancoDeDados.getPreparedStatement(sql);

	        try {
	            pst.setInt(1,matricula);
	            pst.execute();
	            pst.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        ConexaoBancoDeDados.closeConexao();
	    }
	  
	  
	  public void editar(Professor professor)  {
	    	
	    	if (this.buscar(professor.getMatricula()) == null) {
	    		this.salvar(professor);
	    	}
	    	else {
	    		 String sql = "update professor set matricula =?, nome =?, cargaHoraria=? where matricula=?";
	    		 
	    		 PreparedStatement pst = ConexaoBancoDeDados.getPreparedStatement(sql);
	    	        try {
	    	            pst.setInt(1,professor.getMatricula());
	    	            pst.setString(2,professor.getNome());
	    	            pst.setInt(3,professor.getCargaHoraria());
	    	            pst.setInt(4,professor.getMatricula());
	    	            pst.execute();
	    	            pst.close();
	    	        } catch (SQLException e) {
	    	            e.printStackTrace();
	    	        }
	    	}
	    	 ConexaoBancoDeDados.closeConexao();
	    }
}
