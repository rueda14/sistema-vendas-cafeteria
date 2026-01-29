package controller;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.Produto;

public class ProdutoDAO {
    private Connection con;
    private PreparedStatement cmd;

    public ProdutoDAO() {
        con = Conexao.conectar();
    }

    public int inserir(Produto p) {
        try {
            String SQL = "INSERT INTO tb_produtos (nome, preco, descricao, id_categoria) VALUES (?, ?, ?, ?)";
            cmd = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            cmd.setString(1, p.getNome());
            cmd.setDouble(2, p.getPreco());
            cmd.setString(3, p.getDescricao());
            cmd.setInt(4, p.getIdCategoria());

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
    
    public Produto buscarPorId(int id) {
        try {
            String SQL = "SELECT * FROM tb_produtos WHERE id = ?";
            cmd = con.prepareStatement(SQL);
            cmd.setInt(1, id);
            ResultSet rs = cmd.executeQuery();

            if (rs.next()) {
                Produto p = new Produto();
                p.setId(rs.getInt("id"));
                p.setNome(rs.getString("nome"));
                p.setPreco(rs.getDouble("preco"));
                p.setDescricao(rs.getString("descricao"));
                p.setIdCategoria(rs.getInt("id_categoria"));
                return p;
            }
        } catch (Exception e) {
            System.err.println("ERRO buscarPorId: " + e.getMessage());
        }
        return null;
    }

    public boolean atualizar(Produto p) {
        try {
            String SQL = "UPDATE tb_produtos SET nome = ?, preco = ?, descricao = ?, id_categoria = ? WHERE id = ?";
            cmd = con.prepareStatement(SQL);
            cmd.setString(1, p.getNome());
            cmd.setDouble(2, p.getPreco());
            cmd.setString(3, p.getDescricao());
            cmd.setInt(4, p.getIdCategoria());
            cmd.setInt(5, p.getId());

            return cmd.executeUpdate() > 0;
        } catch (Exception e) {
            System.err.println("ERRO atualizar: " + e.getMessage());
            return false;
        }
    }

    
    public List<Produto> listarTodos() {
        List<Produto> lista1 = new ArrayList<>();
        try {
            String SQL = "SELECT * FROM tb_produtos ORDER BY id";
            cmd = con.prepareStatement(SQL);
            ResultSet rs = cmd.executeQuery();

            while (rs.next()) {
                Produto p = new Produto();
                p.setId(rs.getInt("id"));
                p.setNome(rs.getString("nome"));
                p.setPreco(rs.getDouble("preco"));
                p.setDescricao(rs.getString("descricao"));
                p.setIdCategoria(rs.getInt("id_categoria"));
                lista1.add(p);
            }
        } catch (Exception e) {
            System.err.println("ERRO listarTodos: " + e.getMessage());
        }
        return lista1;
    }
    
    /*public List<Produto> listar() {
        List<Produto> lista = new ArrayList<>();
        try (Connection con = Conexao.getConexao()) {
            String sql = "SELECT * FROM tb_produtos";
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Produto p = new Produto();
                p.setId(rs.getInt("id"));
                p.setNome(rs.getString("nome"));
                p.setPreco(rs.getDouble("preco"));
                lista.add(p);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }*/
    
        public List<Produto> listar() {
        try {
            String SQL = "select * from tb_produtos order by nome";
            cmd = con.prepareStatement(SQL);
            ResultSet rs = cmd.executeQuery();
            List<Produto> lista1 = new ArrayList<>();
            while (rs.next()) {
                Produto p = new Produto();
                p.setId(rs.getInt("id"));
                p.setNome(rs.getString("nome"));
                p.setPreco(rs.getDouble("preco"));
                p.setDescricao(rs.getString("descricao"));
                p.setIdCategoria(rs.getInt("id_categoria"));
                lista1.add(p);
            }
            return lista1;
        } catch (Exception e) {
            System.err.println("ERRO: " + e.getMessage());
            return null;
        }
    }

        
        //
    // Recuperar o Produtos a partir do ID
    //
    public List<Produto> pesquisarPorId(int id) {
        try {
            String SQL = "select * from tb_produtos where id=? order by id";
            cmd = con.prepareStatement(SQL);
            cmd.setInt(1, id);

            ResultSet rs = cmd.executeQuery();
            List<Produto> lista1 = new ArrayList<>();
            while (rs.next()) {
                Produto p = new Produto();
                p.setId(rs.getInt("id"));
                p.setNome(rs.getString("nome"));
                p.setPreco(rs.getDouble("preco"));
                p.setDescricao(rs.getString("descricao"));
                p.setIdCategoria(rs.getInt("id_categoria"));
                
                lista1.add(p);
            }
            return lista1;
        } catch (Exception e) {
            System.err.println("ERRO: " + e.getMessage());
            return null;
        }
    }

    //
    // Recuperar os Produtos a partir do NOME
    //
    public List<Produto> pesquisarPorNome(String nome) {
        try {
            String SQL = "select * from tb_produtos where nome ilike ? order by id";
            cmd = con.prepareStatement(SQL);
            cmd.setString(1, "%" + nome + "%");

            ResultSet rs = cmd.executeQuery();
            List<Produto> lista1 = new ArrayList<>();
            while (rs.next()) {
                Produto p = new Produto();
                p.setId(rs.getInt("id"));
                p.setNome(rs.getString("nome"));
                p.setPreco(rs.getDouble("preco"));
                p.setDescricao(rs.getString("descricao"));
                p.setIdCategoria(rs.getInt("id_categoria"));
                
                lista1.add(p);
            }
            return lista1;
        } catch (Exception e) {
            System.err.println("ERRO: " + e.getMessage());
            return null;
        }
    }
        
}
