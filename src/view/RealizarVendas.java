package view;

import controller.FuncionarioDAO;
import controller.ProdutoDAO;
import controller.VendaDAO;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Funcionario;
import model.ItemVenda;
import model.Produto;
import model.Venda;


public class RealizarVendas extends javax.swing.JFrame {

    private DefaultTableModel tableModel;
    private List<Produto> listaProdutos = new ArrayList<>();
    private javax.swing.JLabel lblTotal;
    private List<ItemVenda> itensVendas = new ArrayList<>();
    private List<Funcionario> listaFuncionarios = new ArrayList<>();

    
    public RealizarVendas() {
        initComponents();
            
        this.setTitle("Realizar Vendas");
        this.setSize(630, 510);//set tamanho da janela
        this.setResizable(false); //impede de maximizar
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        carregarProdutos();
        carregarFuncionarios();
        carregarQuantidades();
        
        String[] colunas = {"Produto", "Quantidade", "Funcionário", "Preço Unitário", "Subtotal"};
        tableModel = new DefaultTableModel(colunas, 0);
        jTable1.setModel(tableModel);
        
        lblTotal = new javax.swing.JLabel();
        lblTotal.setFont(new java.awt.Font("Cantarell", 1, 16));
        lblTotal.setText("Total: R$ 0.00");
        
    }

    private void atualizarTotal() {
        double total = 0.0;

        for (ItemVenda item : itensVendas) {
            total += item.getSubtotal();
        }

        lblTotal.setText("Total: R$ " + String.format("%.2f", total));
    }
 
    private void carregarProdutos(){
        ProdutoDAO dao = new ProdutoDAO();
        listaProdutos = dao.listarTodos();
        cbxProduto.removeAllItems();

        for (Produto p : listaProdutos) {
            cbxProduto.addItem(p.toString()); // adiciona o objeto Produto diretamente
        }
    }
    
    private void carregarFuncionarios() {
       FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
       listaFuncionarios = funcionarioDAO.listarFuncionarios();

       cbxFuncionario.removeAllItems();
       for (Funcionario f : listaFuncionarios) {
           cbxFuncionario.addItem(f.toString());
       }
   }

    
    /*private void carregarFuncionarios() {
        FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
        List<Funcionario> funcionarios = funcionarioDAO.listarFuncionarios();

        cbxFuncionario.removeAllItems();
        for (Funcionario f : funcionarios) {
            cbxFuncionario.addItem(f.toString());
        }
}*/
    
    private void carregarQuantidades() {
    cbxQuantidade.removeAllItems();
    for (int i = 1; i <= 50; i++) {
        cbxQuantidade.addItem(String.valueOf(i));
    }
}
    
    
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnSair = new javax.swing.JButton();
        btnRealizarVenda = new javax.swing.JButton();
        lblProduto = new javax.swing.JLabel();
        cbxProduto = new javax.swing.JComboBox<>();
        lblQuantidade = new javax.swing.JLabel();
        cbxQuantidade = new javax.swing.JComboBox<>();
        lblFuncionario = new javax.swing.JLabel();
        cbxFuncionario = new javax.swing.JComboBox<>();
        btnAdicionar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btnRemoverItem = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel2.setFont(new java.awt.Font("Cantarell", 1, 36)); // NOI18N
        jLabel2.setText("Café Passado");

        jLabel3.setFont(new java.awt.Font("Cantarell", 2, 18)); // NOI18N
        jLabel3.setText("O café pode até passar, mas seu controle nunca. ");

        btnSair.setText("Voltar");
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });

        btnRealizarVenda.setText("Realizar Venda");
        btnRealizarVenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRealizarVendaActionPerformed(evt);
            }
        });

        lblProduto.setText("Produto");

        cbxProduto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        lblQuantidade.setText("Quantidade");

        cbxQuantidade.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        lblFuncionario.setText("Funcionário");

        cbxFuncionario.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnAdicionar.setText("Adicionar");
        btnAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        btnRemoverItem.setText("Remover Item");
        btnRemoverItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoverItemActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnRemoverItem)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSair)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnRealizarVenda))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 564, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblProduto)
                            .addComponent(cbxProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblQuantidade)
                                .addGap(18, 18, 18)
                                .addComponent(lblFuncionario))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cbxQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbxFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnAdicionar)))))
                .addGap(0, 40, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(117, 117, 117)
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(198, 198, 198))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblProduto)
                    .addComponent(lblQuantidade)
                    .addComponent(lblFuncionario))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbxProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAdicionar))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 251, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRealizarVenda)
                    .addComponent(btnSair)
                    .addComponent(btnRemoverItem))
                .addGap(25, 25, 25))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
    this.dispose();
    }//GEN-LAST:event_btnSairActionPerformed

    private void btnRemoverItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoverItemActionPerformed
    RemoverItem rm = new RemoverItem();
    rm.setVisible(true);
    }//GEN-LAST:event_btnRemoverItemActionPerformed

    private void btnRealizarVendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRealizarVendaActionPerformed
                                                 
        if (itensVendas == null || itensVendas.isEmpty()) {
        JOptionPane.showMessageDialog(null, "Adicione itens à venda antes de finalizar.");
        return;
    }

    double valorTotal = 0;
    for (ItemVenda item : itensVendas) {
        valorTotal += item.getSubtotal();
    }

    Object[] opcoes = {"Sim", "Não"};
    int escolha = JOptionPane.showOptionDialog(
        null,
        String.format("Deseja realmente finalizar a venda?\nTotal da compra: R$ %.2f", valorTotal),
        "Confirmar Venda",
        JOptionPane.YES_NO_OPTION,
        JOptionPane.QUESTION_MESSAGE,
        null,
        opcoes,
        opcoes[0]
    );

    if (escolha == 0) { // Sim
        int indiceSelecionado = cbxFuncionario.getSelectedIndex();
        Funcionario funcionarioSelecionado = listaFuncionarios.get(indiceSelecionado);
        //Funcionario funcionarioSelecionado = (Funcionario) cbxFuncionario.getSelectedItem();
        if (funcionarioSelecionado == null) {
            JOptionPane.showMessageDialog(null, "Selecione um funcionário.");
            return;
        }

        Venda venda = new Venda();
        venda.setFuncionario(funcionarioSelecionado);
        venda.setTotal(valorTotal);
        venda.setItens(itensVendas);

        VendaDAO vendaDAO = new VendaDAO();
        boolean sucesso = vendaDAO.inserir(venda);

        if (sucesso) {
            JOptionPane.showMessageDialog(null, "Venda realizada com sucesso!");
            itensVendas.clear();
            tableModel.setRowCount(0);
            lblTotal.setText("Total: R$ 0.00");
        } else {
            JOptionPane.showMessageDialog(null, "Erro ao salvar venda.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    } else {
        JOptionPane.showMessageDialog(null, "Venda cancelada.");
    }

    }//GEN-LAST:event_btnRealizarVendaActionPerformed

    private void btnAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarActionPerformed
        String nomeProduto = cbxProduto.getSelectedItem().toString();
        int quantidade = Integer.parseInt(cbxQuantidade.getSelectedItem().toString());

        Produto produtoSelecionado = null;
        for (Produto p : listaProdutos) {
            if (p.getNome().equals(nomeProduto)) {
                produtoSelecionado = p;
                break;
            }
        }

        if (produtoSelecionado == null) {
            JOptionPane.showMessageDialog(this, "Produto não encontrado!", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        double precoUnitario = produtoSelecionado.getPreco();
        double subtotal = precoUnitario * quantidade;

        // Cria e adiciona item à lista
        ItemVenda item = new ItemVenda(produtoSelecionado, quantidade, precoUnitario);
        itensVendas.add(item);

        // Atualiza a tabela
        Object[] novaLinha = {
            produtoSelecionado.getNome(),
            quantidade,
            cbxFuncionario.getSelectedItem().toString(),
            String.format("R$ %.2f", precoUnitario),
            String.format("R$ %.2f", subtotal)
        };

        tableModel.addRow(novaLinha);

        atualizarTotal();
    }//GEN-LAST:event_btnAdicionarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(RealizarVendas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RealizarVendas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RealizarVendas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RealizarVendas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RealizarVendas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdicionar;
    private javax.swing.JButton btnRealizarVenda;
    private javax.swing.JButton btnRemoverItem;
    private javax.swing.JButton btnSair;
    private javax.swing.JComboBox<String> cbxFuncionario;
    private javax.swing.JComboBox<String> cbxProduto;
    private javax.swing.JComboBox<String> cbxQuantidade;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lblFuncionario;
    private javax.swing.JLabel lblProduto;
    private javax.swing.JLabel lblQuantidade;
    // End of variables declaration//GEN-END:variables
}
