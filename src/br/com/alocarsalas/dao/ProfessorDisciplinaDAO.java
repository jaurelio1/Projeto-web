package br.com.alocarsalas.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.alocarsalas.data.SingletonConexao;
import br.com.alocarsalas.model.Disciplina;
import br.com.alocarsalas.model.Professor;
import br.com.alocarsalas.model.ProfessorDisciplina;

public class ProfessorDisciplinaDAO {

	public List<Professor> listarProfessorPorDisciplina(int id)  {
        String sql =  "SELECT * FROM professor_disciplina WHERE idDisciplina=?";

        List<Professor> retorno = new ArrayList<Professor>();

        ProfessorDAO pDAO = new ProfessorDAO();
        
        PreparedStatement pst =  SingletonConexao.getPreparedStatement(sql);

        ResultSet res = null;

        try {
        	pst.setInt(1, id);
            res = pst.executeQuery();
            
            while(res.next())
            {
                Professor item = pDAO.buscar(res.getInt("idProfessor"));
                retorno.add(item);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return retorno;

    }
	
	public List<Disciplina> listarDisciplinaPorProfessor(int id)  {
        String sql =  "SELECT * FROM professor_disciplina WHERE idProfessor=?";

        List<Disciplina> retorno = new ArrayList<Disciplina>();

        PreparedStatement pst =  SingletonConexao.getPreparedStatement(sql);
        
        DisciplinaDAO dDAO = new DisciplinaDAO();

        ResultSet res = null;

        try {
        	pst.setInt(1, id);
            res = pst.executeQuery();
            
            while(res.next())
            {
            	Disciplina item = dDAO.buscar(res.getInt("idDisciplina"));

                retorno.add(item);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return retorno;

    }
	
	
	public void salvar( ProfessorDisciplina pd)  {
		
        String sql = "INSERT  INTO professor_disciplina (idProfessor, idDisciplina) VALUES(?,?) ";

        PreparedStatement pst = SingletonConexao.getPreparedStatement(sql);
    
        try {

            pst.setInt(1, pd.getIdProfessor());
            pst.setInt(2, pd.getIdDisciplina());
           
            pst.execute();
            pst.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
	
	  public void remover(int idProfessor, int idDisciplina)  {

	        String sql = "delete from professor_disciplina where idProfessor=? and idDisciplina=?";

	        PreparedStatement pst = SingletonConexao.getPreparedStatement(sql);

	        try {
	            pst.setInt(1,idProfessor);
	            pst.setInt(2,idDisciplina);
	            pst.execute();
	            pst.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }

	    }
	
}
