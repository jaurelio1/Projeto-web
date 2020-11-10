package br.com.ifpb.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.ifpb.data.SingletonConexao;
import br.com.ifpb.model.Disciplina;

public class DisciplinaDAO {
	
	public	void save(Disciplina d)  {
		
        String sql = "INSERT  INTO disciplina (nome,codigo,quantidadeAlunos,cargaHoraria,diaAula,inicioAula,fimAula,idProfessor,idSala) VALUES(?,?,?,?,?,?,?,?,?) ";

        PreparedStatement pst = SingletonConexao.getPreparedStatement(sql);

        try {

            pst.setString(1, d.getNome());
            pst.setInt(2, d.getCodigo());
            pst.setInt(3,d.getQuantidadeAlunos());
            pst.setInt(4,d.getCargaHoraria());
            pst.setString(5, d.getDiaAula());
            pst.setInt(6,d.getInicioAula());
            pst.setInt(7,d.getFimAula());
            pst.setInt(8,d.getProfessor().getMatricula());
            pst.setInt(9,d.getSala().getId());
            pst.execute();
            pst.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
	
	public Disciplina find(int id) {
		
		String sql = "SELECT * FROM disciplina WHERE codigo=?";

	    Disciplina retorno = null;
	    
	    ProfessorDAO professorDAO = new ProfessorDAO();
	    SalaDAO salaDAO = new SalaDAO();

	    PreparedStatement pst =  SingletonConexao.getPreparedStatement(sql);
	    try {

	    	pst.setInt(1, id);
	        ResultSet res = pst.executeQuery();

	        if(res.next())
	        {
	            retorno = new Disciplina();
	            retorno.setNome(res.getString("nome"));
	            retorno.setCodigo(res.getInt("codigo"));
	            retorno.setQuantidadeAlunos(res.getInt("quantidadeAlunos"));
	            retorno.setCargaHoraria(res.getInt("cargaHoraria"));
	            retorno.setDiaAula(res.getString("diaAula"));
	            retorno.setInicioAula(res.getInt("inicioAula"));
	            retorno.setFimAula(res.getInt("fimAula"));
	            retorno.setProfessor(professorDAO.find(res.getInt("idProfessor")));
	            retorno.setSala(salaDAO.find(res.getInt("idSala")));
	            
	        }

	    } catch (SQLException ex) {
	        System.out.println(ex);

	    }
		return retorno;
	}
	
}
