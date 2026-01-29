
package view;

import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;



public class ResetarDados extends javax.swing.JFrame {

    
    public ResetarDados() {
        initComponents();
            
        this.setTitle("Resetar Dados");
        this.setSize(630, 510);//set tamanho da janela
        this.setResizable(false); //impede de maximizar
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
     
    }

    private void resetarTabelaFuncionarios() {
        String sql = "TRUNCATE TABLE tb_funcionarios CASCADE;";
        executarReset(sql, "Funcionários");
    }

    private void resetarTabelaProdutos() {
        String sql = "TRUNCATE TABLE tb_produtos CASCADE;";
        executarReset(sql, "Produtos");
    }

    private void resetarTabelaCategorias() {
        String sql = "TRUNCATE TABLE tb_categorias CASCADE;";
        executarReset(sql, "Categorias");
    }

    private void resetarTudo() {
        // Aqui pode chamar todos os resets de tabelas
        resetarTabelaFuncionarios();
        resetarTabelaProdutos();
        resetarTabelaCategorias();
    }

    private void executarReset(String sql, String nomeTabela) {
        Object[] opcoes = {"Sim", "Não"};
        int resposta = JOptionPane.showOptionDialog(this,
            "Tem certeza que deseja resetar a tabela " + nomeTabela + "?",
            "Confirmação",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.QUESTION_MESSAGE,
            null,
            opcoes,
            opcoes[1]);

        if (resposta == JOptionPane.YES_OPTION) {
            try (Connection con = controller.Conexao.conectar();
                 PreparedStatement pst = con.prepareStatement(sql)) {

                pst.executeUpdate();
                JOptionPane.showMessageDialog(this, "Tabela " + nomeTabela + " resetada com sucesso!");

            } catch (SQLException e) {
                JOptionPane.showMessageDialog(this, "Erro ao resetar a tabela " + nomeTabela + ": " + e.getMessage());
            }
        }
    }
   
    
    
    
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnVoltar = new javax.swing.JButton();
        bntResetTbFuncion = new javax.swing.JButton();
        btnResetTbProdutos = new javax.swing.JButton();
        btnResetTbCategorias = new javax.swing.JButton();
        btnResetTudo = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/media/logo_cafe_transparente1.png"))); // NOI18N

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

        bntResetTbFuncion.setText("Resetar Tabela Funcionarios");
        bntResetTbFuncion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntResetTbFuncionActionPerformed(evt);
            }
        });

        btnResetTbProdutos.setText("Resetar Tabela Produtos");
        btnResetTbProdutos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetTbProdutosActionPerformed(evt);
            }
        });

        btnResetTbCategorias.setText("Resetar Tabela Categorias");
        btnResetTbCategorias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetTbCategoriasActionPerformed(evt);
            }
        });

        btnResetTudo.setText("Resetar Tudo");
        btnResetTudo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetTudoActionPerformed(evt);
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
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(495, Short.MAX_VALUE)
                        .addComponent(btnVoltar))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(117, 117, 117)
                                .addComponent(jLabel3))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(32, 32, 32)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(bntResetTbFuncion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnResetTbProdutos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnResetTbCategorias, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnResetTudo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(63, 63, 63))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addComponent(bntResetTbFuncion)
                        .addGap(18, 18, 18)
                        .addComponent(btnResetTbProdutos)
                        .addGap(18, 18, 18)
                        .addComponent(btnResetTbCategorias)
                        .addGap(18, 18, 18)
                        .addComponent(btnResetTudo)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 108, Short.MAX_VALUE)
                .addComponent(btnVoltar)
                .addGap(48, 48, 48))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarActionPerformed
        
        this.dispose();

    }//GEN-LAST:event_btnVoltarActionPerformed

    private void bntResetTbFuncionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntResetTbFuncionActionPerformed
        resetarTabelaFuncionarios();
    }//GEN-LAST:event_bntResetTbFuncionActionPerformed

    private void btnResetTbProdutosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetTbProdutosActionPerformed
        resetarTabelaProdutos();
    }//GEN-LAST:event_btnResetTbProdutosActionPerformed

    private void btnResetTbCategoriasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetTbCategoriasActionPerformed
        resetarTabelaCategorias();
    }//GEN-LAST:event_btnResetTbCategoriasActionPerformed

    private void btnResetTudoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetTudoActionPerformed
        Object[] opcoes = {"Sim", "Não"};
        int resposta = JOptionPane.showOptionDialog(
            this,
            "Tem certeza que deseja resetar TODAS as tabelas?",
            "Confirmação",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.QUESTION_MESSAGE,
            null,
            opcoes,
            opcoes[1] // botão padrão selecionado
        );
        if (resposta == JOptionPane.YES_OPTION) {
            resetarTudo();
        }
    }//GEN-LAST:event_btnResetTudoActionPerformed


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
            java.util.logging.Logger.getLogger(ResetarDados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ResetarDados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ResetarDados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ResetarDados.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ResetarDados().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bntResetTbFuncion;
    private javax.swing.JButton btnResetTbCategorias;
    private javax.swing.JButton btnResetTbProdutos;
    private javax.swing.JButton btnResetTudo;
    private javax.swing.JButton btnVoltar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    // End of variables declaration//GEN-END:variables
}
