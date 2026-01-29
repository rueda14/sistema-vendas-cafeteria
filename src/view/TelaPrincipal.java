
package view;

import controller.AdminDAO;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


public class TelaPrincipal extends javax.swing.JFrame {

    
    public TelaPrincipal() {
        initComponents();
            
        this.setTitle("Menu Principal");
        this.setSize(630, 510);//set tamanho da janela
        this.setResizable(false); //impede de maximizar
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
     
    }

   
    
    
    
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lblDiegoRueda = new javax.swing.JLabel();
        lblNicoleNascimento = new javax.swing.JLabel();
        lblCodNick = new javax.swing.JLabel();
        lblCodRueda = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        lblDesenvolvedores = new javax.swing.JLabel();
        btnCadastrarProdutos = new javax.swing.JButton();
        btnCadastrarFuncionarios = new javax.swing.JButton();
        btnRealizarVendas = new javax.swing.JButton();
        btnRealizarPesquisa = new javax.swing.JButton();
        btnSair = new javax.swing.JButton();
        btnConfiguracaoAdmin = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/media/logo_cafe_transparente1.png"))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Cantarell", 1, 36)); // NOI18N
        jLabel2.setText("Café Passado");

        jLabel3.setFont(new java.awt.Font("Cantarell", 2, 18)); // NOI18N
        jLabel3.setText("O café pode até passar, mas seu controle nunca. ");

        lblDiegoRueda.setText("Diego Rueda");

        lblNicoleNascimento.setText("Nicole Inoue");

        lblCodNick.setText("Código: 840225");

        lblCodRueda.setText("Código: 769200");

        jLabel8.setText("Professor Dr. Rodrigo de Oliveira Plotze");

        lblDesenvolvedores.setText("Desenvolvedores:");

        btnCadastrarProdutos.setText("Cadastrar Produtos");
        btnCadastrarProdutos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarProdutosActionPerformed(evt);
            }
        });

        btnCadastrarFuncionarios.setText("Cadastrar Funcionários");
        btnCadastrarFuncionarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarFuncionariosActionPerformed(evt);
            }
        });

        btnRealizarVendas.setText("Realizar Venda");
        btnRealizarVendas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRealizarVendasActionPerformed(evt);
            }
        });

        btnRealizarPesquisa.setText("Realizar Pesquisa");
        btnRealizarPesquisa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRealizarPesquisaActionPerformed(evt);
            }
        });

        btnSair.setText("Sair");
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });

        btnConfiguracaoAdmin.setText("Configurações de ADMIN");
        btnConfiguracaoAdmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfiguracaoAdminActionPerformed(evt);
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
                        .addGap(117, 117, 117)
                        .addComponent(jLabel3))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lblNicoleNascimento)
                                    .addComponent(lblDiegoRueda))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblCodNick)
                                    .addComponent(lblCodRueda)))
                            .addComponent(lblDesenvolvedores)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 165, Short.MAX_VALUE)
                                .addComponent(btnSair))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jLabel1)
                        .addGap(58, 58, 58)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnCadastrarFuncionarios, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnRealizarVendas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnCadastrarProdutos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnRealizarPesquisa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnConfiguracaoAdmin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(63, 63, 63))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel3)
                        .addGap(12, 12, 12)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblDesenvolvedores)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblDiegoRueda)
                            .addComponent(lblCodRueda))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblNicoleNascimento)
                            .addComponent(lblCodNick))
                        .addGap(21, 21, 21))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnCadastrarProdutos)
                        .addGap(18, 18, 18)
                        .addComponent(btnCadastrarFuncionarios)
                        .addGap(18, 18, 18)
                        .addComponent(btnConfiguracaoAdmin)
                        .addGap(18, 18, 18)
                        .addComponent(btnRealizarPesquisa)
                        .addGap(18, 18, 18)
                        .addComponent(btnRealizarVendas)
                        .addGap(53, 53, 53)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(btnSair))
                .addGap(48, 48, 48))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCadastrarFuncionariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarFuncionariosActionPerformed
        CadastroFuncionario cf = new CadastroFuncionario();
        cf.setVisible(true);
    }//GEN-LAST:event_btnCadastrarFuncionariosActionPerformed

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        String[] opcoes = {"Sim", "Não"};

        int res = JOptionPane.showOptionDialog(null,
            "Deseja mesmo sair?",
            "Confirmação",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.QUESTION_MESSAGE,
            null, //icone personalizado? deixei como null (padrão)
            opcoes, //espera um vetor de botões personalizados
            opcoes[1]); // "Não" será a opção padrão

        if (res == 0) { // Clicou em "Sim"
            System.exit(0);
        }
        // Se clicar em "Não", não faz nada (a tela permanece aberta)

    }//GEN-LAST:event_btnSairActionPerformed

    private void btnConfiguracaoAdminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfiguracaoAdminActionPerformed
        //ConfiguracaoAdmin ca = new ConfiguracaoAdmin();
        //ca.setVisible(true);
        
        JTextField txtEmail = new JTextField();
        JPasswordField txtSenha = new JPasswordField();

        Object[] campos = {
            "Email:", txtEmail,
            "Senha:", txtSenha
        };

        int opcao = JOptionPane.showConfirmDialog(null, campos, "Autenticação de Administrador", JOptionPane.OK_CANCEL_OPTION);

        if (opcao == JOptionPane.OK_OPTION) {
            String email = txtEmail.getText().trim();
            String senha = new String(txtSenha.getPassword());

            AdminDAO dao = new AdminDAO();
            if (dao.autenticarAdmin(email, senha)) {
                JOptionPane.showMessageDialog(null, "Acesso concedido.");
                ConfiguracaoAdmin ca = new ConfiguracaoAdmin();
                ca.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(null, "Email ou senha inválidos!");
            }
        }

    }//GEN-LAST:event_btnConfiguracaoAdminActionPerformed

    private void btnCadastrarProdutosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarProdutosActionPerformed
        CadastroProduto cp = new CadastroProduto();
        cp.setVisible(true);
    }//GEN-LAST:event_btnCadastrarProdutosActionPerformed

    private void btnRealizarPesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRealizarPesquisaActionPerformed
        RealizarPesquisa rp = new RealizarPesquisa();
        rp.setVisible(true);
    }//GEN-LAST:event_btnRealizarPesquisaActionPerformed

    private void btnRealizarVendasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRealizarVendasActionPerformed
        RealizarVendas rv = new RealizarVendas();
        rv.setVisible(true);
    }//GEN-LAST:event_btnRealizarVendasActionPerformed

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
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCadastrarFuncionarios;
    private javax.swing.JButton btnCadastrarProdutos;
    private javax.swing.JButton btnConfiguracaoAdmin;
    private javax.swing.JButton btnRealizarPesquisa;
    private javax.swing.JButton btnRealizarVendas;
    private javax.swing.JButton btnSair;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel lblCodNick;
    private javax.swing.JLabel lblCodRueda;
    private javax.swing.JLabel lblDesenvolvedores;
    private javax.swing.JLabel lblDiegoRueda;
    private javax.swing.JLabel lblNicoleNascimento;
    // End of variables declaration//GEN-END:variables
}
