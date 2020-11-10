package br.com.ifpb.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.ifpb.data.SingletonConexao;
import br.com.ifpb.model.Disciplina;

public class DisciplinaDAO {
	public	void save(Disciplina d)  {
		
        String sql = "INSERT  INTO disciplina (nome,quantidadeAlunos,cargaHoraria,diaAula,inicioAula,fimAula,idProfessor) VALUES(?,?,?,?,?,?,?) ";

        PreparedStatement pst = SingletonConexao.getPreparedStatement(sql);

        try {

            pst.setString(1, d.getNome());
            pst.setInt(2,d.getQuantidadeAlunos());
            pst.setInt(3,d.getCargaHoraria());
            pst.setString(4, d.getDiaAula());
            pst.setInt(5,d.getInicioAula());
            pst.setInt(6,d.getFimAula());
            pst.setInt(6,d.getIDProfessor());
            pst.execute();
            pst.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
	
}
