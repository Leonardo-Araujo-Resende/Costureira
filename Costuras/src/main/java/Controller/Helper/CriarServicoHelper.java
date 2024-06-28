
package Controller.Helper;

import DAO.ServicoDAO;
import Model.Cliente;
import Model.Costureira;
import Model.Exceptions.CampoNuloException;
import Model.Servico;
import Model.StatusServico;
import Model.TipoServico;
import View.CriarServico;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class CriarServicoHelper {
    
    CriarServico view;

    public CriarServicoHelper(CriarServico viewServico) {
        this.view = viewServico;
    }
    
    public void preencherClientesComboBox(ArrayList<Cliente> clientes){
        DefaultComboBoxModel comboBoxModel =  (DefaultComboBoxModel) view.getComboBoxCliente().getModel();
        
        for(Cliente c: clientes){
            comboBoxModel.addElement(c.toString());
        } 
    }
    
    public void preencherTipoServicosComboBox(ArrayList<TipoServico> tipoServicos){
        DefaultComboBoxModel comboBoxModel =  (DefaultComboBoxModel) view.getComboBoxTipoServico().getModel();
        
        for(TipoServico t: tipoServicos){
            comboBoxModel.addElement(t.getTipo());
        } 
    }
    
    public Servico recuperaServico() throws NumberFormatException, CampoNuloException{
        isInputsNulos();
        
        String tipoServico = getTipoServico();
        Costureira costureira = view.getCostureiraLogada();
        Cliente cliente = getCliente();
        double valor = getValor();
        double custoPecas = getCustoPecas();
        String dataPedido = "";
        String dataEntrega = "";
        String observacao = getObservacao();
        StatusServico statusServico = StatusServico.PEDIDO;
        
        
        Servico servico = new Servico(0, tipoServico, costureira, cliente, valor, custoPecas, dataPedido, dataEntrega, observacao, statusServico);
        return servico;
    }
    
    public Cliente getCliente() throws NumberFormatException{
        String idString = ((String)view.getComboBoxCliente().getSelectedItem()).split(" ")[0];
        int id = Integer.parseInt(idString);
        return new Cliente(id, "", "", "", "");
    }
    
    public String getTipoServico(){
        return ((String)view.getComboBoxTipoServico().getSelectedItem());
    }
    
    public double getValor() throws NumberFormatException{
        try{
            
            double valor = Double.parseDouble(view.getInputValor().getText().replace(",", ".") );
            return valor;
            
        }catch(NumberFormatException e){
            throw new NumberFormatException("Campo valor deve ser um número!");
        }
    }
    
    public double getCustoPecas() throws NumberFormatException{
        try{
            
            String custoPecasString = view.getInputCustoPecas().getText().replace(",", ".");
            if(custoPecasString.equals("")) return 0;
            return Double.parseDouble( custoPecasString );

        }catch(NumberFormatException e){
            throw new NumberFormatException("Campo custo das peças deve ser um número!");
        }
    }
    
    public String getObservacao(){
       return view.getInputObservacao().getText();
        
    }
    
    public void setComboBoxCliente(String cliente){
        view.getComboBoxCliente().setSelectedItem(cliente);
    }
    
    public void setComboBoxTipoServico(String tipoServico){
        view.getComboBoxTipoServico().setSelectedItem(tipoServico);
    }
    
    public void setValor(String valor){
        view.getInputValor().setText( valor );
    }
    
    public void setCustoPecas(String custoPecas){
        view.getInputCustoPecas().setText( custoPecas );
    }
    
    public void setObservacao(String observacao){
        view.getInputObservacao().setText(observacao);
    }
    
    public void limparInputs(){
        setComboBoxCliente(" ");
        setComboBoxTipoServico(" ");
        setValor("");
        setCustoPecas("");
        setObservacao("");
    }
    
    public void atualizaTabela(){
        DefaultTableModel tableModel =  (DefaultTableModel) view.getTabelaServico().getModel();
        ArrayList<Servico> servicos =  ServicoDAO.retornaTodosServicoDeCostureira(view.getCostureiraLogada());
        
        tableModel.setNumRows(0);
        
        // Cria um renderizador para alinhar todas as colunas à esquerda
        DefaultTableCellRenderer leftRenderer = new DefaultTableCellRenderer();
        leftRenderer.setHorizontalAlignment(SwingConstants.CENTER);

        // Define o renderizador para cada coluna da tabela
        for (int columnIndex = 0; columnIndex < tableModel.getColumnCount(); columnIndex++) {
            view.getTabelaServico().getColumnModel().getColumn(columnIndex).setCellRenderer(leftRenderer);
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
    
    public void isInputsNulos() throws CampoNuloException{
        if(view.getComboBoxCliente().getSelectedIndex() == 0){
            throw new CampoNuloException("CLIENTE é um campo obrigatório!");
        }
        if(view.getComboBoxTipoServico().getSelectedIndex() == 0){
            throw new CampoNuloException("TIPO DE SERVICO é um campo obrigatório!");
        }
        if(view.getInputValor().getText().equals("")){
            throw new CampoNuloException("VALOR é um campo obrigatório!");
        }

    }
    
    
    
}
