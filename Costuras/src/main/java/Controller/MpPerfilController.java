
package Controller;

import Controller.Helper.MpPerfilHelper;
import View.MenuPrincipal;

public class MpPerfilController {
    
    private MenuPrincipal view;
    private MpPerfilHelper helper;

    public MpPerfilController(MenuPrincipal view) {
        this.view = view;
        this.helper = new MpPerfilHelper(view);
        
        atualizarDados();
    }
    
    public void atualizarDados(){
        helper.atualizaLabels();
        helper.atualizaTabelaPorMes();
        helper.atualizaTabelaStatusPedido();
        helper.atualizaTabelaTipoPedido();
    }
    
}
