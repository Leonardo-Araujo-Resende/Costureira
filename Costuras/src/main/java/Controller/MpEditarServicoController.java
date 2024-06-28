
package Controller;

import Controller.Helper.MpEditarServicoHelper;
import DAO.ServicoDAO;
import Model.Servico;
import Model.StatusServico;
import View.EditarServico;
import View.MenuPrincipal;
import javax.swing.JOptionPane;


public class MpEditarServicoController {
    private MenuPrincipal view;
    private MpEditarServicoHelper helper;

    public MpEditarServicoController(MenuPrincipal view) {
        this.view = view;
        this.helper = new MpEditarServicoHelper(view);
    }
    
    
    public void atualizaTabela(){
        if(helper.recuperarStringComboBoxStatusServico().equals("TODOS")){
            atualizaTabelaTodos();
        }else{
            atualizaTabelaStatus();
        }
    } 
    
    private void atualizaTabelaTodos(){
        helper.atualizaTabela(ServicoDAO.retornaTodosServicoDeCostureira(view.getCostureiraLogada()));
    }
    
    private void atualizaTabelaStatus(){
        helper.atualizaTabela(ServicoDAO.retornaTodosServicoStatus(view.getCostureiraLogada(), StatusServico.valueOf(helper.recuperarStringComboBoxStatusServico())));
    }
    
    public void atualizaStatusServicoTabela(String statusServico){
        int[] idSelecionados = helper.recuperaIdSelecionados();
        
        if(idSelecionados.length == 0){
            view.exibirMensagem("Nenhum item da tabela selecionado!");
            return;
        }
        
        for( int i : idSelecionados){
            
            if(statusServico.equals(StatusServico.ENTREGUE.name())){
                Servico servico = ServicoDAO.retornaServicoPorId(i);
                servico.setServicoEntregue();
                ServicoDAO.atualizaServico(servico);
            }
            
            ServicoDAO.atualizaStatusServicoPorId( i, StatusServico.valueOf(statusServico ));
        }
        
        atualizaTabela();
    }
    

    
    public void deletarServicoSelecionado(){
        int[] idSelecionados = helper.recuperaIdSelecionados();
        
        if(idSelecionados.length == 0){
            view.exibirMensagem("Selecione um serviço para apagar!");
            return;
        }
        if(idSelecionados.length > 1){
            view.exibirMensagem("Só é possível apagar um serviço por vez!");
            return;
        }
        
        int opcao = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja apagar o serviço?", "Confirmação", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE);

        if (opcao == JOptionPane.YES_OPTION) {
            ServicoDAO.excluirStatusPorId(idSelecionados[0]);
            atualizaTabela();
        } else if (opcao == JOptionPane.NO_OPTION) {
            view.exibirMensagem("Ação cancelada!");
        } 
        
    }
    
    public void criarTelaEditarServico(){
        int[] idSelecionados = helper.recuperaIdSelecionados();
        
        if(idSelecionados.length == 0){
            view.exibirMensagem("Selecione um item para editar!");
            return;
        }
        else if(idSelecionados.length > 1){
            view.exibirMensagem("Mais de um item selecionado!");
            return;
        }
        
        
        EditarServico menu = new EditarServico(view.getCostureiraLogada(), ServicoDAO.retornaServicoPorId(idSelecionados[0]));
        menu.setVisible(true);
    }
    
    

}
