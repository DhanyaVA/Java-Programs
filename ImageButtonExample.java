/*4c. Develop a Swing program in Java to display a message “Digital Clock is pressed” or “Hour Glass
is pressed” depending upon the Jbutton with image either Digital Clock or Hour Glass is pressed by
implementing the event handling mechanism with addActionListener( ).*/
package Swings;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ImageButtonExample extends JFrame implements ActionListener {

    JButton btnClock, btnHourGlass;
    JLabel messageLabel;

    public ImageButtonExample() {
        setTitle("Image Button Example");
        setSize(400, 300);
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Load and resize images
        ImageIcon clockIcon = new ImageIcon(getClass().getResource("/images/clock.png"));
        Image clockImg = clockIcon.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH);
        clockIcon = new ImageIcon(clockImg);

        ImageIcon hourGlassIcon = new ImageIcon(getClass().getResource("/images/hourglass.png"));
        Image hgImg = hourGlassIcon.getImage().getScaledInstance(60, 60, Image.SCALE_SMOOTH);
        hourGlassIcon = new ImageIcon(hgImg);

        // Create buttons
        btnClock = new JButton("Clock", clockIcon);
        btnHourGlass = new JButton("HourGlass", hourGlassIcon);

        // TEXT ABOVE IMAGE
        btnClock.setVerticalTextPosition(SwingConstants.TOP);
        btnClock.setHorizontalTextPosition(SwingConstants.CENTER);

        btnHourGlass.setVerticalTextPosition(SwingConstants.TOP);
        btnHourGlass.setHorizontalTextPosition(SwingConstants.CENTER);

        // Optional: make buttons cleaner
        btnClock.setFocusPainted(false);
        btnHourGlass.setFocusPainted(false);

        // Add listeners
        btnClock.addActionListener(this);
        btnHourGlass.addActionListener(this);

        // Message label
        messageLabel = new JLabel("Press a button");
        messageLabel.setFont(new Font("Arial", Font.BOLD, 14));

        // Add components
        add(btnClock);
        add(btnHourGlass);
        add(messageLabel);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnClock) {
            messageLabel.setText("Digital Clock is pressed");
        } else if (e.getSource() == btnHourGlass) {
            messageLabel.setText("Hour Glass is pressed");
        }
    }

    public static void main(String[] args) {
        new ImageButtonExample();
    }
}