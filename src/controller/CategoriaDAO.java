package controller;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.Categoria;

public class CategoriaDAO {
    private Connection con;
    private PreparedStatement cmd;

    public CategoriaDAO() {
        con = Conexao.conectar();
    }

    public List<Categoria> listarTodas() {
        List<Categoria> lista = new ArrayList<>();
        try {
            String SQL = "SELECT * FROM tb_categorias ORDER BY nome";
            cmd = con.prepareStatement(SQL);
            ResultSet rs = cmd.executeQuery();
            while (rs.next()) {
                Categoria cat = new Categoria();
                cat.setId(rs.getInt("id"));
                cat.setNome(rs.getString("nome"));
                lista.add(cat);
            }
        } catch (Exception e) {
            System.err.println("Erro ao listar categorias: " + e.getMessage());
        }
        return lista;
    }
}
