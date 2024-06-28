
package Controller.Helper;

import DAO.ClienteDAO;
import DAO.TipoServicoDAO;
import Model.Cliente;
import Model.Exceptions.CampoNuloException;
import Model.Servico;
import Model.StatusServico;
import Model.TipoServico;
import View.EditarServico;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;

public class EditarServicoHelper {
    EditarServico view;
    

    public EditarServicoHelper(EditarServico view) {
        this.view = view;
    }
    
    public void limparInputs(){
        view.getComboBoxCliente().setSelectedIndex(0);
        view.getComboBoxTipoServico().setSelectedIndex(0);
        view.getInputValor().setText("");
        view.getInputCustoPecas().setText("");
        view.getInputObservacao().setText("");
    }
    
    public void atualizarServico(Servico servico) throws CampoNuloException{
        isInputsNulos();
        
        Cliente cliente = getCliente();
        String tipoServico = getTipo();
        double valor = getValor();
        double custoPecas = getCustoPecas();
        String observacao = getObservacao();
        
        servico.setCliente(cliente);
        servico.setTipo(tipoServico);
        servico.setValor(valor);
        servico.setCustoPecas(custoPecas);
        servico.setObservacao(observacao);
    }
    
    public void preencherInputsServico(Servico servico){
        
        setComboBoxCliente(servico.getCliente().toString());
        setComboBoxTipoServico(servico.getTipo());
        setValor(servico.getValor() + "");
        setCustoPecas(servico.getCustoPecas() + "");
        setObservacao(servico.getObservacao());
        
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
    
    public Cliente getCliente(){
        String idCliente = ((String)view.getComboBoxCliente().getSelectedItem()).split(" ")[0];
        int id = Integer.parseInt(idCliente);
        return new Cliente(id, "", "", "", "");
    }
    
    public String getTipo(){
        return ((String)view.getComboBoxTipoServico().getSelectedItem());
    }
    
    public double getValor() throws CampoNuloException, NumberFormatException{
        String valorString =  view.getInputValor().getText().replace(",", ".");
        try{
            return Double.parseDouble( valorString );
        }catch(NumberFormatException e){
            throw new NumberFormatException("Campo VALOR inválido!");
        }
    }
    
    public double getCustoPecas() throws NumberFormatException{
        String custoPecasString = view.getInputCustoPecas().getText().replace(",", ".");
        if(custoPecasString.equals("")){
            return 0;
        }
        try{
            double custoPecas = Double.parseDouble(custoPecasString);
            return custoPecas;
        }catch(NumberFormatException e){
            throw new NumberFormatException("Campo CUSTO PECAS inválido!");
        }
    }
    
    public String getObservacao(){
        return view.getInputObservacao().getText();
    }
    
    public void isInputsNulos() throws CampoNuloException{
        if(view.getComboBoxCliente().getSelectedIndex() == 0){
            throw new CampoNuloException("CLIENTE é um campo obrigatório!");
        }
        if(view.getComboBoxTipoServico().getSelectedIndex() == 0){
            throw new CampoNuloException("TIPO DE SERVICO é um campo obrigatório!");
        }
        if(view.getInputValor().getText().isEmpty()){
            throw new CampoNuloException("VALOR é um campo obrigatório!");
        }

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
    
}
