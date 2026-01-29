package controller;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexao {
     //PARÂMETROS
    private static final String USUARIO = "postgres";
    private static final String SENHA = "familia";
    private static final String URL = "jdbc:postgresql://127.0.0.1:5432/CAFETERIA";
    private static final String DRIVER = "org.postgresql.Driver";
    
    //Estabelecer a conexão entre a APP e o SGBD
    public static Connection conectar(){
        try {
            Class.forName(DRIVER);
            return DriverManager.getConnection(URL,USUARIO,SENHA);
        } catch (Exception e) {
            System.err.println("ERRO: " + e.getMessage());
            return null;
        }
    }
    
    //
    // TESTAR a CONEXÃO
    //
    public static void main(String[] args) {
        
        //Tentativa de conexão com o SGBD
        Connection con = Conexao.conectar();
        if (con != null){
            System.out.println("Conexão realizada com sucesso!");
        }
        
    }

    public static Connection getConexao() {
        try {
            String url = "jdbc:postgresql://127.0.0.1:5432/CAFETERIA";
            String user = "postgres";
            String password = "familia";
            Class.forName("org.postgresql.Driver");
            return DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            System.err.println("Erro de conexão: " + e.getMessage());
            return null;
        }
    }
    
}
