
package View;

import Controller.ControllerMaster;
import Controller.CriarContaController;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


public class CriarConta extends javax.swing.JFrame {

    CriarContaController controller;
    
    public CriarConta() {
        ControllerMaster.setIcone(this);
        initComponents();
        this.controller = new CriarContaController(this);
        getRootPane().setDefaultButton(BotaoEntrar);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Titulo = new javax.swing.JLabel();
        LabelNome = new javax.swing.JLabel();
        InputNome = new javax.swing.JTextField();
        LabelUsuario = new javax.swing.JLabel();
        InputUsuario = new javax.swing.JTextField();
        BotaoEntrar = new javax.swing.JButton();
        LabelSenha = new javax.swing.JLabel();
        InputSenha = new javax.swing.JPasswordField();
        LabelConfirmaSenha = new javax.swing.JLabel();
        InputConfirmaSenha = new javax.swing.JPasswordField();
        PainelFundo = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Criar conta");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Titulo.setFont(new java.awt.Font("Segoe UI Black", 0, 30)); // NOI18N
        Titulo.setForeground(new java.awt.Color(65, 105, 225));
        Titulo.setText("Criar Conta");
        getContentPane().add(Titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, -1));

        LabelNome.setBackground(new java.awt.Color(0, 0, 0));
        LabelNome.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        LabelNome.setForeground(new java.awt.Color(153, 153, 153));
        LabelNome.setText("Nome");
        LabelNome.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LabelNomeMouseClicked(evt);
            }
        });
        getContentPane().add(LabelNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, 100, -1));

        InputNome.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        getContentPane().add(InputNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 130, 370, 50));

        LabelUsuario.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        LabelUsuario.setForeground(new java.awt.Color(153, 153, 153));
        LabelUsuario.setText("Usuário");
        LabelUsuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LabelUsuarioMouseClicked(evt);
            }
        });
        getContentPane().add(LabelUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 190, 100, -1));

        InputUsuario.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        getContentPane().add(InputUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 220, 370, 50));

        BotaoEntrar.setBackground(new java.awt.Color(65, 105, 225));
        BotaoEntrar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        BotaoEntrar.setForeground(new java.awt.Color(255, 255, 255));
        BotaoEntrar.setText("Criar Conta");
        BotaoEntrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BotaoEntrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoEntrarActionPerformed(evt);
            }
        });
        getContentPane().add(BotaoEntrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 490, 370, 50));

        LabelSenha.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        LabelSenha.setForeground(new java.awt.Color(153, 153, 153));
        LabelSenha.setText("Senha");
        getContentPane().add(LabelSenha, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 280, 60, -1));

        InputSenha.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        getContentPane().add(InputSenha, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 310, 370, 50));

        LabelConfirmaSenha.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        LabelConfirmaSenha.setForeground(new java.awt.Color(153, 153, 153));
        LabelConfirmaSenha.setText("Confirma Senha");
        getContentPane().add(LabelConfirmaSenha, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 370, 230, -1));

        InputConfirmaSenha.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        getContentPane().add(InputConfirmaSenha, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 400, 370, 50));

        PainelFundo.setBackground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout PainelFundoLayout = new javax.swing.GroupLayout(PainelFundo);
        PainelFundo.setLayout(PainelFundoLayout);
        PainelFundoLayout.setHorizontalGroup(
            PainelFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 490, Short.MAX_VALUE)
        );
        PainelFundoLayout.setVerticalGroup(
            PainelFundoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 610, Short.MAX_VALUE)
        );

        getContentPane().add(PainelFundo, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, -10, 490, 610));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void LabelUsuarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LabelUsuarioMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_LabelUsuarioMouseClicked

    private void BotaoEntrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoEntrarActionPerformed
        controller.criarConta();
    }//GEN-LAST:event_BotaoEntrarActionPerformed

    private void LabelNomeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LabelNomeMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_LabelNomeMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotaoEntrar;
    private javax.swing.JPasswordField InputConfirmaSenha;
    private javax.swing.JTextField InputNome;
    private javax.swing.JPasswordField InputSenha;
    private javax.swing.JTextField InputUsuario;
    private javax.swing.JLabel LabelConfirmaSenha;
    private javax.swing.JLabel LabelNome;
    private javax.swing.JLabel LabelSenha;
    private javax.swing.JLabel LabelUsuario;
    private javax.swing.JPanel PainelFundo;
    private javax.swing.JLabel Titulo;
    // End of variables declaration//GEN-END:variables
    
    public void exibirMensagem(String mensagemExibida){
        JOptionPane.showMessageDialog(this, mensagemExibida);
    }
    
    public JPasswordField getInputConfirmaSenha() {
        return InputConfirmaSenha;
    }

    public void setInputConfirmaSenha(JPasswordField InputConfirmaSenha) {
        this.InputConfirmaSenha = InputConfirmaSenha;
    }

    public JTextField getInputNome() {
        return InputNome;
    }

    public void setInputNome(JTextField InputNome) {
        this.InputNome = InputNome;
    }

    public JPasswordField getInputSenha() {
        return InputSenha;
    }

    public void setInputSenha(JPasswordField InputSenha) {
        this.InputSenha = InputSenha;
    }

    public JTextField getInputUsuario() {
        return InputUsuario;
    }

    public void setInputUsuario(JTextField InputUsuario) {
        this.InputUsuario = InputUsuario;
    }
    
    
}
