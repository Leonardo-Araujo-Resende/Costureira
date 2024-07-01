
package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class ConexaoBd {
    private static final String URL = "jdbc:mysql://localhost:3306/costuras";
    private static final String USUARIO = "root";
    private static final String SENHA = "root";
    
    private static Connection conexao;
    
    public static Connection getConexao(){
        if(conexao == null){
            try {
                conexao = DriverManager.getConnection(URL, USUARIO, SENHA);
            } catch (SQLException ex) {
                System.out.println("Erro na conexao como banco");
            }
        }
        return conexao;
    }
}