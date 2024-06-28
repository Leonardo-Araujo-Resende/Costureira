package TestHelper;


import Controller.EditarClienteController;
import Controller.Helper.EditarClienteHelper;
import Model.Cliente;
import Model.Exceptions.CampoNuloException;
import Model.TipoServico;
import View.EditarCliente;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class EditarClienteHelperTest {
    EditarCliente view;
    EditarClienteHelper helper;
    Cliente cliente;

    
    @Before
    public void preparacao() {
        cliente = new Cliente(0, "nomeMock", "telefoneMock", "enderecoMock", "observacaoMock");
        view = new EditarCliente(cliente);
        helper = new EditarClienteHelper(view);
        helper.preencherInputCliente(cliente);
    }
    
    @Test
    public void deveRecuperarCliente() throws CampoNuloException{
        
        Cliente clienteRecuperado = helper.recuperarCliente();
        
        Assert.assertTrue( clienteRecuperado.equals(cliente) );
    }
    
    @Test(expected = CampoNuloException.class)
    public void deveLancarCampoNuloExceptionCampoNome() throws CampoNuloException {
        helper.setNome("");
        helper.recuperarCliente();
    }
    
    @Test(expected = CampoNuloException.class)
    public void deveLancarCampoNuloExceptionCampoTelefone() throws CampoNuloException {
        helper.setTelefone("");
        helper.recuperarCliente();
    }
    
    

}
