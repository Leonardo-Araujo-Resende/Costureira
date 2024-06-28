
package Model;

import java.util.Objects;

public abstract class Pessoa {
    
    private String nome;
    private int id;

    public Pessoa(String nome, int id) {
        this.nome = nome;
        this.id = id;
    }       

    

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    public boolean equals(Pessoa pessoa) {
        return getId() == pessoa.getId()&& getNome().equals(pessoa.getNome());           
    }
    
    
}
