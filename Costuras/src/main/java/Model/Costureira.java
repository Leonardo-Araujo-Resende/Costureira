
package Model;

import java.util.Objects;

public class Costureira extends Pessoa{
    
    private String login;
    private String senha;

    public Costureira(int id, String nome, String login, String senha) {
        super(nome, id);
        this.login = login;
        this.senha = senha;
    }
        

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public String toString() {
        return "Costureira{ nome=" + getNome() + " id=" + getId()  + " login=" + login + ", senha=" + senha + '}';
    }


    public boolean equals(Costureira costureira){
        return super.equals(costureira) && getId() == costureira.getId() && getNome().equals(costureira.getNome()) &&
                getLogin().equals(costureira.getLogin()) && getSenha().equals(costureira.getSenha());
    }
    
    
    
}
