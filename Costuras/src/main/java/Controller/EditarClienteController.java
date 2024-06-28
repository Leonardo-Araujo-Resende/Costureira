
package Controller;

import Controller.Helper.EditarClienteHelper;
import DAO.ClienteDAO;
import Model.Cliente;
import Model.Exceptions.CampoNuloException;
import View.EditarCliente;

public class EditarClienteController {
    private EditarClienteHelper helper;
    private EditarCliente view;

    public EditarClienteController(EditarCliente view) {
        this.view = view;
        helper = new EditarClienteHelper(view);
    }
    
    
    public boolean editarCliente(){
        try{
            Cliente cliente = helper.recuperarCliente();            
            ClienteDAO.atualizarCliente( cliente );
            return true;
        }catch(CampoNuloException e){
            view.exibirMensagem(e.getMessage());
            return false;
        }
    }
    
    public void preencherInputs(){
        helper.preencherInputCliente( view.getClienteEditar() );
    }
}
