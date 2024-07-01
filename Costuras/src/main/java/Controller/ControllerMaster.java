package Controller;

import View.Login;
import com.formdev.flatlaf.FlatDarkLaf;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class ControllerMaster {
    
    public static void iniciarAplicacao() {

        try {
            UIManager.setLookAndFeel(new FlatDarkLaf());
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        new Login().setVisible(true);

    }

    public static void setIcone(JFrame frame) {
        frame.setIconImage( new ImageIcon(frame.getClass().getResource("/Imagens/IconeAplicacao.png")).getImage());
    }

}
