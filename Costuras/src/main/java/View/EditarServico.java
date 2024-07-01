
package View;

import Controller.ControllerMaster;
import Controller.EditarServicoController;
import Model.Costureira;
import Model.Servico;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JToggleButton;

public class EditarServico extends javax.swing.JFrame {
    

    Costureira costureiraLogada;
    Servico editandoServico;
    EditarServicoController controller;
    
    public EditarServico(Costureira costureiraLogada, Servico editarServico) {
        ControllerMaster.setIcone(this);
        this.costureiraLogada = costureiraLogada;
        this.editandoServico = editarServico;

        initComponents();
        
        //Atualiza titulo id
        getIdServicoTitulo().setText(editandoServico.getId() + "");
        
        this.controller = new EditarServicoController(this);
    }
    
    public EditarServico(){
        initComponents();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        IdServicoTitulo = new javax.swing.JLabel();
        Titulo = new javax.swing.JLabel();
        LabelCliente = new javax.swing.JLabel();
        ComboBoxCliente = new javax.swing.JComboBox<>();
        LabelTipoServico = new javax.swing.JLabel();
        ComboBoxTipoServico = new javax.swing.JComboBox<>();
        LabelCustoPecas = new javax.swing.JLabel();
        MoedaCustoPeca = new javax.swing.JLabel();
        InputCustoPecas = new javax.swing.JTextField();
        LabelValor = new javax.swing.JLabel();
        MoedaValor = new javax.swing.JLabel();
        InputValor = new javax.swing.JTextField();
        LabelObservacao = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        InputObservacao = new javax.swing.JTextArea();
        IconeConfirmar = new javax.swing.JLabel();
        BotaoConfirmar = new javax.swing.JToggleButton();
        IconeCancelar = new javax.swing.JLabel();
        BotaoCancelar = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(950, 375));
        setPreferredSize(new java.awt.Dimension(950, 375));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        IdServicoTitulo.setFont(new java.awt.Font("Segoe UI Black", 1, 36)); // NOI18N
        IdServicoTitulo.setForeground(new java.awt.Color(0, 67, 197));
        IdServicoTitulo.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        IdServicoTitulo.setText("15");
        IdServicoTitulo.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        getContentPane().add(IdServicoTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 90, -1));

        Titulo.setFont(new java.awt.Font("Segoe UI Black", 1, 36)); // NOI18N
        Titulo.setForeground(new java.awt.Color(0, 67, 197));
        Titulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        Titulo.setText("Editar Serviço");
        getContentPane().add(Titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 20, 450, -1));

        LabelCliente.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        LabelCliente.setText("Cliente*");
        getContentPane().add(LabelCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, -1, -1));

        ComboBoxCliente.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        ComboBoxCliente.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "" }));
        ComboBoxCliente.setToolTipText("");
        ComboBoxCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboBoxClienteActionPerformed(evt);
            }
        });
        getContentPane().add(ComboBoxCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 220, 40));

        LabelTipoServico.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        LabelTipoServico.setText("Tipo Serviço*");
        getContentPane().add(LabelTipoServico, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, -1, -1));

        ComboBoxTipoServico.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        ComboBoxTipoServico.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "" }));
        ComboBoxTipoServico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboBoxTipoServicoActionPerformed(evt);
            }
        });
        getContentPane().add(ComboBoxTipoServico, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, 220, 40));

        LabelCustoPecas.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        LabelCustoPecas.setText("Custo Peças");
        getContentPane().add(LabelCustoPecas, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 170, -1, -1));

        MoedaCustoPeca.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        MoedaCustoPeca.setForeground(new java.awt.Color(102, 102, 102));
        MoedaCustoPeca.setText("R$");
        getContentPane().add(MoedaCustoPeca, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 200, -1, -1));

        InputCustoPecas.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        InputCustoPecas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InputCustoPecasActionPerformed(evt);
            }
        });
        getContentPane().add(InputCustoPecas, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 190, 220, 40));

        LabelValor.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        LabelValor.setText("Valor*");
        getContentPane().add(LabelValor, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 100, -1, -1));

        MoedaValor.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        MoedaValor.setForeground(new java.awt.Color(102, 102, 102));
        MoedaValor.setText("R$");
        getContentPane().add(MoedaValor, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 130, -1, -1));

        InputValor.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        InputValor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InputValorActionPerformed(evt);
            }
        });
        getContentPane().add(InputValor, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 120, 220, 40));

        LabelObservacao.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        LabelObservacao.setText("Observação");
        getContentPane().add(LabelObservacao, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 100, -1, -1));

        InputObservacao.setColumns(20);
        InputObservacao.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        InputObservacao.setRows(5);
        jScrollPane1.setViewportView(InputObservacao);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 120, 390, 110));

        IconeConfirmar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconEditar.png"))); // NOI18N
        IconeConfirmar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        getContentPane().add(IconeConfirmar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 270, 40, 50));

        BotaoConfirmar.setBackground(new java.awt.Color(0, 67, 197));
        BotaoConfirmar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        BotaoConfirmar.setForeground(new java.awt.Color(255, 255, 255));
        BotaoConfirmar.setText("Confirmar");
        BotaoConfirmar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BotaoConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoConfirmarActionPerformed(evt);
            }
        });
        getContentPane().add(BotaoConfirmar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, 420, 50));

        IconeCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconLixeira.png"))); // NOI18N
        IconeCancelar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        getContentPane().add(IconeCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 280, -1, -1));

        BotaoCancelar.setBackground(new java.awt.Color(158, 0, 0));
        BotaoCancelar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        BotaoCancelar.setForeground(new java.awt.Color(255, 255, 255));
        BotaoCancelar.setText("Cancelar");
        BotaoCancelar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BotaoCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoCancelarActionPerformed(evt);
            }
        });
        getContentPane().add(BotaoCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 270, 440, 50));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void ComboBoxClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboBoxClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ComboBoxClienteActionPerformed

    private void ComboBoxTipoServicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboBoxTipoServicoActionPerformed

    }//GEN-LAST:event_ComboBoxTipoServicoActionPerformed

    private void InputCustoPecasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InputCustoPecasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_InputCustoPecasActionPerformed

    private void InputValorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InputValorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_InputValorActionPerformed

    private void BotaoConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoConfirmarActionPerformed
        if(controller.editarServico()){
            this.dispose();
        }
    }//GEN-LAST:event_BotaoConfirmarActionPerformed

    private void BotaoCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_BotaoCancelarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton BotaoCancelar;
    private javax.swing.JToggleButton BotaoConfirmar;
    private javax.swing.JComboBox<String> ComboBoxCliente;
    private javax.swing.JComboBox<String> ComboBoxTipoServico;
    private javax.swing.JLabel IconeCancelar;
    private javax.swing.JLabel IconeConfirmar;
    private javax.swing.JLabel IdServicoTitulo;
    private javax.swing.JTextField InputCustoPecas;
    private javax.swing.JTextArea InputObservacao;
    private javax.swing.JTextField InputValor;
    private javax.swing.JLabel LabelCliente;
    private javax.swing.JLabel LabelCustoPecas;
    private javax.swing.JLabel LabelObservacao;
    private javax.swing.JLabel LabelTipoServico;
    private javax.swing.JLabel LabelValor;
    private javax.swing.JLabel MoedaCustoPeca;
    private javax.swing.JLabel MoedaValor;
    private javax.swing.JLabel Titulo;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
    
    public void exibirMensagem(String mensagemExibida){
        JOptionPane.showMessageDialog(this, mensagemExibida);
    }
    
    public JToggleButton getBotaoEdiar() {
        return BotaoConfirmar;
    }

    public void setBotaoEdiar(JToggleButton BotaoEdiar) {
        this.BotaoConfirmar = BotaoEdiar;
    }

    public JToggleButton getBotaoExcluir() {
        return BotaoCancelar;
    }

    public void setBotaoExcluir(JToggleButton BotaoExcluir) {
        this.BotaoCancelar = BotaoExcluir;
    }

    public Servico getEditandoServico() {
        return editandoServico;
    }

    public void setEditandoServico(Servico editandoServico) {
        this.editandoServico = editandoServico;
    }

    public JComboBox<String> getComboBoxCliente() {
        return ComboBoxCliente;
    }

    public void setComboBoxCliente(JComboBox<String> ComboBoxCliente) {
        this.ComboBoxCliente = ComboBoxCliente;
    }

    public JComboBox<String> getComboBoxTipoServico() {
        return ComboBoxTipoServico;
    }

    public void setComboBoxTipoServico(JComboBox<String> ComboBoxTipoServico) {
        this.ComboBoxTipoServico = ComboBoxTipoServico;
    }

    public JLabel getIdServicoTitulo() {
        return IdServicoTitulo;
    }

    public void setIdServicoTitulo(JLabel IdServicoTitulo) {
        this.IdServicoTitulo = IdServicoTitulo;
    }

    public JTextField getInputCustoPecas() {
        return InputCustoPecas;
    }

    public void setInputCustoPecas(JTextField InputCustoPecas) {
        this.InputCustoPecas = InputCustoPecas;
    }

    public JTextArea getInputObservacao() {
        return InputObservacao;
    }

    public void setInputObservacao(JTextArea InputObservacao) {
        this.InputObservacao = InputObservacao;
    }

    public JTextField getInputValor() {
        return InputValor;
    }

    public void setInputValor(JTextField InputValor) {
        this.InputValor = InputValor;
    }

    public Costureira getCostureiraLogada() {
        return costureiraLogada;
    }

    public void setCostureiraLogada(Costureira costureiraLogada) {
        this.costureiraLogada = costureiraLogada;
    }
    
    

    
}
