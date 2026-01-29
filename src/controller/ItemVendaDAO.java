package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.ItemVenda;
import model.Produto;

public class ItemVendaDAO {
    private Connection conn;
    private PreparedStatement cmd;

    public ItemVendaDAO(Connection conn) {
        this.conn = conn;
    }

    public void inserirItemVenda(ItemVenda item, int vendaId) throws SQLException {
        String sql = "INSERT INTO tb_itens_vendas (id_venda, id_produto, quantidade, subtotal) VALUES (?, ?, ?, ?)";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, vendaId);
        stmt.setInt(2, item.getProduto().getId());
        stmt.setInt(3, item.getQuantidade());
        stmt.setDouble(4, item.getSubtotal());
        stmt.executeUpdate();
        stmt.close();
    }
    
        public List<ItemVenda> listarItensPorVenda(int idVenda) {
            List<ItemVenda> lista = new ArrayList<>();
            String sql = """
                SELECT iv.id, iv.id_produto, iv.quantidade, iv.preco_unitario, p.nome, p.preco
                FROM tb_itens_vendas iv 
                JOIN tb_produtos p ON iv.id_produto = p.id 
                WHERE iv.id_venda = ?
            """;

            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setInt(1, idVenda);
                ResultSet rs = stmt.executeQuery();

                while (rs.next()) {
                    Produto p = new Produto();
                    p.setId(rs.getInt("id_produto"));
                    p.setNome(rs.getString("nome"));
                    p.setPreco(rs.getDouble("preco"));

                    ItemVenda item = new ItemVenda();
                    item.setId(rs.getInt("id"));
                    item.setProduto(p);
                    item.setQuantidade(rs.getInt("quantidade"));
                    item.setPreco_unitario(rs.getDouble("preco_unitario"));

                    lista.add(item);
                }
            } catch (SQLException e) {
                System.err.println("ERRO ao listar itens da venda: " + e.getMessage());
            }

            return lista;
        }

    public boolean inserir(ItemVenda item, int idVenda) {
        String SQL = "INSERT INTO tb_itens_vendas (id_venda, id_produto, quantidade, preco_unitario, subtotal) " +
                     "VALUES (?, ?, ?, ?, ?)";
        PreparedStatement cmd = null;
        try {
            cmd = conn.prepareStatement(SQL);
            cmd.setInt(1, idVenda);
            cmd.setInt(2, item.getProduto().getId());
            cmd.setInt(3, item.getQuantidade());
            cmd.setDouble(4, item.getPreco_unitario());
            cmd.setDouble(5, item.getSubtotal());
            cmd.executeUpdate();
            return true;
        } catch (Exception e) {
            System.err.println("Erro ao inserir item de venda: " + e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                if (cmd != null) cmd.close();
            } catch (SQLException e) {
                System.err.println("Erro ao fechar PreparedStatement: " + e.getMessage());
                e.printStackTrace();
            }
        }
        return false;
    }

    public boolean removerPorId(int id) {
    String sql = "DELETE FROM tb_itens_vendas WHERE id = ?";
    try (Connection conn = Conexao.conectar();
         PreparedStatement stmt = conn.prepareStatement(sql)) {

        stmt.setInt(1, id);
        int linhasAfetadas = stmt.executeUpdate();

        return linhasAfetadas > 0;
    } catch (SQLException e) {
        System.out.println("Erro ao remover item: " + e.getMessage());
        return false;
    }
}
    
    /*public boolean remover(int id) {
    String sql = "DELETE FROM tb_itens_vendas WHERE id = ?";
    try (Connection conn = Conexao.getConexao();
         PreparedStatement stmt = conn.prepareStatement(sql)) {
        stmt.setInt(1, id);
        int afetados = stmt.executeUpdate();
        return afetados > 0;
    } catch (Exception e) {
        System.err.println("Erro ao remover item: " + e.getMessage());
        return false;
    }
}*/

    public boolean remover(int idItemVenda) {
    try {
        // 1. Obter o idVenda do item a ser removido
        String sqlGetVenda = "SELECT id_venda FROM tb_itens_vendas WHERE id = ?";
        PreparedStatement psGetVenda = conn.prepareStatement(sqlGetVenda);
        psGetVenda.setInt(1, idItemVenda);
        ResultSet rs = psGetVenda.executeQuery();
        
        if (!rs.next()) {
            // Item não encontrado
            return false;
        }
        
        int idVenda = rs.getInt("id_venda");

        // 2. Remover o item
        String sqlRemoveItem = "DELETE FROM tb_itens_vendas WHERE id = ?";
        PreparedStatement psRemoveItem = conn.prepareStatement(sqlRemoveItem);
        psRemoveItem.setInt(1, idItemVenda);
        int linhas = psRemoveItem.executeUpdate();

        if (linhas > 0) {
            // 3. Verificar se ainda existem itens para a venda
            String sqlCountItens = "SELECT COUNT(*) FROM tb_itens_vendas WHERE id_venda = ?";
            PreparedStatement psCount = conn.prepareStatement(sqlCountItens);
            psCount.setInt(1, idVenda);
            ResultSet rsCount = psCount.executeQuery();
            if (rsCount.next()) {
                int totalItens = rsCount.getInt(1);

                // 4. Se não houver mais itens, remover a venda
                if (totalItens == 0) {
                    String sqlRemoveVenda = "DELETE FROM tb_vendas WHERE id = ?";
                    PreparedStatement psRemoveVenda = conn.prepareStatement(sqlRemoveVenda);
                    psRemoveVenda.setInt(1, idVenda);
                    psRemoveVenda.executeUpdate();
                }
            }
            return true;
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return false;
}

    /*public ItemVenda buscarPorId(int id) throws SQLException {
    String sql = "SELECT iv.id, iv.venda_id, iv.produto_id, iv.quantidade, f.nome AS nome_funcionario "
               + "FROM tb_itens_vendas iv "
               + "JOIN tb_vendas v ON iv.venda_id = v.id "
               + "JOIN tb_funcionarios f ON v.funcionario_id = f.id "
               + "WHERE iv.id = ?";
    try (PreparedStatement stmt = conn.prepareStatement(sql)) {
        stmt.setInt(1, id);
        try (ResultSet rs = stmt.executeQuery()) {
            if (rs.next()) {
                ItemVenda item = new ItemVenda();
                item.setId(rs.getInt("id"));
                item.setVendaId(rs.getInt("venda_id"));
                item.setProdutoId(rs.getInt("produto_id"));
                item.setQuantidade(rs.getInt("quantidade"));
                item.setNomeFuncionario(rs.getString("nome_funcionario"));
                return item;
            }
            return null;
        }
    }
}*/

    public ItemVenda buscarPorId(int id) {
    String sql = "SELECT i.id, i.id_venda, i.id_produto, i.quantidade, i.subtotal, i.preco_unitario, f.nome AS nome_funcionario " +
                 "FROM tb_itens_vendas i " +
                 "JOIN tb_vendas v ON i.id_venda = v.id " +
                 "JOIN tb_funcionarios f ON v.id_funcionario = f.id " +
                 "WHERE i.id = ?";

    try (PreparedStatement stmt = conn.prepareStatement(sql)) {
        stmt.setInt(1, id);
        try (ResultSet rs = stmt.executeQuery()) {
            if (rs.next()) {
                ItemVenda item = new ItemVenda();
                item.setId(rs.getInt("id"));
                item.setVendaId(rs.getInt("id_venda"));
                item.setProdutoId(rs.getInt("id_produto"));
                item.setQuantidade(rs.getInt("quantidade"));
                item.setSubtotal(rs.getDouble("subtotal"));
                item.setPreco_unitario(rs.getDouble("preco_unitario"));
                item.setNomeFuncionario(rs.getString("nome_funcionario"));
                return item;
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return null;
}

    public List<ItemVenda> buscarPorVendaId(int vendaId) {
    List<ItemVenda> itens = new ArrayList<>();
    String sql = "SELECT i.*, p.nome as nome_produto FROM tb_itens_vendas i "
               + "INNER JOIN tb_produtos p ON i.id_produto = p.id "
               + "WHERE i.id_venda = ?";

    try (PreparedStatement stmt = conn.prepareStatement(sql)) {
        stmt.setInt(1, vendaId);
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            Produto produto = new Produto();
            produto.setId(rs.getInt("id_produto"));
            produto.setNome(rs.getString("nome_produto"));
            produto.setPreco(rs.getDouble("preco_unitario"));

            ItemVenda item = new ItemVenda();
            item.setId(rs.getInt("id"));
            item.setProduto(produto);
            item.setQuantidade(rs.getInt("quantidade"));
            item.setPreco_unitario(rs.getDouble("preco_unitario"));
            //item.setSubtotal(produto.getPreco() * item.getQuantidade());
            item.setSubtotal(rs.getDouble("subtotal"));

            itens.add(item);
        }

    } catch (SQLException e) {
        e.printStackTrace();
    }

    return itens;
}

    
}
