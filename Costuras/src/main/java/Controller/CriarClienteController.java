
package Controller;

import Controller.Helper.CriarClienteHelper;
import DAO.ClienteDAO;
import Model.Cliente;
import Model.Exceptions.CampoNuloException;
import View.CriarCliente;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

public class CriarClienteController {
    private final CriarCliente view;
    private final CriarClienteHelper helper;

    public CriarClienteController(CriarCliente criarClienteView) {
        this.view = criarClienteView;
        this.helper = new CriarClienteHelper(criarClienteView);
        atualizaTabela();
    }
    
    public void criarCliente(){
        try{
            Cliente clienteSerAdicionado = helper.recuperarCliente();
            ClienteDAO.salvarCliente(clienteSerAdicionado);
            helper.limparInputs();
            atualizaTabela();
        }catch(CampoNuloException e){
            view.exibirMensagem(e.getMessage());
        }
        
    }
    
    public void atualizaTabela(){
        helper.atualizaTabela( ClienteDAO.retornaTodosClientes() );
    }
    
    
    
    
    
}
