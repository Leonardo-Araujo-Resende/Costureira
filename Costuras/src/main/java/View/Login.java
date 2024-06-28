
package View;

import Controller.ControllerMaster;
import Controller.LoginController;
import Model.Costureira;
import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.FlatLightLaf;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;


public class Login extends javax.swing.JFrame {

    LoginController loginController;
    
    public Login() {
        ControllerMaster.setIcone(this);
        
        initComponents();
       
        loginController = new LoginController(this);
        
        //Define um botao como padrao para o jframe, qnd ENTER pressionado aciona o botao
        getRootPane().setDefaultButton(BotaoEntrar);
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        TituloLogin = new javax.swing.JLabel();
        LabelLogin = new javax.swing.JLabel();
        InputLogin = new javax.swing.JTextField();
        LabelSenha = new javax.swing.JLabel();
        InputSenha = new javax.swing.JPasswordField();
        BotaoEntrar = new javax.swing.JButton();
        LabelCriarConta = new javax.swing.JLabel();
        BotaoCriarConta = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(0, 0, 0));
        setMinimumSize(new java.awt.Dimension(445, 455));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        TituloLogin.setFont(new java.awt.Font("Segoe UI Black", 0, 30)); // NOI18N
        TituloLogin.setForeground(new java.awt.Color(65, 105, 225));
        TituloLogin.setText("LOGIN");
        getContentPane().add(TituloLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 40, -1, -1));

        LabelLogin.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        LabelLogin.setForeground(new java.awt.Color(153, 153, 153));
        LabelLogin.setText(" Usuário");
        LabelLogin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LabelLoginMouseClicked(evt);
            }
        });
        getContentPane().add(LabelLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 120, 100, -1));

        InputLogin.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        getContentPane().add(InputLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 150, 370, 50));

        LabelSenha.setFont(new java.awt.Font("Segoe UI Black", 0, 18)); // NOI18N
        LabelSenha.setForeground(new java.awt.Color(153, 153, 153));
        LabelSenha.setText(" Senha");
        getContentPane().add(LabelSenha, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 220, 60, -1));

        InputSenha.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        getContentPane().add(InputSenha, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 250, 370, 50));

        BotaoEntrar.setBackground(new java.awt.Color(65, 105, 225));
        BotaoEntrar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        BotaoEntrar.setText("Entrar");
        BotaoEntrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BotaoEntrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoEntrarActionPerformed(evt);
            }
        });
        getContentPane().add(BotaoEntrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 330, 370, 50));

        LabelCriarConta.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        LabelCriarConta.setForeground(new java.awt.Color(102, 102, 102));
        LabelCriarConta.setText("Não tem conta?");
        getContentPane().add(LabelCriarConta, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 410, -1, -1));

        BotaoCriarConta.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        BotaoCriarConta.setForeground(new java.awt.Color(65, 105, 225));
        BotaoCriarConta.setText("Criar conta");
        BotaoCriarConta.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BotaoCriarConta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                BotaoCriarContaMouseClicked(evt);
            }
        });
        getContentPane().add(BotaoCriarConta, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 410, -1, -1));

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-10, -10, 470, 480));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void BotaoEntrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoEntrarActionPerformed

        loginController.logarSistema();
  
    }//GEN-LAST:event_BotaoEntrarActionPerformed
    
    public void abrirMenuPrincipal(Costureira costureira){
        new MenuPrincipal(costureira).setVisible(true);
        this.dispose();
    }
    
    private void LabelLoginMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LabelLoginMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_LabelLoginMouseClicked

    private void BotaoCriarContaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_BotaoCriarContaMouseClicked
        CriarConta menu = new CriarConta();
        menu.setVisible(true);
    }//GEN-LAST:event_BotaoCriarContaMouseClicked

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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    UIManager.setLookAndFeel(new FlatDarkLaf());
                } catch (UnsupportedLookAndFeelException ex) {
                    Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                }
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel BotaoCriarConta;
    private javax.swing.JButton BotaoEntrar;
    private javax.swing.JTextField InputLogin;
    private javax.swing.JPasswordField InputSenha;
    private javax.swing.JLabel LabelCriarConta;
    private javax.swing.JLabel LabelLogin;
    private javax.swing.JLabel LabelSenha;
    private javax.swing.JLabel TituloLogin;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
    
    public void exibirMensagem(String mensagemExibida){
        JOptionPane.showMessageDialog(this, mensagemExibida);
    }
    
    public JTextField getInputLogin() {
        return InputLogin;
    }

    public void setInputLogin(JTextField InputLogin) {
        this.InputLogin = InputLogin;
    }

    public JPasswordField getInputSenha() {
        return InputSenha;
    }

    public void setInputSenha(JPasswordField InputSenha) {
        this.InputSenha = InputSenha;
    }

    public JLabel getLabelLogin() {
        return LabelLogin;
    }

    public void setLabelLogin(JLabel LabelLogin) {
        this.LabelLogin = LabelLogin;
    }

    public JLabel getLabelSenha() {
        return LabelSenha;
    }

    public void setLabelSenha(JLabel LabelSenha) {
        this.LabelSenha = LabelSenha;
    }
}
