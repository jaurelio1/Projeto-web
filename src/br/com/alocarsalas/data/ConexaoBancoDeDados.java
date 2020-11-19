package br.com.alocarsalas.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConexaoBancoDeDados {

    private static final String banco = "jdbc:mysql://us-cdbr-east-02.cleardb.com:3306/heroku_fa606a17340eaa3";
    private static final String driver = "com.mysql.cj.jdbc.Driver";
    private static final String usuario = "b4b6da8dfa15bf";
    private static final String senha = "5392d1e5";

    private static Connection con = null;


    public static Connection getConexao() {
 
        try {
            // defino a classe do driver a ser usado
            Class.forName(driver);
            // criação da conexão com o BD
            con = DriverManager.getConnection(
                            banco, usuario, senha);
        } catch (ClassNotFoundException ex) {
            System.out.println("Não encontrou o driver");
        } catch (SQLException ex) {
            System.out.println("Erro ao conectar: " +
                    ex.getMessage());
        }
        
        return con;
    }


    public static PreparedStatement getPreparedStatement(String sql) {
     
            // cria a conexão
        con = getConexao();
      
        try {
            // retorna um objeto java.sql.PreparedStatement
            return con.prepareStatement(sql);
        } catch (SQLException e) {
            System.out.println("Erro de sql: " +
                    e.getMessage());
        }
        return null;
    }
    
    
    public static void closeConexao() {
        try{
           if(con!=null){
            con.close();
            } 
        }catch (SQLException e){
        	System.out.println("Erro ao encerrar conexão sql: " +  e.getMessage());
        }
        
    }
     public static void closeConexao(PreparedStatement stmt) {

    	 closeConexao();

        try {

            if (stmt != null) {
                stmt.close();
            }

        } catch (SQLException e) {
        	System.out.println("Erro ao encerrar conexão sql: " +  e.getMessage());
        }
    }

    public static void closeConexao(PreparedStatement stmt, ResultSet rs) {

    	closeConexao(stmt);

        try {

            if (rs != null) {
                rs.close();
            }

        } catch (SQLException e) {
        	System.out.println("Erro ao encerrar conexão sql: " +  e.getMessage());
        }
    }

}
