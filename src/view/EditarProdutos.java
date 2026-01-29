package view;

import controller.CategoriaDAO;
import controller.ProdutoDAO;
import java.awt.Image;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import model.Categoria;
import model.Produto;


public class EditarProdutos extends javax.swing.JFrame {

    private List<Categoria> listaCategorias;

    public EditarProdutos() {
        initComponents();
            
        this.setTitle("Editar Produtos");
        this.setSize(630, 510);//set tamanho da janela
        this.setResizable(false); //impede de maximizar
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        carregarTabela();
        carregarCategorias();
        
        txtID.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtIDKeyReleased(evt);
            }
        });
     
    }
    
    private void carregarCategorias() {
        CategoriaDAO dao = new CategoriaDAO();
        listaCategorias = dao.listarTodas(); // Armazena todas as categorias

        jComboBox1.removeAllItems();

        for (Categoria c : listaCategorias) {
            jComboBox1.addItem(c.getNome()); // Apenas o nome vai para o combo
        }
    }

   private void carregarTabela() {
        ProdutoDAO dao = new ProdutoDAO();
        List<Produto> lista = dao.listarTodos();

        String[] colunas = {"ID", "Nome", "Preço", "Descrição", "Categoria"};
        Object[][] dados = new Object[lista.size()][5];

        for (int i = 0; i < lista.size(); i++) {
            Produto p = lista.get(i);
            dados[i][0] = p.getId();
            dados[i][1] = p.getNome();
            dados[i][2] = p.getPreco();
            dados[i][3] = p.getDescricao();
            dados[i][4] = p.getIdCategoria(); // Pode substituir pelo nome da categoria depois
        }

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            dados,
            colunas
        ));
          
}
    
    private void txtIDKeyReleased(java.awt.event.KeyEvent evt) {
    String texto = txtID.getText().trim();

    if (texto.isEmpty()) {
        carregarTabela(); // carrega todos
        return;
    }

    try {
        int id = Integer.parseInt(texto);
        ProdutoDAO dao = new ProdutoDAO();
        Produto produto = dao.buscarPorId(id);

        if (produto != null) {
            String[] colunas = {"ID", "Nome", "Preço", "Descrição", "Categoria"};
            Object[][] dados = {
                {produto.getId(), produto.getNome(), produto.getPreco(), produto.getDescricao(), produto.getIdCategoria()}
            };

            jTable1.setModel(new javax.swing.table.DefaultTableModel(
                dados, colunas
            ));
        } else {
            jTable1.setModel(new javax.swing.table.DefaultTableModel(
                new Object[0][5], new String[]{"ID", "Nome", "Preço", "Descrição", "Categoria"}
            ));
        }
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "Nenhum produto encontrado com o ID informado.");
    }
}
    
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnVoltar = new javax.swing.JButton();
        txtID = new javax.swing.JTextField();
        btnSelecionar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        lblNome = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        lblPreco = new javax.swing.JLabel();
        txtPreco = new javax.swing.JTextField();
        lblDescricao = new javax.swing.JLabel();
        txtDescricao = new javax.swing.JTextField();
        lblCategoria = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        txtIdProduto = new javax.swing.JLabel();
        btnSalvar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel2.setFont(new java.awt.Font("Cantarell", 1, 36)); // NOI18N
        jLabel2.setText("Café Passado");

        jLabel3.setFont(new java.awt.Font("Cantarell", 2, 18)); // NOI18N
        jLabel3.setText("O café pode até passar, mas seu controle nunca. ");

        btnVoltar.setText("Voltar");
        btnVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltarActionPerformed(evt);
            }
        });

        btnSelecionar.setText("Selecionar");
        btnSelecionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSelecionarActionPerformed(evt);
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

        lblNome.setText("Nome");

        txtNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomeActionPerformed(evt);
            }
        });

        lblPreco.setText("Preço");

        lblDescricao.setText("Descrição");

        lblCategoria.setText("Categoria");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Bebidas Quentes", "Bebidas Frias", "Salgados", "Doces e Sobremesas", "Sanduíches e Lanches", "Combos e Kits", "Produtos de Prateleira", "Adicionais e Outros" }));

        txtIdProduto.setText("Id Produto");

        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(204, 204, 204))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 25, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 542, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(txtIdProduto)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnSelecionar))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btnVoltar)
                                        .addGap(18, 18, 18)
                                        .addComponent(btnSalvar))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(lblNome)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGap(92, 92, 92)
                                            .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(txtDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 542, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(txtPreco, javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                        .addComponent(lblPreco)
                                                        .addGap(118, 118, 118)))
                                                .addComponent(lblDescricao))
                                            .addGap(130, 130, 130)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(lblCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(117, 117, 117)
                        .addComponent(jLabel3)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(63, 63, 63))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSelecionar)
                            .addComponent(txtIdProduto))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblNome)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lblCategoria))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblPreco)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtPreco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblDescricao)
                .addGap(18, 18, 18)
                .addComponent(txtDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnVoltar)
                    .addComponent(btnSalvar))
                .addGap(48, 48, 48))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarActionPerformed
    this.dispose();

    }//GEN-LAST:event_btnVoltarActionPerformed

    private void txtNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNomeActionPerformed

    private void btnSelecionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSelecionarActionPerformed

        int linhaSelecionada = jTable1.getSelectedRow();

        if (linhaSelecionada >= 0) {
            int idProduto = (int) jTable1.getValueAt(linhaSelecionada, 0);
            String nome = (String) jTable1.getValueAt(linhaSelecionada, 1);
            double preco = (double) jTable1.getValueAt(linhaSelecionada, 2);
            String descricao = (String) jTable1.getValueAt(linhaSelecionada, 3);
            int idCategoria = (int) jTable1.getValueAt(linhaSelecionada, 4);

            // Preenchendo os campos da interface
            txtID.setText(String.valueOf(idProduto));
            txtNome.setText(nome);
            txtPreco.setText(String.valueOf(preco));
            txtDescricao.setText(descricao);
            for (int i = 0; i < jComboBox1.getItemCount(); i++) {
                Categoria c = listaCategorias.get(i); // pega da lista auxiliar
                if (c.getId() == idCategoria) {
                    jComboBox1.setSelectedIndex(i); // seleciona no combo
                    break;
                }
            }
            
        } else {
            JOptionPane.showMessageDialog(this, "Selecione uma linha da tabela.");
        }

    }//GEN-LAST:event_btnSelecionarActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        Object[] options = {"Sim", "Não"};
        int confirmacao = JOptionPane.showOptionDialog(
            this,
            "Tem certeza que deseja salvar as alterações?",
            "Confirmar edição",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.QUESTION_MESSAGE,
            null,
            options,
            options[0]  // botão padrão selecionado
        );

        if (confirmacao != JOptionPane.YES_OPTION) {
            return; // Sai do método se usuário não confirmar
        }

        try {
            // Verifica se o campo ID está preenchido
            if (txtID.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Selecione um produto para editar.");
                return;
            }

            // Captura os dados dos campos
            int id = Integer.parseInt(txtID.getText());
            String nome = txtNome.getText();
            double preco = Double.parseDouble(txtPreco.getText());
            String descricao = txtDescricao.getText();
            int idCategoria = listaCategorias.get(jComboBox1.getSelectedIndex()).getId();

            // Cria o objeto Produto atualizado
            Produto p = new Produto();
            p.setId(id);
            p.setNome(nome);
            p.setPreco(preco);
            p.setDescricao(descricao);
            p.setIdCategoria(idCategoria);

            // Chama o DAO para atualizar
            ProdutoDAO dao = new ProdutoDAO();
            boolean atualizado = dao.atualizar(p);

            if (atualizado) {
                JOptionPane.showMessageDialog(this, "Produto atualizado com sucesso!");
                carregarTabela(); // Atualiza a tabela
            } else {
                JOptionPane.showMessageDialog(this, "Erro ao atualizar o produto.");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro: " + e.getMessage());
        }


    }//GEN-LAST:event_btnSalvarActionPerformed

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
            java.util.logging.Logger.getLogger(EditarProdutos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditarProdutos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditarProdutos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditarProdutos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EditarProdutos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSalvar;
    private javax.swing.JButton btnSelecionar;
    private javax.swing.JButton btnVoltar;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lblCategoria;
    private javax.swing.JLabel lblDescricao;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblPreco;
    private javax.swing.JTextField txtDescricao;
    private javax.swing.JTextField txtID;
    private javax.swing.JLabel txtIdProduto;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtPreco;
    // End of variables declaration//GEN-END:variables
}
