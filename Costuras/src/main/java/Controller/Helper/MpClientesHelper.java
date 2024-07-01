package Controller.Helper;

import DAO.ClienteDAO;
import DAO.ServicoDAO;
import Model.Cliente;
import Model.Costureira;
import Model.Servico;
import View.MenuPrincipal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class MpClientesHelper {

    MenuPrincipal view;
    private boolean isMudandoComboBoxCliente;

    public MpClientesHelper(MenuPrincipal view) {
        this.view = view;
    }

    public void atualizaTabela() {
        Cliente cliente = pegaClienteSelecionado();
        if(cliente == null) return;

        DefaultTableModel tableModel = (DefaultTableModel) view.getTabelaServicosClientes().getModel();
        ArrayList<Servico> servicos = ServicoDAO.retornaTodosServicoDeCliente(cliente);

        tableModel.setNumRows(0);

        // Cria um renderizador para alinhar todas as colunas à esquerda
        DefaultTableCellRenderer leftRenderer = new DefaultTableCellRenderer();
        leftRenderer.setHorizontalAlignment(SwingConstants.CENTER);

        // Define o renderizador para cada coluna da tabela
        for (int columnIndex = 0; columnIndex < tableModel.getColumnCount(); columnIndex++) {
            view.getTabelaServicosClientes().getColumnModel().getColumn(columnIndex).setCellRenderer(leftRenderer);
        }

        for (Servico servico : servicos) {
            tableModel.addRow(new Object[]{
                servico.getId(),
                servico.getStatus(),
                servico.getTipo(),
                servico.getValor(),
                servico.getCustoPecas(),
                servico.getDataPedido(),
                servico.getDataEntrega(),
                servico.getObservacao(),
                servico.getCostureira().getId() + " - " + servico.getCostureira().getNome(),});
        }
    }

    public void preencherClientesComboBox(ArrayList<Cliente> clientes) {
        isMudandoComboBoxCliente = true;
        
        view.getComboBoxCliente().removeAllItems();        
        DefaultComboBoxModel comboBoxModel = (DefaultComboBoxModel) view.getComboBoxCliente().getModel();

        for (Cliente c : clientes) {
            comboBoxModel.addElement(c.getId() + " - " + c.getNome() + " - " + c.getTelefone());
        }
        view.getComboBoxCliente().repaint();
        view.getComboBoxCliente().revalidate();
        isMudandoComboBoxCliente = false;
    }

    public Cliente pegaClienteSelecionado() {
        if(view.getComboBoxCliente().getItemCount()== 0) return null;
        
        String a = ((String) view.getComboBoxCliente().getSelectedItem()).split(" ")[0];
        return ClienteDAO.retornaClientePorId(Integer.parseInt(a));
    }

    public void atualizarLabels() {
        Cliente cliente = pegaClienteSelecionado();
        if(cliente == null) return;
        
        try {
            ResultSet rs = ServicoDAO.retornaEstatisticasServicoClienteCostureira(cliente.getId(), view.getCostureiraLogada().getId());

            //Dados cliente
            view.getIdLabel().setText("" + cliente.getId());
            view.getNomeLabel().setText(cliente.getNome());
            view.getTelefoneLabel().setText("Telefone: " + cliente.getTelefone());
            view.getEnderecoLabel().setText("Endereço: " + cliente.getEndereco());

            //Dados gerados
            if (rs.next()) {
                view.getQntServicoLabel().setText("Quantidade de Serviços: " + rs.getInt("qnt_servicos"));
                view.getValorTotalLabel().setText("Valor total: " + rs.getDouble("valor_total"));
                view.getMediaValorLabel().setText("Média valor: " + rs.getDouble("media_valor"));
            }
            
            String tipoPreferido = ServicoDAO.retornaTipoServicoPreferidoDoCliente( pegaClienteSelecionado());
            view.getTipoPrefLabel().setText("Tipo preferido: " +  tipoPreferido );
            
            Costureira costureiraPref = ServicoDAO.retornaCostureiraPreferidaDoCliente(pegaClienteSelecionado());
            if(costureiraPref != null){
                view.getCostureiraPrefLabel().setText("Costureira preferida: " + costureiraPref.getNome() );
            }

        } catch (SQLException ex) {
            Logger.getLogger(MpClientesHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public boolean isIsMudandoComboBoxCliente() {
        return isMudandoComboBoxCliente;
    }

    public void setIsMudandoComboBoxCliente(boolean isMudandoComboBoxCliente) {
        this.isMudandoComboBoxCliente = isMudandoComboBoxCliente;
    }
    
    
}
