package br.com.alocarsalas.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SingletonConexao {

    private static final String banco = "jdbc:mysql://us-cdbr-east-02.cleardb.com:3306/heroku_fa606a17340eaa3";
    private static final String driver = "com.mysql.cj.jdbc.Driver";
    private static final String usuario = "b4b6da8dfa15bf";
    private static final String senha = "5392d1e5";

    private static Connection con = null;


    public static Connection getConexao() {
        // primeiro testo se o objeto con não foi inicializado
        if (con == null) {
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
        }
        return con;
    }


    public static PreparedStatement getPreparedStatement(String sql) {
        // testo se a conexão já foi criada
        if (con == null) {
            // cria a conexão
            con = getConexao();
        }
        try {
            // retorna um objeto java.sql.PreparedStatement
            return con.prepareStatement(sql);
        } catch (SQLException e) {
            System.out.println("Erro de sql: " +
                    e.getMessage());
        }
        return null;
    }

}
