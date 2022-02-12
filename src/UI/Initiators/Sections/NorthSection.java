package UI.Initiators.Sections;

import UI.CustomComponents.InternalValues.UIType;
import UI.CustomComponents.MButton;
import UI.CustomComponents.MPanel;
import UI.Initiators.Initiating;

import javax.swing.*;
import java.awt.*;

public class NorthSection implements Initiating {
    MPanel northContainer;
    MPanel panel;
    MPanel spacer;
    UIType type;

    public NorthSection() {
        type = UIType.DARK;
        spacer = new MPanel(UIType.DARK);
        northContainer = new MPanel(new BorderLayout(), UIType.DARK);
        panel = new MPanel(new GridBagLayout(), type);
        northContainer.add(panel, BorderLayout.WEST);
        northContainer.add(spacer, BorderLayout.EAST);

        addButtons();
    }

    // adding buttons
    private void addButtons() {
        MButton b1 = new MButton("button1", type);
        MButton b2 = new MButton("button2", type);
        MButton b3 = new MButton("button3", type);
        MButton b4 = new MButton("button4", type);
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


    @Override
    public JPanel getInitiatedPanel() {
        return northContainer;
    }
}
