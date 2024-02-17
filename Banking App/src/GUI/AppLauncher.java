package GUI;
import java.math.BigDecimal;

import javax.swing.*;

import Backend.User;
public class AppLauncher {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run(){
                new LoginGui().setVisible(true);
               //new RegisterGui().setVisible(true);
              /*  new BankingAppGui(
                        new User(4, "username", "password", new BigDecimal("20.00"))
            ).setVisible(true);*/
              
            }
        });
    }
}
