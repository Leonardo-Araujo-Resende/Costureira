
package Controller;

import Controller.Helper.MpClientesHelper;
import DAO.ClienteDAO;
import Model.Cliente;

import View.MenuPrincipal;


public class MpClientesController {
    
    MenuPrincipal view;
    MpClientesHelper helper;

    public MpClientesController(MenuPrincipal view) {
        this.view = view;
        helper = new MpClientesHelper(view);
    }
    
    
    public void atualizarComboBoxCliente(){
        helper.preencherClientesComboBox(ClienteDAO.retornaTodosClientes());
    }
    
    public void preencherTabelaServicos(){
        helper.atualizaTabela();
    }
    
    public void atualizarLabels(){
        helper.atualizarLabels();
    }
    
    
    public boolean isMudandoComboBoxCliente(){
        return helper.isIsMudandoComboBoxCliente();
    }
    
    public Cliente recuperarClienteSelecionado(){
        return helper.pegaClienteSelecionado();
    }
}
