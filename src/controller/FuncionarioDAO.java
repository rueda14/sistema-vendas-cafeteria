package controller;

import java.sql.*;
import model.Funcionario;
import java.util.ArrayList;
import java.util.List;
import model.Funcionario;


public class FuncionarioDAO {

    
    private Connection con;
    private PreparedStatement cmd;

    public FuncionarioDAO() {
        con = Conexao.conectar(); // Certifique-se de que você tem a classe Conexao.java criada
    }

    public int inserir(Funcionario f) {
        try {
            String SQL = "INSERT INTO tb_funcionarios(nome, email, senha) VALUES (?, ?, MD5(?))";
            cmd = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            cmd.setString(1, f.getNome());
            cmd.setString(2, f.getEmail());
            cmd.setString(3, f.getSenha());

            if (cmd.executeUpdate() > 0) {
                ResultSet rs = cmd.getGeneratedKeys();
                return rs.next() ? rs.getInt(1) : -1;
            }
            return -1;
        } catch (Exception e) {
            System.err.println("ERRO: " + e.getMessage());
            return -1;
        }
    }

    public boolean atualizar(Funcionario f) {
    try {
        String SQL = "UPDATE tb_funcionarios SET nome = ?, email = ?, senha = MD5(?) WHERE id = ?";
        cmd = con.prepareStatement(SQL);
        cmd.setString(1, f.getNome());
        cmd.setString(2, f.getEmail());
        cmd.setString(3, f.getSenha());
        cmd.setInt(4, f.getId());

        return cmd.executeUpdate() > 0;
    } catch (Exception e) {
        System.err.println("ERRO ao atualizar funcionário: " + e.getMessage());
        return false;
    }
}

    public Funcionario buscarPorId(int id) {
        try {
            String SQL = "SELECT * FROM tb_funcionarios WHERE id = ?";
            cmd = con.prepareStatement(SQL);
            cmd.setInt(1, id);
            ResultSet rs = cmd.executeQuery();

            if (rs.next()) {
                Funcionario f = new Funcionario();
                f.setId(rs.getInt("id"));
                f.setNome(rs.getString("nome"));
                f.setEmail(rs.getString("email"));
                f.setSenha(rs.getString("senha")); // MD5, não exibir, mas é necessário
                return f;
            }
        } catch (Exception e) {
            System.err.println("ERRO ao buscar funcionário: " + e.getMessage());
        }
        return null;
}

    public List<Funcionario> listarFuncionarios() {
        List<Funcionario> lista = new ArrayList<>();
        try (Connection con = Conexao.getConexao()) {
            String sql = "SELECT * FROM tb_funcionarios";
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Funcionario f = new Funcionario();
                f.setId(rs.getInt("id"));
                f.setNome(rs.getString("nome"));
                f.setEmail(rs.getString("email"));
                // Adicione outros campos, se houver
                lista.add(f);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

     public List<Funcionario> listar() {
        try {
            String SQL = "select * from tb_funcionarios order by nome";
            cmd = con.prepareStatement(SQL);
            ResultSet rs = cmd.executeQuery();
            List<Funcionario> lista2 = new ArrayList<>();
            while (rs.next()) {
                Funcionario f = new Funcionario();
                f.setId(rs.getInt("id"));
                f.setNome(rs.getString("nome"));
                f.setEmail(rs.getString("email"));
                lista2.add(f);
            }
            return lista2;
        } catch (Exception e) {
            System.err.println("ERRO: " + e.getMessage());
            return null;
        }
    }

        
        //
    // Recuperar o Produtos a partir do ID
    //
    public List<Funcionario> pesquisarPorId(int id) {
        try {
            String SQL = "select * from tb_funcionarios where id=? order by id";
            cmd = con.prepareStatement(SQL);
            cmd.setInt(1, id);

            ResultSet rs = cmd.executeQuery();
            List<Funcionario> lista2 = new ArrayList<>();
            while (rs.next()) {
                Funcionario f = new Funcionario();
                f.setId(rs.getInt("id"));
                f.setNome(rs.getString("nome"));
                f.setEmail(rs.getString("email"));
                lista2.add(f);
            }
            return lista2;
        } catch (Exception e) {
            System.err.println("ERRO: " + e.getMessage());
            return null;
        }
    }

    //
    // Recuperar os Produtos a partir do NOME
    //
    public List<Funcionario> pesquisarPorNome(String nome) {
        try {
            String SQL = "select * from tb_funcionarios where nome ilike ? order by id";
            cmd = con.prepareStatement(SQL);
            cmd.setString(1, "%" + nome + "%");

            ResultSet rs = cmd.executeQuery();
            List<Funcionario> lista2 = new ArrayList<>();
            while (rs.next()) {
                Funcionario f = new Funcionario();
                f.setId(rs.getInt("id"));
                f.setNome(rs.getString("nome"));
                f.setEmail(rs.getString("email"));
                lista2.add(f);
            }
            return lista2;
        } catch (Exception e) {
            System.err.println("ERRO: " + e.getMessage());
            return null;
        }
    }
        
}
