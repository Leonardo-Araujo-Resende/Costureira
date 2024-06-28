package Controller.Helper;

import DAO.ClienteDAO;
import Model.Cliente;
import Model.Exceptions.CampoNuloException;
import View.CriarCliente;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

public class CriarClienteHelper {

    private final CriarCliente view;

    public CriarClienteHelper(CriarCliente criarCliente) {
        this.view = criarCliente;
    }

    public Cliente recuperarCliente() throws CampoNuloException {
        verificaValoresObrigatoriosPreenchidos();
        
        String nome = getNome();
        String telefone = getTelefone();
        String endereco = getEndereco();
        String observacao = getObservacao();

        Cliente cliente = new Cliente(0, nome, telefone, endereco, observacao);

        return cliente;
    }
    
    public void verificaValoresObrigatoriosPreenchidos() throws CampoNuloException {
        if (getNome().equals("")) {
            throw new CampoNuloException("Preencha o campo NOME");
        }
        
        if (getTelefone().equals("")) {
            throw new CampoNuloException("Preencha o campo TELEFONE");
        }
    }

    public void limparInputs() {
        setNome("");
        setTelefone("");
        setEndereco("");
        setObservacao("");
    }

    public void atualizaTabela(ArrayList<Cliente> clientes) {
        DefaultTableModel tableModel = (DefaultTableModel) view.getTabelaClientes().getModel();

        tableModel.setNumRows(0);

        for (Cliente cliente : clientes) {
            tableModel.addRow(new Object[]{
                cliente.getId(),
                cliente.getNome(),
                cliente.getTelefone(),
                cliente.getEndereco(),
                cliente.getObservacao()
            });
        }
    }

    public String getNome(){
        return view.getInputNome().getText();
    }

    public String getTelefone(){
        return view.getInputTelefone().getText();
    }

    public String getEndereco() {
        return view.getInputEndereco().getText();
    }

    public String getObservacao() {
        return view.getInputObservacao().getText();
    }

    
    public void setNome(String nome) {
        view.getInputNome().setText(nome);
    }

    public void setTelefone(String telefone) {
        view.getInputTelefone().setText(telefone);
    }

    public void setEndereco(String endereco) {
        view.getInputEndereco().setText(endereco);
    }

    public void setObservacao(String observacao) {
        view.getInputObservacao().setText(observacao);
    }

}
