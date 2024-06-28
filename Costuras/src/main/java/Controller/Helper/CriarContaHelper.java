package Controller.Helper;

import Model.Exceptions.CampoNuloException;
import Model.Costureira;
import Model.Exceptions.SenhasDiferentesException;
import View.CriarConta;

public class CriarContaHelper {

    CriarConta view;

    public CriarContaHelper(CriarConta view) {
        this.view = view;
    }

    public Costureira recuperarCostureira() throws CampoNuloException, SenhasDiferentesException {
        verificaValoresObrigatoriosPreenchidos();
        verificaSenhasIguais();
        
        String nome = getNome();
        String usuario = getUsuario();
        String senha = getSenha();

        return new Costureira(0, nome, usuario, senha);
    }

    public void limparInputs() {
        setNome("");
        setUsuario("");
        setSenha("");
        setConfirmacaoSenha("");
    }

    public void verificaValoresObrigatoriosPreenchidos() throws CampoNuloException {
        if (getNome().isEmpty()) {
            throw new CampoNuloException("Campo NOME deve ser preenchido");
        }
        if (getUsuario().isEmpty()) {
            throw new CampoNuloException("Campo USUARIO deve ser preenchido");
        }
        if (getSenha().isEmpty()) {
            throw new CampoNuloException("Campo SENHA deve ser preenchido");
        }
        if (getConfirmacaoSenha().isEmpty()) {
            throw new CampoNuloException("Campo CONFIRMAR SENHA deve ser preenchido");
        }
    }

    public void verificaSenhasIguais() throws SenhasDiferentesException {
        if (!getSenha().equals(getConfirmacaoSenha())) {
            throw new SenhasDiferentesException("As senhas não são iguais!");
        }
    }

    public String getNome() {
        return view.getInputNome().getText();
    }

    public String getUsuario() {
        return view.getInputUsuario().getText();
    }

    public String getSenha() {
        return String.valueOf(view.getInputSenha().getPassword());
    }

    public String getConfirmacaoSenha() {
        return String.valueOf(view.getInputConfirmaSenha().getPassword());
    }

    public void setNome(String nome) {
        view.getInputNome().setText(nome);
    }

    public void setUsuario(String usuario) {
        view.getInputUsuario().setText(usuario);

    }

    public void setSenha(String senha) {
        view.getInputSenha().setText(senha);

    }

    public void setConfirmacaoSenha(String confirmacaoSenha) {
        view.getInputConfirmaSenha().setText(confirmacaoSenha);

    }
}
