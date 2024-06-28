
package Controller;

import Controller.Helper.CriarContaHelper;
import DAO.CostureiraDAO;
import Model.Costureira;
import Model.Exceptions.CampoNuloException;
import Model.Exceptions.CostureiraJaExisteException;
import Model.Exceptions.SenhasDiferentesException;
import View.CriarConta;

public class CriarContaController {
    private CriarConta view;
    private CriarContaHelper helper;

    public CriarContaController(CriarConta view) {
        this.view = view;
        this.helper = new CriarContaHelper(view);
    }
    
    public void criarConta(){
        try{
            
            Costureira costureira = helper.recuperarCostureira();
            CostureiraDAO.salvarCostureira(costureira);
            helper.limparInputs();
            view.exibirMensagem("Conta criada com sucesso!");
            
        }catch(CampoNuloException | SenhasDiferentesException | CostureiraJaExisteException e){
            view.exibirMensagem(e.getMessage());
        }
    }
    
    
}
