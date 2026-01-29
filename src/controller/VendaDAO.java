package controller;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.Funcionario;
import model.ItemVenda;
import model.Produto;
import model.Venda;


public class VendaDAO {
    private Connection conn;
    private PreparedStatement cmd;

    public VendaDAO(Connection conn) {
        this.conn = conn;
    }

    public VendaDAO() {
        this.conn = Conexao.getConexao();
    }

    public int inserirVenda(Venda venda) throws SQLException {
        String sql = "INSERT INTO tb_vendas (id_funcionario, data_venda, total) VALUES (?, ?, ?) RETURNING id";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, venda.getFuncionario().getId());
        stmt.setDate(2, new java.sql.Date(venda.getData().getTime()));
        stmt.setDouble(3, venda.getTotal());

        ResultSet rs = stmt.executeQuery();
        int idVenda = 0;
        if (rs.next()) {
            idVenda = rs.getInt("id");
        }

        ItemVendaDAO itemDAO = new ItemVendaDAO(conn);
        for (ItemVenda item : venda.getItens()) {
            itemDAO.inserirItemVenda(item, idVenda);
        }

        return idVenda;
    }

    public boolean atualizar(Venda v) {
        try {
            String SQL = "UPDATE tb_vendas SET id_funcionario=?, data_venda=?, total=? WHERE id=?";
            cmd = conn.prepareStatement(SQL);
            cmd.setInt(1, v.getFuncionario().getId());
            cmd.setDate(2, new java.sql.Date(v.getData().getTime()));
            cmd.setDouble(3, v.getTotal());
            cmd.setInt(4, v.getId());

            return cmd.executeUpdate() > 0;
        } catch (Exception e) {
            System.err.println("ERRO ao atualizar venda: " + e.getMessage());
            return false;
        }
    }

    public Venda buscarPorId(int id) {
        try {
            String SQL = "SELECT * FROM tb_vendas WHERE id = ?";
            cmd = conn.prepareStatement(SQL);
            cmd.setInt(1, id);
            ResultSet rs = cmd.executeQuery();

            if (rs.next()) {
                Venda v = new Venda();
                v.setId(rs.getInt("id"));
                v.setData(rs.getDate("data_venda"));
                v.setTotal(rs.getDouble("valor_total"));

                FuncionarioDAO fDAO = new FuncionarioDAO();
                v.setFuncionario(fDAO.buscarPorId(rs.getInt("id_funcionario")));

                ItemVendaDAO iDAO = new ItemVendaDAO(conn);
                v.setItens(iDAO.listarItensPorVenda(id));

                return v;
            }
        } catch (Exception e) {
            System.err.println("ERRO ao buscar venda: " + e.getMessage());
        }
        return null;
    }

    public List<Venda> listarVendas() {
        List<Venda> lista = new ArrayList<>();
        try {
            String SQL = "SELECT * FROM tb_vendas ORDER BY id DESC";
            cmd = conn.prepareStatement(SQL);
            ResultSet rs = cmd.executeQuery();

            while (rs.next()) {
                Venda v = new Venda();
                v.setId(rs.getInt("id"));
                v.setData(rs.getDate("data_venda"));
                v.setTotal(rs.getDouble("valor_total"));

                FuncionarioDAO fDAO = new FuncionarioDAO();
                v.setFuncionario(fDAO.buscarPorId(rs.getInt("id_funcionario")));

                ItemVendaDAO iDAO = new ItemVendaDAO(conn);
                v.setItens(iDAO.listarItensPorVenda(v.getId()));

                lista.add(v);
            }
        } catch (Exception e) {
            System.err.println("ERRO ao listar vendas: " + e.getMessage());
        }
        return lista;
    }

    public List<Venda> listar() {
    List<Venda> lista = new ArrayList<>();
    String sql = "SELECT v.*, f.nome as nome_funcionario FROM tb_vendas v INNER JOIN tb_funcionarios f ON v.id_funcionario = f.id";

    try (PreparedStatement stmt = conn.prepareStatement(sql);
         ResultSet rs = stmt.executeQuery()) {

        while (rs.next()) {
            Venda venda = new Venda();
            venda.setId(rs.getInt("id"));
            venda.setData(rs.getDate("data_venda"));
            venda.setTotal(rs.getDouble("valor_total"));

            Funcionario funcionario = new Funcionario();
            funcionario.setId(rs.getInt("id_funcionario"));
            funcionario.setNome(rs.getString("nome_funcionario"));
            venda.setFuncionario(funcionario);

            // ⚠ Aqui você carrega os itens da venda
            ItemVendaDAO itemDao = new ItemVendaDAO(conn);
            List<ItemVenda> itens = itemDao.buscarPorVendaId(venda.getId());
            venda.setItens(itens);

            lista.add(venda);
        }

    } catch (SQLException e) {
        e.printStackTrace();
    }

    return lista;
}


    public List<Venda> pesquisarPorId(int id) {
        List<Venda> lista = new ArrayList<>();
        try {
            String SQL = "SELECT * FROM tb_vendas WHERE id = ?";
            cmd = conn.prepareStatement(SQL);
            cmd.setInt(1, id);
            ResultSet rs = cmd.executeQuery();

            while (rs.next()) {
                Venda v = new Venda();
                v.setId(rs.getInt("id"));
                v.setData(rs.getDate("data_venda"));
                v.setTotal(rs.getDouble("valor_total"));

                FuncionarioDAO fDAO = new FuncionarioDAO();
                v.setFuncionario(fDAO.buscarPorId(rs.getInt("id_funcionario")));

                ItemVendaDAO iDAO = new ItemVendaDAO(conn);
                v.setItens(iDAO.listarItensPorVenda(v.getId()));

                lista.add(v);
            }
        } catch (Exception e) {
            System.err.println("ERRO ao pesquisar venda por ID: " + e.getMessage());
        }
        return lista;
    }

    public List<Venda> pesquisarPorFuncionarios(String nomeFuncionario) {
        List<Venda> lista = new ArrayList<>();
        try {
            String SQL = """
                SELECT v.*
                FROM tb_vendas v
                JOIN tb_funcionarios f ON v.id_funcionario = f.id
                WHERE f.nome ILIKE ?
                ORDER BY v.id DESC
            """;
            cmd = conn.prepareStatement(SQL);
            cmd.setString(1, "%" + nomeFuncionario + "%");
            ResultSet rs = cmd.executeQuery();

            while (rs.next()) {
                Venda v = new Venda();
                v.setId(rs.getInt("id"));
                v.setData(rs.getDate("data_venda"));
                v.setTotal(rs.getDouble("valor_total"));

                FuncionarioDAO fDAO = new FuncionarioDAO();
                v.setFuncionario(fDAO.buscarPorId(rs.getInt("id_funcionario")));

                ItemVendaDAO iDAO = new ItemVendaDAO(conn);
                v.setItens(iDAO.listarItensPorVenda(v.getId()));

                lista.add(v);
            }
        } catch (Exception e) {
            System.err.println("ERRO ao pesquisar venda por funcionário: " + e.getMessage());
        }
        return lista;
    }

    /*public boolean inserir(Venda venda) {
    String SQL = "INSERT INTO tb_vendas (id_funcionario, valor_total) VALUES (?, ?) RETURNING id";
    try {
        cmd = conn.prepareStatement(SQL);
        cmd.setInt(1, venda.getFuncionario().getId());
        cmd.setDouble(2, venda.getTotal());

        ResultSet rs = cmd.executeQuery();
        if (rs.next()) {
            int idVenda = rs.getInt("id");

            // Salvar itens da venda
            ItemVendaDAO itemDAO = new ItemVendaDAO(conn);
            for (ItemVenda item : venda.getItens()) {
                itemDAO.inserir(item, idVenda);
            }

            return true;
        }
    } catch (Exception e) {
        System.err.println("Erro ao inserir venda: " + e.getMessage());
    }
    return false;
}*/
    
public boolean inserir(Venda venda) {
    String SQL = "INSERT INTO tb_vendas (id_funcionario, valor_total) VALUES (?, ?) RETURNING id";
    ResultSet rs = null;
    PreparedStatement stmt = null;

    try {
        System.out.println("Iniciando inserção da venda...");
        System.out.println("Funcionário ID: " + venda.getFuncionario().getId());
        System.out.println("Valor total da venda: " + venda.getTotal());

        conn.setAutoCommit(false);  // Início da transação

        stmt = conn.prepareStatement(SQL);
        stmt.setInt(1, venda.getFuncionario().getId());
        stmt.setDouble(2, venda.getTotal());

        rs = stmt.executeQuery();

        if (rs.next()) {
            int idVenda = rs.getInt("id");
            System.out.println("Venda inserida com ID: " + idVenda);

            // Inserir os itens da venda usando a mesma conexão (transação)
            ItemVendaDAO itemDAO = new ItemVendaDAO(conn);
            for (ItemVenda item : venda.getItens()) {
                System.out.println("Inserindo item: Produto ID = " + item.getProduto().getId() +
                                   ", Quantidade = " + item.getQuantidade() +
                                   ", Preço Unitário = " + item.getPreco_unitario() +
                                   ", Subtotal = " + item.getSubtotal());
                boolean inseriuItem = itemDAO.inserir(item, idVenda);
                if (!inseriuItem) {
                    System.err.println("Falha ao inserir item da venda. Realizando rollback.");
                    conn.rollback();
                    return false;
                }
            }

            conn.commit();  // Confirma a transação
            System.out.println("Venda e itens inseridos com sucesso. Commit realizado.");
            return true;
        } else {
            System.err.println("Não foi possível obter o ID da venda inserida. Rollback.");
            conn.rollback();
        }
    } catch (Exception e) {
        System.err.println("Erro ao inserir venda:");
        e.printStackTrace();
        try {
            conn.rollback();  // Desfaz a transação
        } catch (SQLException rollbackEx) {
            System.err.println("Erro ao realizar rollback:");
            rollbackEx.printStackTrace();
        }
    } finally {
        try {
            if (rs != null) rs.close();
            if (stmt != null) stmt.close();
            conn.setAutoCommit(true);  // Retorna ao modo padrão
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    return false;
}

   
}
