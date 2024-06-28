package Controller;

import Controller.Helper.CriarTipoServicoHelper;
import DAO.TipoServicoDAO;
import Model.Exceptions.CampoNuloException;
import View.CriarTipoServico;
import java.sql.SQLException;

public class CriarTipoServicoController {

    private CriarTipoServico view;
    private CriarTipoServicoHelper helper;

    public CriarTipoServicoController(CriarTipoServico view) {
        this.view = view;
        this.helper = new CriarTipoServicoHelper(view);
    }

    public void criarTipoServico() throws SQLException {
        try {
            TipoServicoDAO.salvarTipoServico(helper.recuperarTipoServico());
            atualizarTabela();
            helper.limparInputs();
        } catch (CampoNuloException | NumberFormatException e) {
            view.exibirMensagem(e.getMessage());
        } catch (SQLException e) {
            view.exibirMensagem("Este tipo já existe!");
        }
    }

    public void atualizarTabela() {
        helper.atualizaTabela();
    }

}
