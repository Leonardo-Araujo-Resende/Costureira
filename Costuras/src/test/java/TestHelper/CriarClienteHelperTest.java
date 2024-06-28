
package TestHelper;

import Controller.Helper.CriarClienteHelper;
import Model.Cliente;
import Model.Exceptions.CampoNuloException;
import View.CriarCliente;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CriarClienteHelperTest {
    
    private Cliente cliente;
    private CriarCliente view;
    private CriarClienteHelper helper;
    
    @Before
    public void preparacao(){
        cliente = new Cliente(0, "nomeMock", "telefoneMock", "enderecoMock", "observacaoMock");
        view = new CriarCliente();
        helper = new CriarClienteHelper(view);
    }
    
    @Test
    public void deveRecuperarClienteIgualMock(){
            
        helper.setNome(cliente.getNome());
        helper.setTelefone(cliente.getTelefone());
        helper.setEndereco(cliente.getEndereco());
        helper.setObservacao(cliente.getObservacao());
        
        
        try{
            Cliente clienteRecuperado = helper.recuperarCliente();
            Assert.assertTrue(clienteRecuperado.equals(clienteRecuperado));
        }catch(CampoNuloException e){
            Assert.fail(e.getMessage());
        }
    }
    
    @Test(expected = CampoNuloException.class)
    public void deveLancarCampoNuloExceptionCampoNome() throws CampoNuloException{
        cliente = new Cliente(0, "", "telefoneMock", "enderecoMock", "observacaoMock");
        
        helper.setNome(cliente.getNome());
        helper.setTelefone(cliente.getTelefone());
        helper.setEndereco(cliente.getEndereco());
        helper.setObservacao(cliente.getObservacao());
        
        helper.limparInputs();
        
        helper.recuperarCliente();
    }
    
    @Test(expected = CampoNuloException.class)
    public void deveLancarCampoNuloExceptionCampoTelefone() throws CampoNuloException{
        cliente = new Cliente(0, "nomeMock", "", "enderecoMock", "observacaoMock");
        
        helper.setNome(cliente.getNome());
        helper.setTelefone(cliente.getTelefone());
        helper.setEndereco(cliente.getEndereco());
        helper.setObservacao(cliente.getObservacao());
        
        helper.limparInputs();
        
        helper.recuperarCliente();
    }
    
    @Test
    public void deveLimparTodosInputs(){
        cliente = new Cliente(0, "nomeMock", "telefoneMock", "enderecoMock", "observacaoMock");
        
        helper.setNome(cliente.getNome());
        helper.setTelefone(cliente.getTelefone());
        helper.setEndereco(cliente.getEndereco());
        helper.setObservacao(cliente.getObservacao());
        
        helper.limparInputs();
        
        Assert.assertTrue(helper.getNome().isEmpty());
        Assert.assertTrue(helper.getTelefone().isEmpty());
        Assert.assertTrue(helper.getEndereco().isEmpty());
        Assert.assertTrue(helper.getObservacao().isEmpty());
        
    }
}
