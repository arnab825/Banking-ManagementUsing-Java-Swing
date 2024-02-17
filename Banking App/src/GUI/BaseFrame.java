package GUI;

import javax.swing.*;

import Backend.User;

public abstract class BaseFrame extends JFrame{
    //store user information
    protected User user;
    public BaseFrame(String title)
    {
        super(title);
        initialize(title);
    }
   
    public BaseFrame(String title, User user){
        // initialize user
        this.user = user;

        initialize(title);
    }
    private void initialize(String title){
        ImageIcon icon= new ImageIcon("Banking App\\src\\Assets\\logo-state-bank-india-big.jpg");
        this.setIconImage(icon.getImage());
        setTitle(title);
        setSize(650,700);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        addGuiComponents();
    }
    protected abstract void addGuiComponents();
}
