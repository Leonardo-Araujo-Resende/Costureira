
package Controller.Helper;

import DAO.TipoServicoDAO;
import Model.Exceptions.CampoNuloException;
import Model.TipoServico;
import View.CriarTipoServico;
import java.util.ArrayList;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class CriarTipoServicoHelper {
    
    CriarTipoServico view;

    public CriarTipoServicoHelper(CriarTipoServico view) {
        this.view = view;
    }
    
    public TipoServico recuperarTipoServico() throws NumberFormatException, CampoNuloException{
        verificaValoresVazios();
        
        String tipo = getTipo();
        double valor = getValor();
        String observacao = getObservacao();
        
        TipoServico tipoServico = new TipoServico( tipo, valor, observacao, view.getCostureiraLogada());
        return tipoServico;
    }
    
    public void limparInputs(){
        view.getInputTipo().setText("");
        view.getInputValor().setText("");
        view.getInputObservacao().setText("");
    }
    
    public void setTipo(String tipo){
        view.getInputTipo().setText(tipo);
    }
    
    public void setValor(String valor){
        view.getInputValor().setText( valor );
    }
    
    public void setObservacao(String observacao){
        view.getInputObservacao().setText(observacao);
    }
    
    public String getTipo(){
        return view.getInputTipo().getText();
    }
    
    public double getValor() throws NumberFormatException{
        try{
            return Double.parseDouble(view.getInputValor().getText());
        }catch(NumberFormatException e){
            throw new NumberFormatException("Valor inválido");
        }
        
    }
    
    public String getObservacao(){
        return view.getInputObservacao().getText();
    }
    
    public void verificaValoresVazios() throws CampoNuloException{
        if(view.getInputTipo().getText().equals("")){
            throw new CampoNuloException("Preencha o campo TIPO");
        }
         if(view.getInputValor().getText().equals("")){
            throw new CampoNuloException("Preencha o campo VALOR");
        }
    }
    
    public void atualizaTabela(){
        DefaultTableModel tableModel =  (DefaultTableModel) view.getTabelaTipoServico().getModel();
        ArrayList<TipoServico> tipoServicos =  TipoServicoDAO.recuperarServicosDeCostureira(view.getCostureiraLogada());
        
        tableModel.setNumRows(0);
        
        // Cria um renderizador para alinhar todas as colunas à esquerda
        DefaultTableCellRenderer leftRenderer = new DefaultTableCellRenderer();
        leftRenderer.setHorizontalAlignment(SwingConstants.CENTER);

        // Define o renderizador para cada coluna da tabela
        for (int columnIndex = 0; columnIndex < tableModel.getColumnCount(); columnIndex++) {
            view.getTabelaTipoServico().getColumnModel().getColumn(columnIndex).setCellRenderer(leftRenderer);
        }
        
        for(TipoServico tipoServico: tipoServicos){
            tableModel.addRow(new Object[]{
            tipoServico.getTipo(),
            tipoServico.getValor(),
            tipoServico.getObservacao(),
        });
        }
    }
    
}
