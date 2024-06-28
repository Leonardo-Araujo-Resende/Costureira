package TestHelper;

import Controller.Helper.LoginHelper;
import Model.Costureira;
import Model.Exceptions.CampoNuloException;
import View.Login;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class LoginHelperTest {

    Login view;
    LoginHelper helper;
    Costureira costureira;

    @Before
    public void preparacao() {
        view = new Login();
        helper = new LoginHelper(view);

        costureira = new Costureira(0, "nomeMock", "loginMock", "senhaMock");
        helper.setLogin(costureira.getLogin());
        helper.setSenha(costureira.getSenha());
    }

    @Test
    public void deveRetornarLoginSenha() throws CampoNuloException {
        Costureira costureiraRecuperada = helper.recuperarInputs();

        Assert.assertTrue(costureira.getLogin().equals(costureiraRecuperada.getLogin()));
        Assert.assertTrue(costureira.getSenha().equals(costureiraRecuperada.getSenha()));

    }

    @Test(expected = CampoNuloException.class)
    public void deveLancarCampoNuloExceptionCampoLogin() throws CampoNuloException {
        helper.setLogin("");
        helper.recuperarInputs();
    }
    
    @Test(expected = CampoNuloException.class)
    public void deveLancarCampoNuloExceptionCampoSenha() throws CampoNuloException {
        helper.setSenha("");
        helper.recuperarInputs();
    }
}
