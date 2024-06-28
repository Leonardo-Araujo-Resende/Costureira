
package Controller;

import Controller.Helper.EditarServicoHelper;
import DAO.ClienteDAO;
import DAO.ServicoDAO;
import DAO.TipoServicoDAO;
import Model.Cliente;
import Model.Exceptions.CampoNuloException;
import Model.TipoServico;
import View.EditarServico;
import java.util.ArrayList;

public class EditarServicoController {
    EditarServico view;
    EditarServicoHelper helper;
    

    public EditarServicoController(EditarServico view) {
        this.view = view;
        helper = new EditarServicoHelper(view);
        initView();
    }
    
    public boolean editarServico(){
        
        try{
            helper.atualizarServico(view.getEditandoServico());
            ServicoDAO.atualizaServico(view.getEditandoServico());
            return true;
        }catch(CampoNuloException | NumberFormatException e){
            view.exibirMensagem(e.getMessage());
            return false;
        }
        
        
    }
    
    public void initView(){
        atualizarComboBoxCliente();
        atualizarComboBoxTipoServico();
        preencherInputsServico();
    }
    
    private void atualizarComboBoxTipoServico(){
       ArrayList<TipoServico> tipoServicos = TipoServicoDAO.recuperarServicosDeCostureira(view.getCostureiraLogada());
       helper.preencherTipoServicosComboBox(tipoServicos);
    }
    
    private void atualizarComboBoxCliente(){
        ArrayList<Cliente> clientes =  ClienteDAO.retornaTodosClientes();
        helper.preencherClientesComboBox(clientes);
    }
    
    private void preencherInputsServico(){
        helper.preencherInputsServico(view.getEditandoServico());
    }
    
        
}
