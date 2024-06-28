package Controller.Helper;

import DAO.CostureiraDAO;
import Model.Costureira;
import Model.Exceptions.CampoNuloException;
import Model.Exceptions.CostureiraJaExisteException;
import View.Login;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LoginHelper {
    private Login view;

    public LoginHelper(Login loginView) {
        this.view = loginView;
    }
    
    public Costureira recuperarInputs() throws CampoNuloException{
        verificaInputsVazios();
        
        String login = getUsuario();
        String senha = getSenha();
        
        Costureira costureira = new Costureira(0, "", login, senha);
               
        return costureira;
    }
    
    public void limparTela(){
        setLogin("");
        setSenha("");
    }
    
    public void verificaInputsVazios() throws CampoNuloException{
        if(getUsuario().isEmpty()){
            throw new CampoNuloException("Preencha o campo USUARIO!");
        }
        if(getSenha().isEmpty()){
            throw new CampoNuloException("Preencha o campo SENHA!");
        }
    }
    
    public String getUsuario(){
        return view.getInputLogin().getText();
    }
    
    public String getSenha(){
        return new String(view.getInputSenha().getPassword());
    }
    
    public void setLogin(String login){
        view.getInputLogin().setText(login);
    }
    
    public void setSenha(String senha){
        view.getInputSenha().setText(senha);
    }
}
