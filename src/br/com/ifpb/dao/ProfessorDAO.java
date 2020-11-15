package br.com.ifpb.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.ifpb.data.SingletonConexao;
import br.com.ifpb.model.Professor;

public class ProfessorDAO {

	public	void salvar(Professor p)  {

        String sql = "INSERT  INTO professor (nome,matricula,cargaHoraria) VALUES(?,?,?) ";

        PreparedStatement pst = SingletonConexao.getPreparedStatement(sql);

        try {

            pst.setString(1,p.getNome());
            pst.setInt(2,p.getMatricula());
            pst.setInt(3,p.getCargaHoraria());
            pst.execute();
            pst.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
	
	
	public Professor buscar(int id) {
		
		String sql = "SELECT * FROM professor WHERE matricula=?";

	    Professor retorno = null;

	    PreparedStatement pst =  SingletonConexao.getPreparedStatement(sql);
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

	    } catch (SQLException ex) {
	        System.out.println(ex);

	    }
		return retorno;
	}
	
	public ArrayList<Professor> listarTudo()  {
        String sql =  "SELECT * FROM professor";

        ArrayList<Professor> retorno = new ArrayList<Professor>();

        PreparedStatement pst =  SingletonConexao.getPreparedStatement(sql);
        
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
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return retorno;

    }
	
	  public void remover(int matricula)  {

	        String sql = "delete from professor where matricula=?";

	        PreparedStatement pst = SingletonConexao.getPreparedStatement(sql);

	        try {
	            pst.setInt(1,matricula);
	            pst.execute();
	            pst.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }

	    }
}
