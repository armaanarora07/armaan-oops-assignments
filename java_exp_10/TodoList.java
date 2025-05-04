package java_exp_10;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;

public class TodoList extends JFrame {
    private DefaultListModel<String> listModel;
    private JList<String> taskList;
    private JTextField taskField;
    
    public TodoList() {
        setTitle("To-Do List");
        setSize(400, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        
        listModel = new DefaultListModel<>();
        taskList = new JList<>(listModel);
        add(new JScrollPane(taskList), BorderLayout.CENTER);
        
        JPanel inputPanel = new JPanel(new BorderLayout());
        taskField = new JTextField();
        inputPanel.add(taskField, BorderLayout.CENTER);
        
        JButton addButton = new JButton("Add");
        addButton.addActionListener(e -> {
            String task = taskField.getText().trim();
            if (!task.isEmpty()) {
                listModel.addElement(task);
                taskField.setText("");
            }
        });
        
        JButton removeButton = new JButton("Remove");
        removeButton.addActionListener(e -> {
            int selectedIndex = taskList.getSelectedIndex();
            if (selectedIndex != -1) {
                listModel.remove(selectedIndex);
            }
        });
        
        JPanel buttonPanel = new JPanel(new GridLayout(1, 2));
        buttonPanel.add(addButton);
        buttonPanel.add(removeButton);
        
        inputPanel.add(buttonPanel, BorderLayout.EAST);
        add(inputPanel, BorderLayout.SOUTH);
        
        setVisible(true);
    }

    public static void main(String[] args) {
        new TodoList();
    }
}