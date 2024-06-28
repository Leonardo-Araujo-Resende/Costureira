
package Controller.Helper;

import DAO.ServicoDAO;
import Model.Servico;
import Model.StatusServico;
import View.MenuPrincipal;
import java.util.ArrayList;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class MpEditarServicoHelper {
    private MenuPrincipal view;

    public MpEditarServicoHelper(MenuPrincipal view) {
        this.view = view;
    }
    
    
    public void atualizaTabela(ArrayList<Servico> servicos){
        DefaultTableModel tableModel =  (DefaultTableModel) view.getTabelaEditarServicos().getModel();
        
        tableModel.setNumRows(0);
        
        // Cria um renderizador para alinhar todas as colunas aonde quiser
        DefaultTableCellRenderer leftRenderer = new DefaultTableCellRenderer();
        leftRenderer.setHorizontalAlignment(SwingConstants.CENTER);

        // Define o renderizador para cada coluna da tabela
        for (int columnIndex = 0; columnIndex < tableModel.getColumnCount(); columnIndex++) {
            view.getTabelaEditarServicos().getColumnModel().getColumn(columnIndex).setCellRenderer(leftRenderer);
        }
        
        for(Servico servico: servicos){
            tableModel.addRow(new Object[]{
            servico.getId(),
            servico.getCliente().getId() + " - " + servico.getCliente().getNome(),
            servico.getStatus(),
            servico.getTipo(),
            servico.getValor(),
            servico.getCustoPecas(),
            servico.getDataPedido(),
            servico.getDataEntrega(),
            servico.getObservacao()
        });
        }
    }
    
    public String recuperarStringComboBoxStatusServico(){
        return view.getComboBoxStatus().getSelectedItem().toString();
    }
    
    public int [] recuperaIdSelecionados(){
        int[] linhasSelecionadas = view.getTabelaEditarServicos().getSelectedRows();
        int[] idSelecionados = new int[linhasSelecionadas.length];
        
        int cont = 0;
        
        for(int i : linhasSelecionadas){
            int id = (int)(view.getTabelaEditarServicos().getValueAt(i, 0));
            idSelecionados[cont] = id;
            cont ++;
        }
        return idSelecionados;
    }

    
}
