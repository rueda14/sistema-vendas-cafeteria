package view;

import controller.FuncionarioDAO;
import controller.ProdutoDAO;
import controller.VendaDAO;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.Funcionario;
import model.ItemVenda;
import model.Produto;
import model.Venda;


public class RealizarPesquisa extends javax.swing.JFrame {


    private List<ItemVenda> itens = new ArrayList<>();
    public RealizarPesquisa() {
        initComponents();
            
        this.setTitle("Realizar Pesquisa");
        this.setSize(630, 510);//set tamanho da janela
        this.setResizable(false); //impede de maximizar
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //Exibir os Produtos na tabela
        preencherTabelaProdutos(new ProdutoDAO().listar());
        
        ButtonGroup bg = new ButtonGroup();
        bg.add(rdbId);
        bg.add(rdbNome);
        rdbId.setSelected(true);
        
        //Exibir os Funcionarios na tabela
        preencherTabelaFuncionarios(new FuncionarioDAO().listar());
        
        ButtonGroup bg1 = new ButtonGroup();
        bg1.add(rdbId1);
        bg1.add(rdbNome1);
        rdbId1.setSelected(true);
        
        //Exibir as Vendas na tabela
        preencherTabelaVendas(new VendaDAO().listar());
        ButtonGroup bg2 = new ButtonGroup();
        bg2.add(rdbId2);
        bg2.add(rdbFuncionario);
        rdbId2.setSelected(true);
        
        
    }

    //Produto
    private void configurarTabela(){
        DefaultTableModel m1 = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
        m1.addColumn("Id");
        m1.addColumn("Nome");
        m1.addColumn("Preco");
        m1.addColumn("Descricao");
        m1.addColumn("Id Categoria");
        tabResultados.setModel(m1);
    }
    
    //Funcionario
    private void configurarTabela1(){
        DefaultTableModel m2 = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
        m2.addColumn("id");
        m2.addColumn("nome");
        m2.addColumn("email");
        tabResultados1.setModel(m2);
    }
    
    //Vendas
    private void configurarTabela2(){
        DefaultTableModel m3 = new DefaultTableModel(){
            @Override
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
        m3.addColumn("id");
        m3.addColumn("funcionario");
        m3.addColumn("data_venda");
        m3.addColumn("total");
        m3.addColumn("itens");
        m3.addColumn("quantidade");
        tabResultados2.setModel(m3);
    }
    
    //private JTable tabelaProdutos = new JTable();
    //private JTable tabelaFuncionarios = new JTable();

     public void preencherTabelaProdutos(List<Produto> produtos) {
        configurarTabela();
        DefaultTableModel modelo = (DefaultTableModel) tabResultados.getModel();
        modelo.setRowCount(0);
        for (Produto p : produtos) {
            modelo.addRow(new Object[]{p.getId(), p.getNome(), p.getPreco(), p.getDescricao(), p.getIdCategoria()});
        }
    }


    public void preencherTabelaFuncionarios(List<Funcionario> funcionarios) {
        configurarTabela1();
        DefaultTableModel modelo = (DefaultTableModel) tabResultados1.getModel();
        modelo.setRowCount(0);
        for (Funcionario f : funcionarios) {
            modelo.addRow(new Object[]{f.getId(), f.getNome(), f.getEmail()});
        }
    }

    /*public void preencherTabelaVendas(List<Venda> vendas) {
        configurarTabela2();
        DefaultTableModel modelo = (DefaultTableModel) tabResultados2.getModel();
        modelo.setRowCount(0);
        for (Venda v : vendas) {
            modelo.addRow(new Object[]{v.getId(), v.getFuncionario(), v.getData(), v.getTotal(), v.getItens().size()});
        }
    }*/
    
    /*public void preencherTabelaVendas(List<Venda> vendas) {
        configurarTabela2();
        DefaultTableModel modelo = (DefaultTableModel) tabResultados2.getModel();
        modelo.setRowCount(0);
        for (Venda v : vendas) {
            modelo.addRow(new Object[]{
                v.getId(),
                v.getFuncionario().getNome(),  // Mostra o nome do funcionário
                v.getData(),
                v.getTotal(),
                v.getItens().size() + " itens"
            });
        }
    }*/
    
    public void preencherTabelaVendas(List<Venda> vendas) {
    configurarTabela2();
    DefaultTableModel modelo = (DefaultTableModel) tabResultados2.getModel();
    modelo.setRowCount(0);
    
    for (Venda v : vendas) {
        StringBuilder resumoItens = new StringBuilder();
        for (ItemVenda item : v.getItens()) {
            resumoItens.append(item.getProduto().getNome())
                       .append(" (")
                       .append(item.getQuantidade())
                       .append("), ");
        }

        // Remove a última vírgula e espaço, se houver
        if (resumoItens.length() > 0) {
            resumoItens.setLength(resumoItens.length() - 2);
        }

        modelo.addRow(new Object[]{
            v.getId(),
            v.getFuncionario().getNome(),
            v.getData(),
            v.getTotal(),
            v.getItens().size() + " itens",
            resumoItens.toString()  // ← Aqui entra o texto formatado
        });
    }
}

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jRadioButton5 = new javax.swing.JRadioButton();
        jRadioButton6 = new javax.swing.JRadioButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        tabRealizarPesquisa = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        rdbId = new javax.swing.JRadioButton();
        rdbNome = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabResultados = new javax.swing.JTable();
        btnSair = new javax.swing.JButton();
        txtPesquisar = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabResultados1 = new javax.swing.JTable();
        btnSair1 = new javax.swing.JButton();
        rdbId1 = new javax.swing.JRadioButton();
        rdbNome1 = new javax.swing.JRadioButton();
        txtPesquisa1 = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        rdbId2 = new javax.swing.JRadioButton();
        rdbFuncionario = new javax.swing.JRadioButton();
        btnSair3 = new javax.swing.JButton();
        txtPesquisa2 = new javax.swing.JTextField();
        jScrollPane4 = new javax.swing.JScrollPane();
        tabResultados2 = new javax.swing.JTable();
        txtPesquisa3 = new javax.swing.JTextField();

        jRadioButton5.setText("ID");
        jRadioButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton5ActionPerformed(evt);
            }
        });

        jRadioButton6.setText("Nome");
        jRadioButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton6ActionPerformed(evt);
            }
        });

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane3.setViewportView(jTable3);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel2.setFont(new java.awt.Font("Cantarell", 1, 36)); // NOI18N
        jLabel2.setText("Café Passado");

        jLabel3.setFont(new java.awt.Font("Cantarell", 2, 18)); // NOI18N
        jLabel3.setText("O café pode até passar, mas seu controle nunca. ");

        rdbId.setText("ID");
        rdbId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdbIdActionPerformed(evt);
            }
        });

        rdbNome.setText("Nome");
        rdbNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdbNomeActionPerformed(evt);
            }
        });

        tabResultados.setModel(new javax.swing.table.DefaultTableModel(
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
        tabResultados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabResultadosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabResultados);

        btnSair.setText("Voltar");
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });

        txtPesquisar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPesquisarKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(rdbId)
                        .addGap(18, 18, 18)
                        .addComponent(rdbNome)
                        .addGap(18, 18, 18)
                        .addComponent(txtPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(btnSair)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 577, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 1, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rdbId)
                    .addComponent(rdbNome)
                    .addComponent(txtPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                .addComponent(btnSair))
        );

        tabRealizarPesquisa.addTab("Produtos", jPanel1);

        tabResultados1.setModel(new javax.swing.table.DefaultTableModel(
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
        tabResultados1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tabResultados1KeyReleased(evt);
            }
        });
        jScrollPane2.setViewportView(tabResultados1);

        btnSair1.setText("Voltar");
        btnSair1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSair1ActionPerformed(evt);
            }
        });

        rdbId1.setText("ID");

        rdbNome1.setText("Nome");

        txtPesquisa1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPesquisa1KeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnSair1))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(rdbId1)
                .addGap(18, 18, 18)
                .addComponent(rdbNome1)
                .addGap(18, 18, 18)
                .addComponent(txtPesquisa1, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 578, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rdbId1)
                    .addComponent(rdbNome1)
                    .addComponent(txtPesquisa1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(btnSair1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tabRealizarPesquisa.addTab("Funcionarios", jPanel2);

        rdbId2.setText("ID");
        rdbId2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdbId2ActionPerformed(evt);
            }
        });

        rdbFuncionario.setText("Funcionario");
        rdbFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdbFuncionarioActionPerformed(evt);
            }
        });

        btnSair3.setText("Voltar");
        btnSair3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSair3ActionPerformed(evt);
            }
        });

        txtPesquisa2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPesquisa2KeyReleased(evt);
            }
        });

        tabResultados2.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane4.setViewportView(tabResultados2);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(rdbId2)
                .addGap(18, 18, 18)
                .addComponent(rdbFuncionario)
                .addGap(18, 18, 18)
                .addComponent(txtPesquisa2, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnSair3))
            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 578, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rdbId2)
                    .addComponent(rdbFuncionario)
                    .addComponent(txtPesquisa2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addComponent(btnSair3)
                .addContainerGap())
        );

        tabRealizarPesquisa.addTab("Vendas", jPanel3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(204, 204, 204))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(117, 117, 117)
                        .addComponent(jLabel3))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(tabRealizarPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 578, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(30, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(225, 225, 225)
                    .addComponent(txtPesquisa3, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(226, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tabRealizarPesquisa)
                .addGap(14, 14, 14))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(242, 242, 242)
                    .addComponent(txtPesquisa3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(181, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnSairActionPerformed

    private void rdbNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdbNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdbNomeActionPerformed

    private void rdbIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdbIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdbIdActionPerformed

    private void jRadioButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton5ActionPerformed

    private void jRadioButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton6ActionPerformed

    private void rdbId2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdbId2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdbId2ActionPerformed

    private void rdbFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdbFuncionarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rdbFuncionarioActionPerformed

    private void btnSair3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSair3ActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnSair3ActionPerformed

    private void btnSair1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSair1ActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnSair1ActionPerformed

    private void txtPesquisarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPesquisarKeyReleased
         String chave1 = txtPesquisar.getText();
        
        if (chave1.isEmpty()){
            preencherTabelaProdutos(new ProdutoDAO().listar());
        }else{
            if(rdbId.isSelected()){
                preencherTabelaProdutos(new ProdutoDAO().pesquisarPorId(
                        Integer.parseInt(chave1))
                );
            }else if (rdbNome.isSelected()){
                preencherTabelaProdutos(new ProdutoDAO().pesquisarPorNome(chave1));
            }
        }  

    }//GEN-LAST:event_txtPesquisarKeyReleased

    private void tabResultadosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabResultadosMouseClicked
 
    }//GEN-LAST:event_tabResultadosMouseClicked

    private void tabResultados1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tabResultados1KeyReleased
 
    }//GEN-LAST:event_tabResultados1KeyReleased

    private void txtPesquisa1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPesquisa1KeyReleased
        String chave2 = txtPesquisa1.getText();
        
        if (chave2.isEmpty()){
            preencherTabelaFuncionarios(new FuncionarioDAO().listar());
        }else{
            if(rdbId1.isSelected()){
                preencherTabelaFuncionarios(new FuncionarioDAO().pesquisarPorId(
                        Integer.parseInt(chave2))
                );
            }else if (rdbNome1.isSelected()){
                preencherTabelaFuncionarios(new FuncionarioDAO().pesquisarPorNome(chave2));
            }
        }  
    }//GEN-LAST:event_txtPesquisa1KeyReleased

    private void txtPesquisa2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPesquisa2KeyReleased
        String chave3 = txtPesquisa2.getText().trim();

    List<Venda> vendas = new ArrayList<>();
    VendaDAO dao = new VendaDAO();

    if (chave3.isEmpty()) {
        vendas = dao.listar();
    } else {
        if (rdbId2.isSelected()) {
            try {
                int id = Integer.parseInt(chave3);
                vendas = dao.pesquisarPorId(id);
            } catch (NumberFormatException e) {
                vendas = new ArrayList<>();
            }
        } else if (rdbFuncionario.isSelected()) {
            vendas = dao.pesquisarPorFuncionarios(chave3);
        }
    }

    System.out.println("Vendas encontradas: " + vendas.size());
    preencherTabelaVendas(vendas);  
    }//GEN-LAST:event_txtPesquisa2KeyReleased

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
            java.util.logging.Logger.getLogger(RealizarPesquisa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RealizarPesquisa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RealizarPesquisa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RealizarPesquisa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RealizarPesquisa().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSair;
    private javax.swing.JButton btnSair1;
    private javax.swing.JButton btnSair3;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JRadioButton jRadioButton5;
    private javax.swing.JRadioButton jRadioButton6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable jTable3;
    private javax.swing.JRadioButton rdbFuncionario;
    private javax.swing.JRadioButton rdbId;
    private javax.swing.JRadioButton rdbId1;
    private javax.swing.JRadioButton rdbId2;
    private javax.swing.JRadioButton rdbNome;
    private javax.swing.JRadioButton rdbNome1;
    private javax.swing.JTabbedPane tabRealizarPesquisa;
    private javax.swing.JTable tabResultados;
    private javax.swing.JTable tabResultados1;
    private javax.swing.JTable tabResultados2;
    private javax.swing.JTextField txtPesquisa1;
    private javax.swing.JTextField txtPesquisa2;
    private javax.swing.JTextField txtPesquisa3;
    private javax.swing.JTextField txtPesquisar;
    // End of variables declaration//GEN-END:variables
}
