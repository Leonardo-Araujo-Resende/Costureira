package Controller;

import Controller.Helper.LoginHelper;
import DAO.CostureiraDAO;
import Model.Costureira;
import Model.Exceptions.CampoNuloException;
import View.Login;

public class LoginController {

    private Login view;
    private LoginHelper helper;

    public LoginController(Login loginView) {
        this.view = loginView;
        this.helper = new LoginHelper(this.view);
    }

    public void logarSistema() {
        try {

            Costureira costureira = helper.recuperarInputs();
            boolean deuCerto = CostureiraDAO.procurarCostureiraLoginSenha(costureira);
            if (!deuCerto) {
                view.exibirMensagem("Login ou senha inválidos!");
            } else {
                view.abrirMenuPrincipal(costureira);
            }

        } catch (CampoNuloException e) {
            view.exibirMensagem(e.getMessage());
            return;
        }

    }
}
