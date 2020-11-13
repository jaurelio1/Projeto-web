package br.com.ifpb.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.ifpb.data.SingletonConexao;
import br.com.ifpb.model.Disciplina;
import br.com.ifpb.model.Professor;

public class ProfessorDisciplinaDAO {

	public List<Professor> listarProfessorPorDisciplina(int id)  {
        String sql =  "SELECT * FROM professor_disciplina WHERE idDisciplina=?";

        List<Professor> retorno = new ArrayList<Professor>();

        PreparedStatement pst =  SingletonConexao.getPreparedStatement(sql);

        ResultSet res = null;

        try {
        	pst.setInt(1, id);
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
	
	public List<Disciplina> listarDisciplinaPorProfessor(int id)  {
        String sql =  "SELECT * FROM professor_disciplina WHERE idProfessor=?";

        List<Disciplina> retorno = new ArrayList<Disciplina>();

        PreparedStatement pst =  SingletonConexao.getPreparedStatement(sql);

        ResultSet res = null;
        
        SalaDAO salaDAO = new SalaDAO();

        try {
        	pst.setInt(1, id);
            res = pst.executeQuery();
            
            while(res.next())
            {
            	Disciplina item = new Disciplina();
                item.setNome(res.getString("nome"));
                item.setCodigo(res.getInt("codigo"));
                item.setQuantidadeAlunos(res.getInt("quantidadeAlunos"));
                item.setCargaHoraria(res.getInt("cargaHoraria"));
                item.setDiaAula(res.getString("diaAula"));
                item.setInicioAula(res.getInt("inicioAula"));
                item.setFimAula(res.getInt("fimAula"));
                item.setProfessores(this.listarProfessorPorDisciplina(res.getInt("codigo")));
                item.setSala(salaDAO.buscar(res.getInt("idSala")));

                retorno.add(item);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return retorno;

    }
	
	
	public void salvar( int idProfessor, int idDisciplina)  {
		
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
