package com.mycompany.costuras;

import Controller.ControllerMaster;
import DAO.ClienteDAO;
import DAO.CostureiraDAO;
import DAO.ServicoDAO;
import DAO.TipoServicoDAO;
import Model.Cliente;
import Model.Costureira;
import Model.Servico;
import Model.StatusServico;
import Model.TipoServico;
import View.Login;
import com.formdev.flatlaf.FlatDarkLaf;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Costuras {

    public static void main(String[] args) {
        
        /*
        Costureira cost = new Costureira(0,"Leonardo" , "leonardo" , "leo170303");
        CostureiraDAO.salvarCostureira(cost);
        
        Cliente cliente = new Cliente(0, "Karen", "3333-3333", "Rua Alvarenga Peixoto 20", "Cliente fiel");
        ClienteDAO.salvarCliente(cliente);
        
        Cliente cliente2 = new Cliente(0, "Gabriela", "4444-4444", "Rua Esequiel Dias 20", "Cliente iniciante");
        ClienteDAO.salvarCliente(cliente2);
        
        Servico servico  = new Servico(0, "Bainha", cost, cliente, 45.6, 5, "", "", "Calca preta jeans", StatusServico.PEDIDO);
        ServicoDAO.salvarServico(servico);
        
        Servico servico2  = new Servico(0, "Ziper", cost, cliente2, 50, 2,"", "", "Vestido festa", StatusServico.PRONTO_PARA_ENTREGA);
        ServicoDAO.salvarServico(servico2);
        */
        
        ControllerMaster.iniciarAplicacao();
        
        /*
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
        
        */
    }
}
