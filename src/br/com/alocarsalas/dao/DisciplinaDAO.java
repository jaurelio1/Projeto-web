package br.com.alocarsalas.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.alocarsalas.data.ConexaoBancoDeDados;
import br.com.alocarsalas.model.Disciplina;

public class DisciplinaDAO {
	
	public	void salvar(Disciplina d)  {
		
        String sql = "INSERT  INTO disciplina (nome,codigo,quantidadeAlunos,cargaHoraria,diaAula,inicioAula,fimAula,idSala) VALUES(?,?,?,?,?,?,?,?) ";

        PreparedStatement pst = ConexaoBancoDeDados.getPreparedStatement(sql);
        
        try {

            pst.setString(1, d.getNome());
            pst.setInt(2, d.getCodigo());
            pst.setInt(3,d.getQuantidadeAlunos());
            pst.setInt(4,d.getCargaHoraria());
            pst.setString(5, d.getDiaAula());
            pst.setString(6,d.getInicioAula());
            pst.setString(7,d.getFimAula());
            pst.setInt(8,d.getSala().getCodigo());
            pst.execute();
            pst.close();
    
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        ConexaoBancoDeDados.closeConexao(pst);
    }
	
	
	
	public Disciplina buscar(int id) {
		
		String sql = "SELECT * FROM disciplina WHERE codigo=?";

	    Disciplina retorno = null;
	    SalaDAO salaDAO = new SalaDAO();

	    PreparedStatement pst =  ConexaoBancoDeDados.getPreparedStatement(sql);
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
	            retorno.setInicioAula(res.getString("inicioAula"));
	            retorno.setFimAula(res.getString("fimAula"));
	            retorno.setSala(salaDAO.buscar(res.getInt("idSala")));
	            
	        }
	        
	        pst.close();
	        res.close();

	    } catch (SQLException ex) {
	        System.out.println(ex);

	    }
	    
	    ConexaoBancoDeDados.closeConexao();
		return retorno;
	}
	
	
	 public ArrayList<Disciplina> listarTudo()  {
	        String sql =  "SELECT * FROM disciplina";

	        ArrayList<Disciplina> retorno = new ArrayList<Disciplina>();

	        PreparedStatement pst =  ConexaoBancoDeDados.getPreparedStatement(sql);
	        
	        SalaDAO salaDAO = new SalaDAO();

	        ResultSet res = null;
	        
	        try {
	            res = pst.executeQuery();

	            while(res.next())
	            {
	                Disciplina item = new Disciplina();
	                item.setNome(res.getString("nome"));
	                item.setCodigo(res.getInt("codigo"));
	                item.setQuantidadeAlunos(res.getInt("quantidadeAlunos"));
	                item.setCargaHoraria(res.getInt("cargaHoraria"));
	                item.setDiaAula(res.getString("diaAula"));
	                item.setInicioAula(res.getString("inicioAula"));
	                item.setFimAula(res.getString("fimAula"));
	                item.setSala(salaDAO.buscar(res.getInt("idSala")));

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
	 
	 
	 public ArrayList<Disciplina> buscarPorSala(int id)  {
	        String sql =  "SELECT * FROM disciplina WHERE idSala=?";

	        ArrayList<Disciplina> retorno = new ArrayList<Disciplina>();

	        PreparedStatement pst =  ConexaoBancoDeDados.getPreparedStatement(sql);
	        
	        SalaDAO salaDAO = new SalaDAO();

	        ResultSet res = null;
	        
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
	                item.setInicioAula(res.getString("inicioAula"));
	                item.setFimAula(res.getString("fimAula"));
	                item.setSala(salaDAO.buscar(res.getInt("idSala")));

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
	 
	  public void remover(int codigo)  {

	        String sql = "delete from disciplina where codigo=?";

	        PreparedStatement pst = ConexaoBancoDeDados.getPreparedStatement(sql);

	        try {
	            pst.setInt(1, codigo);
	            pst.execute();
	            pst.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        ConexaoBancoDeDados.closeConexao();
	    }
	  
	  public void editar(Disciplina disciplina)  {
	    	
	    	if (this.buscar(disciplina.getCodigo()) == null) {
	    		this.salvar(disciplina);
	    	}
	    	else {
	    		 String sql = "update disciplina set nome =?, codigo =?,quantidadeAlunos=?, cargaHoraria=?, diaAula=?, inicioAula=?, fimAula=?  where codigo=?";
	    		 
	    		 PreparedStatement pst = ConexaoBancoDeDados.getPreparedStatement(sql);
	    	        try {
	    	            pst.setString(1,disciplina.getNome());
	    	            pst.setInt(2,disciplina.getCodigo());
	    	            pst.setInt(3,disciplina.getQuantidadeAlunos());
	    	            pst.setInt(4,disciplina.getCargaHoraria());
	    	            pst.setString(5,disciplina.getDiaAula());
	    	            pst.setString(6,disciplina.getInicioAula());
	    	            pst.setString(7,disciplina.getFimAula());
	    	            pst.setInt(8,disciplina.getCodigo());
	    	            pst.execute();
	    	            pst.close();
	    	        } catch (SQLException e) {
	    	            e.printStackTrace();
	    	        }
	    	}
	    	 ConexaoBancoDeDados.closeConexao();
	    }
	
	
}
