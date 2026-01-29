package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import model.Admin;
import java.sql.SQLException;

public class AdminDAO {

    private Connection con;
    private PreparedStatement cmd;

    public AdminDAO() {
        con = Conexao.conectar(); // Usa sua classe utilitária de conexão
    }

    // Inserir novo admin
    public int inserir(Admin a) {
        try {
            String SQL = "insert into tb_admin(nome, email, senha) values (?, ?, MD5(?))";
            cmd = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            cmd.setString(1, a.getNome());
            cmd.setString(2, a.getEmail());
            cmd.setString(3, a.getSenha());

            if (cmd.executeUpdate() > 0) {
                ResultSet rs = cmd.getGeneratedKeys();
                return rs.next() ? rs.getInt(1) : -1;
            }
            return -1;
        } catch (Exception e) {
            System.err.println("ERRO ao inserir admin: " + e.getMessage());
            return -1;
        }
    }

    // (Opcional) Verificar se já existe um admin com o mesmo e-mail
    public boolean existeEmail(String email) {
        try {
            String SQL = "select id from tb_admin where email = ?";
            cmd = con.prepareStatement(SQL);
            cmd.setString(1, email);
            ResultSet rs = cmd.executeQuery();
            return rs.next(); // Retorna true se já existe
        } catch (Exception e) {
            System.err.println("ERRO ao verificar email: " + e.getMessage());
            return false;
        }
    }
    
    // Verifica se existe ao menos um admin cadastrado
    public boolean existeAlgumAdmin() {
        try {
            String SQL = "SELECT 1 FROM tb_admin LIMIT 1";
            cmd = con.prepareStatement(SQL);
            ResultSet rs = cmd.executeQuery();
            return rs.next(); // true se encontrar ao menos um
        } catch (Exception e) {
            System.err.println("ERRO ao verificar existência de admin: " + e.getMessage());
            return false;
        }
    }
    
   public boolean autenticarAdmin(String email, String senha) {
        String sql = "SELECT * FROM tb_admin WHERE email = ? AND senha = MD5(?)";

        try (Connection conn = Conexao.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, email);
            stmt.setString(2, senha);

            try (ResultSet rs = stmt.executeQuery()) {
                return rs.next(); // true se encontrou o admin
            }

        } catch (SQLException e) {
            System.err.println("Erro ao autenticar administrador: " + e.getMessage());
            return false;
        }
    }



}
