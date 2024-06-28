
package Controller.Helper;

import Model.Cliente;
import Model.Exceptions.CampoNuloException;
import View.EditarCliente;

public class EditarClienteHelper {
    private EditarCliente view;

    public EditarClienteHelper(EditarCliente view) {
        this.view = view;
    }
    
    public Cliente recuperarCliente() throws CampoNuloException{
        int id = Integer.parseInt(getId());
        String nome = getNome();
        String telefone = getTelefone();
        String endereco = getEndereco();
        String observacao = getObservacao();
        
        return new Cliente(id, nome, telefone, endereco, observacao);
    }
    
    public void preencherInputCliente(Cliente cliente){
        setNome(cliente.getNome());
        setTelefone(cliente.getTelefone());
        setEndereco(cliente.getEndereco());
        setObservacao(cliente.getObservacao());
    }
    
    public void setNome(String nome){
        view.getInputNome().setText(nome);
    }
    public void setTelefone(String telefone){
        view.getInputTelefone().setText(telefone);
    }
    public void setEndereco(String endereco){
        view.getInputEndereco().setText(endereco);
    }
    public void setObservacao(String observacao){
        view.getInputObservacao().setText(observacao);
    }
    
    public String getNome() throws CampoNuloException{
        String nome = view.getInputNome().getText();
        if(nome.isEmpty()){
            throw new CampoNuloException("Campo NOME não pode estar vázio!");
        }
        return nome;
    }
    
    public String getTelefone() throws CampoNuloException{
        String telefone = view.getInputTelefone().getText();
        if(telefone.isEmpty()){
            throw new CampoNuloException("Campo TELEFONE não pode estar vázio!");
        }
        return telefone;
    }
    
    public String getEndereco(){
        return view.getInputEndereco().getText();
    }
    
    public String getObservacao(){
        return view.getInputObservacao().getText();
    }
    
    public String getId(){
        return view.getIdClienteTitulo().getText();
    }
}
