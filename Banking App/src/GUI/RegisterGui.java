package GUI;

import java.awt.Font;
import java.awt.event.MouseAdapter;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import java.awt.event.MouseEvent;

public class RegisterGui extends BaseFrame {
   public RegisterGui(){
     super("Banking Application");
    }
   
    @Override
    protected void addGuiComponents() {
             setLayout(null);
       JLabel bankingAppLabel = new JLabel("Banking Application");

        // set the location and the size of the gui component
        bankingAppLabel.setBounds(60,40 ,450 , 100);

        // change the font style
        bankingAppLabel.setFont(new Font("Dialog", Font.BOLD, 45));

        // center text in Jlabel
       bankingAppLabel.setHorizontalAlignment(JLabel.CENTER);

        // add to gui
        add(bankingAppLabel);

          // username label
          JLabel usernameLabel = new JLabel("Username:");

          // getWidth() returns us the width of our frame which is about 450
          usernameLabel.setBounds(35, 160, getWidth() - 30, 24);
  
          usernameLabel.setFont(new Font("Dialog", Font.PLAIN, 20));
          add(usernameLabel);

            // create username field
        JTextField usernameField = new JTextField();
        usernameField.setBounds(35, 190, getWidth() - 90, 40);
        usernameField.setFont(new Font("Dialog", Font.PLAIN, 28));
        add(usernameField);
        
           // create password label
           JLabel passwordLabel = new JLabel("Password:");
           passwordLabel.setBounds(35, 250, getWidth() - 50, 24);
           passwordLabel.setFont(new Font("Dialog", Font.PLAIN, 20));
           add(passwordLabel);

           // create password field
        JPasswordField passwordField = new JPasswordField();
        passwordField.setBounds(35, 285, getWidth() - 90, 40);
        passwordField.setFont(new Font("Dialog", Font.PLAIN, 28));
        add(passwordField);


        // confirm password label
        JLabel rePasswordLabel = new JLabel("Confirm Password:");
        rePasswordLabel.setBounds(35, 340, getWidth() - 50, 40);
        rePasswordLabel.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(rePasswordLabel);

        // create confirm password field
        JPasswordField rePasswordField = new JPasswordField();
        rePasswordField.setBounds(35, 385, getWidth() - 90, 40);
        rePasswordField.setFont(new Font("Dialog", Font.PLAIN, 28));
        add(rePasswordField);

            // create login button
        JButton loginButton = new JButton("Login");
        loginButton.setBounds(210, 530, getWidth() - 420, 60);
        loginButton.setFont(new Font("Dialog", Font.BOLD, 40));
        add(loginButton);

            // create register label
            JLabel loginLabel = new JLabel("<html><a href=\"#\">Have an account? Sign-in here</a></html>");
            loginLabel.setBounds(0, 600, getWidth() - 10, 35);
            loginLabel.setFont(new Font("Dialog", Font.PLAIN, 30));
            loginLabel.setHorizontalAlignment(SwingConstants.CENTER);
              loginLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
              if(e.getSource() == loginLabel){
                // dispose of this gui
                RegisterGui.this.dispose();

                // launch the login gui
                new LoginGui().setVisible(true);
            }
          }
        });
            add(loginLabel);
        

    }
}
