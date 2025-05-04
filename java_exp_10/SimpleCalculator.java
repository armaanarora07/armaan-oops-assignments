package java_exp_10;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SimpleCalculator extends JFrame {
    private JTextField display;
    private double firstNumber, secondNumber, result;
    private String operation;
    
    public SimpleCalculator() {
        setTitle("Simple Calculator");
        setSize(300, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        
        display = new JTextField();
        display.setEditable(false);
        display.setFont(new Font("Arial", Font.PLAIN, 24));
        add(display, BorderLayout.NORTH);
        
        JPanel buttonPanel = new JPanel(new GridLayout(5, 4, 5, 5));
        
        String[] buttons = {
            "7", "8", "9", "/",
            "4", "5", "6", "*",
            "1", "2", "3", "-",
            "0", ".", "=", "+",
            "C"
        };
        
        for (String text : buttons) {
            JButton button = new JButton(text);
            button.addActionListener(new ButtonClickListener());
            buttonPanel.add(button);
        }
        
        add(buttonPanel, BorderLayout.CENTER);
        setVisible(true);
    }
    
    private class ButtonClickListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();
            
            if (command.matches("[0-9.]")) {
                display.setText(display.getText() + command);
            } else if (command.matches("[+\\-*/]")) {
                firstNumber = Double.parseDouble(display.getText());
                operation = command;
                display.setText("");
            } else if (command.equals("=")) {
                secondNumber = Double.parseDouble(display.getText());
                switch (operation) {
                    case "+": result = firstNumber + secondNumber; break;
                    case "-": result = firstNumber - secondNumber; break;
                    case "*": result = firstNumber * secondNumber; break;
                    case "/": result = firstNumber / secondNumber; break;
                }
                display.setText(String.valueOf(result));
            } else if (command.equals("C")) {
                display.setText("");
                firstNumber = secondNumber = result = 0;
                operation = "";
            }
        }
    }

    public static void main(String[] args) {
        new SimpleCalculator();
    }
}