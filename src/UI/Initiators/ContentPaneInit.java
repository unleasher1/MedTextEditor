package UI.Initiators;

import UI.CustomComponents.InternalValues.UIType;
import UI.CustomComponents.MButton;
import UI.CustomComponents.MPanel;
import UI.Initiators.Components.MenuBarInitiator;
import UI.Initiators.Sections.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

public class ContentPaneInit {
    public static boolean RIGHT_TO_LEFT = false;
    public static Container contentPane1;

    private static JPanel center;
    private static JPanel west;
    private static JPanel east;
    private static JPanel south;
    private static JPanel north;

    public static void addComponentsToPane(Container contentPane) {
        contentPane1 = contentPane;
        contentPane.setLayout(new BorderLayout(5, 5));

        if (!(contentPane.getLayout() instanceof BorderLayout)) {
            contentPane.add(new JLabel("Container doesn't use BorderLayout!"));
            return;
        }

        if (RIGHT_TO_LEFT) {
            contentPane.setComponentOrientation(
                    java.awt.ComponentOrientation.RIGHT_TO_LEFT);
        }

    }

    public static void addSouthSection() {
        SouthSection southSection = new SouthSection();
        south = southSection.getInitiatedPanel();
        addComponentListener(south);
        contentPane1.add(south, BorderLayout.SOUTH);
    }

    public static void addEastSection() {
        EastSection eastSection = new EastSection();
        east = eastSection.getInitiatedPanel();

        contentPane1.add(east, BorderLayout.EAST);
    }

    // east section
    public static void addWestSection() {
        //adding the EastSection
        WestSection westSection = new WestSection();
        west = westSection.getInitiatedPanel();
        contentPane1.add(west, BorderLayout.WEST);
    }

    public static void addCenter() {
//        Center center = new Center();
//        center.addTextEditor(new DefaultStyledDocument(), "Mohamed Texting");
//        contentPane1.add(center.getCenterPanel(), BorderLayout.CENTER);
        center = new Center().getInitiatedPanel();
        addComponentListener(center);
        contentPane1.add(center, BorderLayout.CENTER);
    }


    public static void addNorthSection() {
        NorthSection northSection = new NorthSection();
        north = northSection.getInitiatedPanel();
        addComponentListener(center);
        contentPane1.add(north, BorderLayout.NORTH);
    }

    public static void refrechOnUpDate() {
        SwingUtilities.invokeLater(() -> {
            contentPane1.validate();
            contentPane1.repaint();
        });
    }

    public static void addComponentListener(Component component) {
        component.addComponentListener(new ComponentListener() {
            @Override
            public void componentResized(ComponentEvent e) {
                refrechOnUpDate();
            }

            @Override
            public void componentMoved(ComponentEvent e) {
                refrechOnUpDate();
            }

            @Override
            public void componentShown(ComponentEvent e) {
                refrechOnUpDate();
            }

            @Override
            public void componentHidden(ComponentEvent e) {
                refrechOnUpDate();
            }
        });
    }



}
