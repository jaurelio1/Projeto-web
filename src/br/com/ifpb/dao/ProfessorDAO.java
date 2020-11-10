package br.com.ifpb.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.ifpb.data.SingletonConexao;
import br.com.ifpb.model.Professor;

public class ProfessorDAO {

	public	void save(Professor p)  {

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
	
	
	public Professor find(int id) {
		
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
}
