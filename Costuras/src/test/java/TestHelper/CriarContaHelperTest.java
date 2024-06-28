
package TestHelper;

import Controller.Helper.CriarContaHelper;
import Model.Costureira;
import Model.Exceptions.CampoNuloException;
import Model.Exceptions.SenhasDiferentesException;
import View.CriarConta;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CriarContaHelperTest {
    CriarConta view;
    Costureira costureira;
    CriarContaHelper helper;
    
    @Before
    public void preparacao(){
        view = new CriarConta();
        costureira = new Costureira(0, "nomeMock", "loginMock", "senhaMock");
        helper = new CriarContaHelper(view);
        
        helper.setNome(costureira.getNome());
        helper.setUsuario(costureira.getLogin());
        helper.setSenha(costureira.getSenha());
        helper.setConfirmacaoSenha(costureira.getSenha());
    }
    
    @Test
    public void deveRecuperarCostureira(){
        
        try{
            Costureira costureiraRecuperada = helper.recuperarCostureira();
            Assert.assertTrue(costureira.equals(costureiraRecuperada));
        }catch(CampoNuloException | SenhasDiferentesException e){
            Assert.fail(e.getMessage());
        }
    }
    
    @Test(expected = CampoNuloException.class)
    public void deveLancarCampoNuloExceptionNome() throws CampoNuloException, SenhasDiferentesException{
        helper.setNome("");

        helper.recuperarCostureira();
    }
    
    @Test(expected = CampoNuloException.class)
    public void deveLancarCampoNuloExceptionLogin() throws CampoNuloException, SenhasDiferentesException{
        helper.setSenha("");

        helper.recuperarCostureira();
    }
    
    @Test(expected = CampoNuloException.class)
    public void deveLancarCampoNuloExceptionSenha() throws CampoNuloException, SenhasDiferentesException{
        helper.setSenha("");

        helper.recuperarCostureira();
    }
    
    @Test(expected = CampoNuloException.class)
    public void deveLancarCampoNuloExceptionConfirmacaoSenha() throws CampoNuloException, SenhasDiferentesException{
        helper.setConfirmacaoSenha("");

        helper.recuperarCostureira();
    }
    
    @Test(expected = SenhasDiferentesException.class)
    public void deveLancarSenhasDiferentesException() throws CampoNuloException, SenhasDiferentesException{
        helper.setConfirmacaoSenha("senhaDiferente");

        helper.recuperarCostureira();
    }
    
    @Test
    public void deveLimparInputs(){
        helper.limparInputs();
        
        Assert.assertTrue(helper.getNome().isEmpty());
        Assert.assertTrue(helper.getUsuario().isEmpty());
        Assert.assertTrue(helper.getSenha().isEmpty());
        Assert.assertTrue(helper.getConfirmacaoSenha().isEmpty());
    }
    
    
}
