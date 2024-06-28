package TestHelper;

import Controller.EditarServicoController;
import Controller.Helper.EditarServicoHelper;
import Model.Cliente;
import Model.Costureira;
import Model.Exceptions.CampoNuloException;
import Model.Servico;
import Model.StatusServico;
import Model.TipoServico;
import View.EditarServico;
import java.util.ArrayList;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class EditarServicoHelperTest {

    EditarServico view;
    EditarServicoHelper helper;
    Servico servico;
    Cliente cliente;
    Costureira costureira;
    TipoServico tipoServico;

    @Before
    public void preparacao() {
        view = new EditarServico();
        helper = new EditarServicoHelper(view);

        costureira = new Costureira(0, "nomeMock", "loginMock", "senhaMock");
        cliente = new Cliente(0, "nomeMock", "telefoneMock", "enderecoMock", "observacaoMock");
        servico = new Servico(0, "Bainha", costureira, cliente, 0, 10, "mock", "mock", "observacaoMock", StatusServico.PEDIDO);
        tipoServico = new TipoServico("Bainha", 0, "observacaoMock", costureira);

        ArrayList<Cliente> clientes = new ArrayList<>();
        ArrayList<TipoServico> tipoServicos = new ArrayList<>();

        clientes.add(cliente);
        tipoServicos.add(tipoServico);

        helper.preencherClientesComboBox(clientes);
        helper.preencherTipoServicosComboBox(tipoServicos);

        view.setCostureiraLogada(costureira);
        view.setEditandoServico(servico);

        helper.preencherInputsServico(servico);

    }

    @Test
    public void deveRecuperarServico() throws CampoNuloException {
        Servico antigo = servico;
        helper.atualizarServico(servico);

        Assert.assertTrue(antigo.equals(servico));
    }

    @Test(expected = CampoNuloException.class)
    public void deveLancarCampoNuloExceptionCampoCliente() throws CampoNuloException {
        helper.setComboBoxCliente("");
        helper.atualizarServico(servico);
    }

    @Test(expected = CampoNuloException.class)
    public void deveLancarCampoNuloExceptionCampoTipoServico() throws CampoNuloException {
        helper.setComboBoxTipoServico("");
        helper.atualizarServico(servico);
    }

    @Test(expected = CampoNuloException.class)
    public void deveLancarCampoNuloExceptionCampoValor() throws CampoNuloException {
        helper.setValor("");
        helper.atualizarServico(servico);
    }
}
