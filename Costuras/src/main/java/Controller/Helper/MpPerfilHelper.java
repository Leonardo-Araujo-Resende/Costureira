
package Controller.Helper;


import DAO.ServicoDAO;
import Model.Servico;
import View.MenuPrincipal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;


public class MpPerfilHelper {
    private MenuPrincipal view;

    public MpPerfilHelper(MenuPrincipal view) {
        this.view = view;
    }
    
    public void atualizaTabelaStatusPedido() {
        DefaultTableModel tableModel =  (DefaultTableModel) view.getTabelaStatus().getModel();
        
        // Cria um renderizador para alinhar todas as colunas aonde quiser
        DefaultTableCellRenderer leftRenderer = new DefaultTableCellRenderer();
        leftRenderer.setHorizontalAlignment(SwingConstants.CENTER);

        // Define o renderizador para cada coluna da tabela
        for (int columnIndex = 0; columnIndex < tableModel.getColumnCount(); columnIndex++) {
            view.getTabelaStatus().getColumnModel().getColumn(columnIndex).setCellRenderer(leftRenderer);
        }

        ResultSet rs = ServicoDAO.retornaEstatisticasStatusPedido(view.getCostureiraLogada());
        
        tableModel.setNumRows(0);
        
        try {
            while(rs.next()){
                tableModel.addRow(new Object[]{
                    rs.getString("status"),
                    rs.getInt("qnt"),
                    rs.getDouble("valor_total")
                });
            }
        } catch (SQLException ex) {
            Logger.getLogger(MpPerfilHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void atualizaTabelaTipoPedido() {
        DefaultTableModel tableModel =  (DefaultTableModel) view.getTabelaTIpo().getModel();
        
        // Cria um renderizador para alinhar todas as colunas aonde quiser
        DefaultTableCellRenderer leftRenderer = new DefaultTableCellRenderer();
        leftRenderer.setHorizontalAlignment(SwingConstants.CENTER);

        // Define o renderizador para cada coluna da tabela
        for (int columnIndex = 0; columnIndex < tableModel.getColumnCount(); columnIndex++) {
            view.getTabelaTIpo().getColumnModel().getColumn(columnIndex).setCellRenderer(leftRenderer);
        }

        ResultSet rs = ServicoDAO.retornaEstatisticasTipoPedido(view.getCostureiraLogada());
        
        tableModel.setNumRows(0);
        
        try {
            while(rs.next()){
                tableModel.addRow(new Object[]{
                    rs.getString("tipo"),
                    rs.getInt("qnt"),
                    rs.getDouble("valor_receber")
                });
            }
        } catch (SQLException ex) {
            Logger.getLogger(MpPerfilHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void atualizaTabelaPorMes() {
        DefaultTableModel tableModel =  (DefaultTableModel) view.getTabelaMes().getModel();
        
        // Cria um renderizador para alinhar todas as colunas aonde quiser
        DefaultTableCellRenderer leftRenderer = new DefaultTableCellRenderer();
        leftRenderer.setHorizontalAlignment(SwingConstants.CENTER);

        // Define o renderizador para cada coluna da tabela
        for (int columnIndex = 0; columnIndex < tableModel.getColumnCount(); columnIndex++) {
            view.getTabelaMes().getColumnModel().getColumn(columnIndex).setCellRenderer(leftRenderer);
        }

        ResultSet rs = ServicoDAO.retornaEstatisticasPorMes();
        
        tableModel.setNumRows(0);
        
        try {
            while(rs.next()){
                tableModel.addRow(new Object[]{
                    rs.getString("mes_ano"),
                    rs.getInt("qnt"),
                    rs.getDouble("valor_receber")
                });
            }
        } catch (SQLException ex) {
            Logger.getLogger(MpPerfilHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void atualizaLabels(){
        view.getNomeLabelCost().setText( view.getCostureiraLogada().getNome() );
        view.getIdLabelCost().setText( view .getCostureiraLogada().getId() + "");
        view.getLoginLabelCost().setText("Login: " + view.getCostureiraLogada().getLogin() );
        view.getSenhaLabelCost().setText("Senha: " + "*".repeat(view.getCostureiraLogada().getSenha().length()) );
    }
    
}
