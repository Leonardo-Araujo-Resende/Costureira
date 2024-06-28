
package View;

import Controller.ControllerMaster;
import Controller.CriarTipoServicoController;
import Model.Costureira;
import com.formdev.flatlaf.FlatDarkLaf;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class CriarTipoServico extends javax.swing.JFrame {
    
    private Costureira costureiraLogada;
    private CriarTipoServicoController controller;

    public CriarTipoServico(Costureira costureiraLogada) {
        ControllerMaster.setIcone(this);
        this.costureiraLogada = costureiraLogada;
        controller = new CriarTipoServicoController(this);

        
        initComponents();
        controller.atualizarTabela();
    }
    
    public CriarTipoServico() {
        initComponents();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Titulo = new javax.swing.JLabel();
        LabelTipo = new javax.swing.JLabel();
        InputTipo = new javax.swing.JTextField();
        LabelValor = new javax.swing.JLabel();
        InputValor = new javax.swing.JTextField();
        LabelObservacao = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        InputObservacao = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        TabelaTipoServico = new javax.swing.JTable();
        BotaoCriar = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(0, 0, 0));
        setMinimumSize(new java.awt.Dimension(910, 565));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Titulo.setFont(new java.awt.Font("Segoe UI Black", 1, 36)); // NOI18N
        Titulo.setForeground(new java.awt.Color(65, 105, 225));
        Titulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Titulo.setText("Tipo de Serviço");
        getContentPane().add(Titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 10, 450, -1));

        LabelTipo.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        LabelTipo.setText(" Tipo*");
        getContentPane().add(LabelTipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 100, 50, -1));

        InputTipo.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        InputTipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InputTipoActionPerformed(evt);
            }
        });
        getContentPane().add(InputTipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 120, 280, 40));

        LabelValor.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        LabelValor.setText(" Valor*");
        getContentPane().add(LabelValor, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 170, 60, -1));

        InputValor.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        InputValor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InputValorActionPerformed(evt);
            }
        });
        getContentPane().add(InputValor, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 190, 280, 40));

        LabelObservacao.setFont(new java.awt.Font("Segoe UI Black", 0, 14)); // NOI18N
        LabelObservacao.setText("Observação");
        getContentPane().add(LabelObservacao, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 100, -1, -1));

        InputObservacao.setColumns(20);
        InputObservacao.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        InputObservacao.setRows(5);
        jScrollPane1.setViewportView(InputObservacao);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 120, 420, 110));

        TabelaTipoServico.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Tipo", "Valor", "Observacao"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(TabelaTipoServico);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 300, 720, 200));

        BotaoCriar.setBackground(new java.awt.Color(65, 105, 225));
        BotaoCriar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        BotaoCriar.setForeground(new java.awt.Color(255, 255, 255));
        BotaoCriar.setText("Criar Tipo de Serviço");
        BotaoCriar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BotaoCriar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoCriarActionPerformed(evt);
            }
        });
        getContentPane().add(BotaoCriar, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 250, 720, 40));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void InputValorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InputValorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_InputValorActionPerformed

    private void InputTipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InputTipoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_InputTipoActionPerformed

    private void BotaoCriarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoCriarActionPerformed
        try {
            controller.criarTipoServico();
        } catch (SQLException ex) {
            Logger.getLogger(CriarTipoServico.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_BotaoCriarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton BotaoCriar;
    private javax.swing.JTextArea InputObservacao;
    private javax.swing.JTextField InputTipo;
    private javax.swing.JTextField InputValor;
    private javax.swing.JLabel LabelObservacao;
    private javax.swing.JLabel LabelTipo;
    private javax.swing.JLabel LabelValor;
    private javax.swing.JTable TabelaTipoServico;
    private javax.swing.JLabel Titulo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
    
    public void exibirMensagem(String mensagemExibida){
        JOptionPane.showMessageDialog(this, mensagemExibida);
    }
    
    public JTextArea getInputObservacao() {
        return InputObservacao;
    }

    public void setInputObservacao(JTextArea InputObservacao) {
        this.InputObservacao = InputObservacao;
    }

    public JTextField getInputTipo() {
        return InputTipo;
    }

    public void setInputTipo(JTextField InputTipo) {
        this.InputTipo = InputTipo;
    }

    public JTextField getInputValor() {
        return InputValor;
    }

    public void setInputValor(JTextField InputValor) {
        this.InputValor = InputValor;
    }

    public JTable getTabelaTipoServico() {
        return TabelaTipoServico;
    }

    public void setCostureiraLogada(Costureira costureiraLogada) {
        this.costureiraLogada = costureiraLogada;
    }
    
    
    
    public void setTabelaTipoServico(JTable TabelaTipoServico) {
        this.TabelaTipoServico = TabelaTipoServico;
    }

    public Costureira getCostureiraLogada() {
        return costureiraLogada;
    }


        
}
