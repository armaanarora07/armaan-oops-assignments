package java_exp_10;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.regex.*;

public class RegistrationForm extends JFrame {
    private JTextField nameField, emailField;
    private JPasswordField passwordField, confirmPasswordField;
    private JLabel errorLabel;
    
    public RegistrationForm() {
        setTitle("Registration Form");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(6, 2, 5, 5));
        
        add(new JLabel("Name:"));
        nameField = new JTextField();
        add(nameField);
        
        add(new JLabel("Email:"));
        emailField = new JTextField();
        add(emailField);
        
        add(new JLabel("Password:"));
        passwordField = new JPasswordField();
        add(passwordField);
        
        add(new JLabel("Confirm Password:"));
        confirmPasswordField = new JPasswordField();
        add(confirmPasswordField);
        
        errorLabel = new JLabel("");
        errorLabel.setForeground(Color.RED);
        add(errorLabel);
        
        JButton registerButton = new JButton("Register");
        registerButton.addActionListener(e -> validateRegistration());
        add(registerButton);
        
        setVisible(true);
    }
    
    private void validateRegistration() {
        String name = nameField.getText().trim();
        String email = emailField.getText().trim();
        String password = new String(passwordField.getPassword());
        String confirmPassword = new String(confirmPasswordField.getPassword());
        
        if (name.isEmpty() || email.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
            errorLabel.setText("All fields are required");
            return;
        }
        
        if (!password.equals(confirmPassword)) {
            errorLabel.setText("Passwords do not match");
            return;
        }
        
        if (!Pattern.matches("^[^@]+@[^@]+\\.[^@]+$", email)) {
            errorLabel.setText("Invalid email format");
            return;
        }
        
        errorLabel.setText("");
        JOptionPane.showMessageDialog(this, "Registration Successful!");
    }

    public static void main(String[] args) {
        new RegistrationForm();
    }
}