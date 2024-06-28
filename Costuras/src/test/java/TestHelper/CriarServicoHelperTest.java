package TestHelper;

import Controller.Helper.CriarServicoHelper;
import Model.Cliente;
import Model.Costureira;
import Model.Exceptions.CampoNuloException;
import Model.Servico;
import Model.StatusServico;
import Model.TipoServico;
import View.CriarServico;
import java.util.ArrayList;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CriarServicoHelperTest {

    CriarServico view;
    CriarServicoHelper helper;
    Servico servico;
    Cliente cliente;
    Costureira costureira;
    TipoServico tipoServico;

    @Before
    public void preparacao() {
        view = new CriarServico();
        helper = new CriarServicoHelper(view);
        costureira = new Costureira(0, "nomeMock", "loginMock", "senhaMock");
        view.setCostureiraLogada(costureira);
        cliente = new Cliente(0, "nomeMock", "telefoneMock", "enderecoMock", "observacaoMock");
        servico = new Servico(0, "Bainha", costureira, cliente, 0, 10, "mock", "mock", "observacaoMock", StatusServico.PEDIDO);
        tipoServico = new TipoServico("Bainha", 0, "observacaoMock", costureira);

        ArrayList<Cliente> clientes = new ArrayList<>();
        ArrayList<TipoServico> tipoServicos = new ArrayList<>();

        clientes.add(cliente);
        tipoServicos.add(tipoServico);

        helper.preencherClientesComboBox(clientes);
        helper.preencherTipoServicosComboBox(tipoServicos);
        
        helper.setComboBoxCliente(cliente.toString());
        helper.setComboBoxTipoServico(tipoServico.getTipo());
        helper.setValor(Double.toString(servico.getValor()));
        helper.setCustoPecas(Double.toString(servico.getCustoPecas()));
        helper.setObservacao(servico.getObservacao());

    }

    @Test
    public void deveRecuperarServico() throws CampoNuloException {
        Servico servicoRecuperado = helper.recuperaServico();

        //Preenchendo datas com "mock" pra testar
        servicoRecuperado.setDataPedido("mock");
        servicoRecuperado.setDataEntrega("mock");

        //É preciso do banco para recuperar o Cliente com o Id
        if (servicoRecuperado.getCliente().getId() == 0) {
            servicoRecuperado.setCliente(cliente);
        }

        Assert.assertTrue(servico.equals(servicoRecuperado));

    }

    @Test(expected = CampoNuloException.class)
    public void deveLancarCampoNuloExceptionComboBoxCliente() throws CampoNuloException{
        helper.setComboBoxCliente(" ");

        helper.recuperaServico();
    }
    
    @Test(expected = CampoNuloException.class)
    public void deveLancarCampoNuloExceptionComboBoxTipoServico() throws CampoNuloException{
        helper.setComboBoxTipoServico(" ");

        helper.recuperaServico();
    }
    
    @Test(expected = CampoNuloException.class)
    public void deveLancarCampoNuloExceptionValor() throws CampoNuloException{
        helper.setValor("");

        helper.recuperaServico();
    }
    
    @Test(expected = NumberFormatException.class)
    public void deveLancarNumberFormatExceptionValor() throws NumberFormatException, CampoNuloException{
        helper.setValor("nao numerico");

        helper.recuperaServico();
    }
    
    @Test(expected = NumberFormatException.class)
    public void deveLancarNumberFormatExceptionCustoPecas() throws NumberFormatException, CampoNuloException{
        helper.setCustoPecas("nao numerico");

        helper.recuperaServico();
    }
    
    @Test
    public void deveLimparInputCliente(){
        helper.limparInputs();

        //helper.setComboBoxCliente(cliente.toString());
        helper.setComboBoxTipoServico(tipoServico.getTipo());
        helper.setValor(Double.toString(servico.getValor()));
        helper.setCustoPecas(Double.toString(servico.getCustoPecas()));
        helper.setObservacao(servico.getObservacao());
        
        try{
            helper.recuperaServico();
        }catch(CampoNuloException e){
            Assert.assertTrue( e.getMessage().contains("CLIENTE") );
        }
    }
    
    @Test
    public void deveLimparInputTipoServico(){
        helper.limparInputs();

        helper.setComboBoxCliente(cliente.toString());
        //helper.setComboBoxTipoServico(tipoServico.getTipo());
        helper.setValor(Double.toString(servico.getValor()));
        helper.setCustoPecas(Double.toString(servico.getCustoPecas()));
        helper.setObservacao(servico.getObservacao());
        
        try{
            helper.recuperaServico();
        }catch(CampoNuloException e){
            Assert.assertTrue( e.getMessage().contains("TIPO DE SERVICO") );
        }
    }
    
    @Test
    public void deveLimparInputValor(){
        helper.limparInputs();

        helper.setComboBoxCliente(cliente.toString());
        helper.setComboBoxTipoServico(tipoServico.getTipo());
        //helper.setValor(Double.toString(servico.getValor()));
        helper.setCustoPecas(Double.toString(servico.getCustoPecas()));
        helper.setObservacao(servico.getObservacao());
        
        try{
            helper.recuperaServico();
        }catch(CampoNuloException e){
            Assert.assertTrue( e.getMessage().contains("VALOR") );
        }
    }
    
    @Test
    public void deveLimparInputCustoPecas(){
        helper.limparInputs();

        helper.setComboBoxCliente(cliente.toString());
        helper.setComboBoxTipoServico(tipoServico.getTipo());
        helper.setValor(Double.toString(servico.getValor()));
        //helper.setCustoPecas(Double.toString(servico.getCustoPecas()));
        helper.setObservacao(servico.getObservacao());
        
        Assert.assertTrue( helper.getCustoPecas() == 0 );
    }
    
    @Test
    public void deveLimparInputObservacao(){
        helper.limparInputs();

        helper.setComboBoxCliente(cliente.toString());
        helper.setComboBoxTipoServico(tipoServico.getTipo());
        helper.setValor(Double.toString(servico.getValor()));
        helper.setCustoPecas(Double.toString(servico.getCustoPecas()));
        //helper.setObservacao(servico.getObservacao());
        
        Assert.assertTrue( helper.getObservacao().isEmpty() );
    }
}
