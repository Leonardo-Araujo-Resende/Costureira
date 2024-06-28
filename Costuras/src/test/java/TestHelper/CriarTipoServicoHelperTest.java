package TestHelper;

import Controller.CriarTipoServicoController;
import Controller.Helper.CriarTipoServicoHelper;
import Model.Costureira;
import Model.Exceptions.CampoNuloException;
import Model.TipoServico;
import View.CriarTipoServico;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CriarTipoServicoHelperTest {

    CriarTipoServico view;
    CriarTipoServicoHelper helper;

    Costureira costureira;
    TipoServico tipoServico;

    @Before
    public void preparacao() {
        view = new CriarTipoServico();
        helper = new CriarTipoServicoHelper(view);

        costureira = new Costureira(0, "nomeMock", "loginMock", "senhaMock");
        tipoServico = new TipoServico("Bainha", 0, "observacaoMock", costureira);

        view.setCostureiraLogada(costureira);

        helper.setValor(Double.toString(tipoServico.getValor()));
        helper.setTipo(tipoServico.getTipo());
        helper.setObservacao(tipoServico.getObservacao());

    }

    @Test
    public void deveRecuperarTipoServico() throws NumberFormatException, CampoNuloException {
        TipoServico tipoServicoRecuperado = helper.recuperarTipoServico();

        tipoServicoRecuperado.setCostureira(costureira);

        Assert.assertTrue(tipoServico.equals(tipoServicoRecuperado));
    }

    @Test(expected = CampoNuloException.class)
    public void deveLancarCampoNuloExceptionCampoTipo() throws CampoNuloException {
        helper.setTipo("");
        helper.recuperarTipoServico();

    }

    @Test(expected = CampoNuloException.class)
    public void deveLancarCampoNuloExceptionCampoValor() throws CampoNuloException {
        helper.setValor("");
        helper.recuperarTipoServico();

    }

    @Test(expected = NumberFormatException.class)
    public void deveLancarNumberFormatExceptionCampoValor() throws NumberFormatException, CampoNuloException {
        helper.setValor("nao numerico");
        helper.recuperarTipoServico();

    }
    
    @Test
    public void deveLimparInputs(){
        helper.limparInputs();
      
        Assert.assertTrue(helper.getTipo().isEmpty());
        
        try{
            helper.getValor();
        }catch(NumberFormatException e){
            Assert.assertTrue(true);
        }
        
        Assert.assertTrue( helper.getObservacao().isEmpty());
    }
}
