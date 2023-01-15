package Login;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegisterPage implements ActionListener {
    JFrame frame = new JFrame();
    JButton registerButton = new JButton("Register");
    JButton loginButton = new JButton("Sign In");
    JTextField display_name = new JTextField();
    JTextField userId = new JTextField();
    JPasswordField userPassword1 = new JPasswordField();
    JPasswordField userPassword2 = new JPasswordField();
    JLabel userIdLabel = new JLabel("Username:");
    JLabel userPasswordLabel1 = new JLabel("Password:");
    JLabel userPasswordLabel2 = new JLabel("Re-enter");
    JLabel userPasswordLabel2con = new JLabel("Password:");
    JLabel displayNameLabel = new JLabel("Name");
    JLabel messageLabel = new JLabel();
    JLabel title_label = new JLabel("Create Account");

    public RegisterPage(){
        //this.loginInfo = loginInfo;

        userIdLabel.setBounds(50, 100, 75, 25);
        userPasswordLabel1.setBounds(50, 150, 75, 25);
        userPasswordLabel2.setBounds(50, 200, 75, 25);
        userPasswordLabel2con.setBounds(50, 215, 75, 25);
        displayNameLabel.setBounds(50, 250, 75, 25);

        messageLabel.setBounds(50, 350, 250, 35);
        messageLabel.setFont(new Font(null, Font.ITALIC, 10));

        userId.setBounds(125, 100, 200, 25);
        userPassword1.setBounds(125, 150, 200, 25);
        userPassword2.setBounds(125, 200, 200, 25);
        display_name.setBounds(125, 250, 200, 25);

        registerButton.setBounds(125, 300, 100, 25);
        registerButton.addActionListener(this);
        loginButton.setBounds(225, 300, 100, 25);
        loginButton.addActionListener(this);

        title_label.setBounds(175, 50, 150, 25);

        frame.add(title_label);
        frame.add(display_name);
        frame.add(displayNameLabel);
        frame.add(registerButton);
        frame.add(loginButton);
        frame.add(userId);
        frame.add(userPassword1);
        frame.add(userPassword2);
        frame.add(userIdLabel);
        frame.add(userPasswordLabel1);
        frame.add(userPasswordLabel2);
        frame.add(userPasswordLabel2con);
        frame.add(messageLabel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 420);
        frame.setLayout(null);
        frame.setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==registerButton){
            String username = userId.getText();
            String password1 = String.valueOf(userPassword1.getPassword());
            String password2 = String.valueOf(userPassword2.getPassword());
            String display = display_name.getText();
            RegisterController registerController = new RegisterController(display, username,password1, password2);

            if (registerController.registerUser().equals("exists")){
                messageLabel.setForeground(Color.red);
                messageLabel.setText("This username already exists. Please try again.");
            }
            else if (password1.equals("") || username.equals("") || password2.equals("") || display.equals("")){
                messageLabel.setForeground(Color.red);
                messageLabel.setText("Input fields cannot be left empty. Please try again.");
            }
            else if (registerController.registerUser().equals("Passwords not matching")){
                messageLabel.setForeground(Color.red);
                messageLabel.setText("Passwords are not matching. Please try again.");
            }
            else {
                messageLabel.setForeground(Color.green);
                messageLabel.setText("Registration successful");
                frame.dispose();
                LoginPage loginPage = new LoginPage();
            }
        }
        else{
            frame.dispose();
            LoginPage newLoginPage = new LoginPage();
        }

    }
    public JButton getButton(){
        return this.registerButton;
    }
}
