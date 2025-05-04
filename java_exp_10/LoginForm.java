package java_exp_10;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LoginForm extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;
    
    public LoginForm() {
        setTitle("Login Form");
        setSize(300, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(3, 2, 5, 5));
        
        add(new JLabel("Username:"));
        usernameField = new JTextField();
        add(usernameField);
        
        add(new JLabel("Password:"));
        passwordField = new JPasswordField();
        add(passwordField);
        
        JButton loginButton = new JButton("Login");
        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());
                
                if (username.equals("admin") && password.equals("password")) {
                    JOptionPane.showMessageDialog(LoginForm.this, "Login Successful!");
                } else {
                    JOptionPane.showMessageDialog(LoginForm.this, "Invalid credentials", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        add(loginButton);
        
        setVisible(true);
    }

    public static void main(String[] args) {
        new LoginForm();
    }
}