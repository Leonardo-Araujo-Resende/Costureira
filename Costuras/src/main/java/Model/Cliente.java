
package Model;

import DAO.ClienteDAO;


public class Cliente extends Pessoa{
    
    private String telefone;
    private String endereco;
    private String observacao;

    public Cliente(int id,  String nome, String telefone, String endereco, String observacao) {
        super(nome, id);
        this.telefone = telefone;
        this.endereco = endereco;
        this.observacao = observacao;
    }
    
    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    @Override
    public String toString() {
        return getId() + " - " + getNome() + " " + getTelefone();
    }

    public boolean equals(Cliente cliente) {
        return super.equals(cliente) && getTelefone().equals(cliente.getTelefone())
                && getEndereco().equals(cliente.getEndereco()) && getObservacao().equals(cliente.getObservacao());
    }
        
}
