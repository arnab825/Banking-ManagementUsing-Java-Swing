package GUI;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import Backend.MyJDBC;
import Backend.User;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;




public class LoginGui extends BaseFrame{
   public LoginGui(){
     super("STATE BANK OF INDIA");
   }
   
    

    @Override
    protected  void addGuiComponents() {
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
          usernameLabel.setBounds(35, 200, getWidth() - 30, 24);
  
          usernameLabel.setFont(new Font("Dialog", Font.PLAIN, 20));
          add(usernameLabel);

            // create username field
        JTextField usernameField = new JTextField();
        usernameField.setBounds(35, 250, getWidth() - 90, 40);
        usernameField.setFont(new Font("Dialog", Font.PLAIN, 28));
        add(usernameField);
        
           // create password label
           JLabel passwordLabel = new JLabel("Password:");
           passwordLabel.setBounds(35, 320, getWidth() - 50, 24);
           passwordLabel.setFont(new Font("Dialog", Font.PLAIN, 20));
           add(passwordLabel);

           // create password field
        JPasswordField passwordField = new JPasswordField();
        passwordField.setBounds(35, 360, getWidth() - 90, 40);
        passwordField.setFont(new Font("Dialog", Font.PLAIN, 28));
        add(passwordField);

            // create login button
        JButton loginButton = new JButton("Login");
        loginButton.setBounds(210, 460, getWidth() - 420, 60);
        loginButton.setFont(new Font("Dialog", Font.BOLD, 40));
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // get username
                String username = usernameField.getText();

                // get password
                String password = new String(passwordField.getPassword());

                // validate login
                User user = MyJDBC.validateLogin(username, password);

                // if user is null it means invalid otherwise it is a valid account
                if(user != null){
                    // means valid login

                    // dispose this gui
                    LoginGui.this.dispose();

                    // launch bank app gui
                    BankingAppGui bankingAppGui = new BankingAppGui(user);
                    bankingAppGui.setVisible(true);

                    // show success dialog
                    JOptionPane.showMessageDialog(bankingAppGui, "Login Successfully!");
                }else{
                    // invalid login
                    JOptionPane.showMessageDialog(LoginGui.this, "Login failed...");
                }
            }
        });
        add(loginButton);

            // create register label
            JLabel registerLabel = new JLabel("<html><a href=\"#\">Don't have an account? Register Here</a></html>");
             registerLabel.setBounds(0, 600, getWidth() - 10, 35);
        registerLabel.setFont(new Font("Dialog", Font.PLAIN, 20));
        registerLabel.setHorizontalAlignment(SwingConstants.CENTER);
            registerLabel.addMouseListener(new MouseAdapter() {
              @Override
              public void mouseClicked(MouseEvent e){
                if(e.getSource()==registerLabel){}
                // dispose this gui
                LoginGui.this.dispose();
                // launch the register gui
                new RegisterGui().setVisible(true);
              }
            });

            add(registerLabel);
        



    }

    
    
}
