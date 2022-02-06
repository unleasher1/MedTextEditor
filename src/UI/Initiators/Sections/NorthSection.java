package UI.Initiators.Sections;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NorthSection {
    JPanel panel;

    public NorthSection() {
        panel = new JPanel(new GridBagLayout());
        addButtons();
    }

    // adding buttons
    private void addButtons() {
        JButton b1 = new JButton("button1");
        JButton b2 = new JButton("button2");
        JButton b3 = new JButton("button3");
        JButton b4 = new JButton("button4");
        panel.add(b1);
        panel.add(b2);
        panel.add(b3);
        panel.add(b4);
        panel.add(b4);
        b1.addActionListener(e -> System.out.println("b1 is " + e.getActionCommand()));

        b2.addActionListener(e -> System.out.println("b1 is " + e.getActionCommand()));

        b3.addActionListener(e -> System.out.println("b1 is " + e.getActionCommand()));

        b4.addActionListener(e -> System.out.println("b1 is " + e.getActionCommand()));


    }

    public JPanel getPanel() {
        return panel;
    }
}
