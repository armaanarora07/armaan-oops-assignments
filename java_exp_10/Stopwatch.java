package java_exp_10;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.Timer;

public class Stopwatch extends JFrame {
    private JLabel timeLabel;
    private JButton startButton, stopButton, resetButton;
    private Timer timer;
    private int seconds = 0;
    
    public Stopwatch() {
        setTitle("Stopwatch");
        setSize(300, 150);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        
        timeLabel = new JLabel("0", SwingConstants.CENTER);
        timeLabel.setFont(new Font("Arial", Font.BOLD, 24));
        add(timeLabel, BorderLayout.CENTER);
        
        JPanel buttonPanel = new JPanel(new GridLayout(1, 3));
        
        startButton = new JButton("Start");
        startButton.addActionListener(e -> startTimer());
        
        stopButton = new JButton("Stop");
        stopButton.addActionListener(e -> stopTimer());
        stopButton.setEnabled(false);
        
        resetButton = new JButton("Reset");
        resetButton.addActionListener(e -> resetTimer());
        
        buttonPanel.add(startButton);
        buttonPanel.add(stopButton);
        buttonPanel.add(resetButton);
        add(buttonPanel, BorderLayout.SOUTH);
        
        timer = new Timer(1000, e -> {
            seconds++;
            timeLabel.setText(String.valueOf(seconds));
        });
        
        setVisible(true);
    }
    
    private void startTimer() {
        timer.start();
        startButton.setEnabled(false);
        stopButton.setEnabled(true);
    }
    
    private void stopTimer() {
        timer.stop();
        startButton.setEnabled(true);
        stopButton.setEnabled(false);
    }
    
    private void resetTimer() {
        timer.stop();
        seconds = 0;
        timeLabel.setText("0");
        startButton.setEnabled(true);
        stopButton.setEnabled(false);
    }

    public static void main(String[] args) {
        new Stopwatch();
    }
}