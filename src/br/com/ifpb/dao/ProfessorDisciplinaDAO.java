package br.com.ifpb.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.ifpb.data.SingletonConexao;
import br.com.ifpb.model.Professor;

public class ProfessorDisciplinaDAO {

	public List<Professor> listarTudo(int id)  {
        String sql =  "SELECT * FROM professor_disciplina WHERE idDisciplina="+id+"'";

        List<Professor> retorno = new ArrayList<Professor>();

        PreparedStatement pst =  SingletonConexao.getPreparedStatement(sql);

        ResultSet res = null;

        try {
            res = pst.executeQuery();
            
            while(res.next())
            {
                Professor item = new Professor();
                item.setMatricula(res.getInt("matricula"));
                item.setNome(res.getString("nome"));
                item.setCargaHoraria(res.getInt("cargaHoraria"));
                retorno.add(item);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return retorno;

    }
	
	
	public void save( int idProfessor, int idDisciplina)  {
		
        String sql = "INSERT  INTO professor_disciplina (idProfessor, idDisciplina) VALUES(?,?) ";

        PreparedStatement pst = SingletonConexao.getPreparedStatement(sql);
    
        try {

            pst.setInt(1, idProfessor);
            pst.setInt(2, idDisciplina);
           
            pst.execute();
            pst.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
	

	
}
