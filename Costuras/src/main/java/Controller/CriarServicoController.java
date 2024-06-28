
package Controller;

import Controller.Helper.CriarServicoHelper;
import DAO.ClienteDAO;
import DAO.ServicoDAO;
import DAO.TipoServicoDAO;
import Model.Cliente;
import Model.Exceptions.CampoNuloException;
import Model.Servico;
import Model.TipoServico;
import View.CriarServico;
import java.util.ArrayList;

public class CriarServicoController {
    
    private final CriarServico view;
    private final CriarServicoHelper helper;

    public CriarServicoController(CriarServico viewServico) {
        this.view = viewServico;
        this.helper = new CriarServicoHelper(viewServico);
    }
    
    public void atualizarComboBoxCliente(){
        ArrayList<Cliente> clientes =  ClienteDAO.retornaTodosClientes();
        helper.preencherClientesComboBox(clientes);
    }
    
    public void criarServico(){
        try{
            
            Servico servico;
            servico = helper.recuperaServico();
            servico.setCliente( retornaCliente(servico.getCliente().getId()) );
            ServicoDAO.salvarServico(servico);
            atualizarTabelaServico();
            helper.limparInputs();
            
        }catch(CampoNuloException |NumberFormatException e){
            view.exibirMensagem(e.getMessage());
        }
    }
    
    public void atualizarComboBoxTipoServico(){
       ArrayList<TipoServico> tipoServicos = TipoServicoDAO.recuperarServicosDeCostureira(view.getCostureiraLogada());
       helper.preencherTipoServicosComboBox(tipoServicos);
    }
    
    public void atualizarTabelaServico(){
        helper.atualizaTabela();
    }
    

    public Cliente retornaCliente(int id){
        return ClienteDAO.retornaClientePorId(id);
    }
    
    
    
}
