package UI.Initiators;

import UI.Initiators.CustomComponents.CustomJFrame;
import UI.Initiators.CustomComponents.InternalValues.UIType;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuBarInitiator {
    JMenuBar menuBar;

    public MenuBarInitiator() {
        this.menuBar = new JMenuBar();
        this.menuBar.setBorderPainted(true);
        setBackAndFor(menuBar);
    }

    public JMenuBar initiate() {
        initComponents();
        return menuBar;
    }

    private void setBackAndFor(JComponent component) {
        component.setBackground(Color.BLACK);
        component.setForeground(Color.CYAN);
    }

    private void initComponents() {
        //File Menu
        JMenu fileMenu = new JMenu("file");
        setBackAndFor(fileMenu);
        JMenuItem newItem = new JMenuItem("new");
        newItem.addActionListener(e -> System.out.println("new Triggred"));
        setBackAndFor(newItem);
        JMenuItem saveItem = new JMenuItem("save");
        saveItem.addActionListener(e -> {
            System.out.println("save Triggred");
            CustomJFrame customJFrame = new CustomJFrame(UIType.DARK);
            customJFrame.setVisible(true);
        });
        setBackAndFor(saveItem);
        JMenuItem openItem = new JMenuItem("open");
        openItem.addActionListener(e -> System.out.println("open Triggred"));
        setBackAndFor(openItem);
        JMenuItem closeItem = new JMenuItem("close");
        closeItem.addActionListener(e -> System.out.println("close Triggred"));
        setBackAndFor(closeItem);
        fileMenu.add(newItem);
        fileMenu.add(saveItem);
        fileMenu.add(openItem);
        fileMenu.add(closeItem);


        //Edit Menu
        JMenu editMenu = new JMenu("edit");
        setBackAndFor(editMenu);
        JMenuItem undoItem = new JMenuItem("undo");
        undoItem.addActionListener(e -> System.out.println("undo Triggred"));
        setBackAndFor(undoItem);
        JMenuItem sudoItem = new JMenuItem("sudo");
        sudoItem.addActionListener(e -> System.out.println("sudo Triggred"));
        setBackAndFor(sudoItem);
        JMenuItem searchItem = new JMenuItem("search");
        searchItem.addActionListener(e -> System.out.println("search Triggred"));
        setBackAndFor(searchItem);

        editMenu.add(undoItem);
        editMenu.add(sudoItem);
        editMenu.add(searchItem);

        //About Menu
        JMenu about = new JMenu("about");
        setBackAndFor(about);
        JMenuItem version = new JMenuItem("version");
        version.addActionListener(e -> System.out.println("version Triggred"));
        setBackAndFor(version);
        JMenuItem aboutDev = new JMenuItem("AboutDev");
        aboutDev.addActionListener(e -> System.out.println("aboutDev Triggered"));
        setBackAndFor(aboutDev);
        about.add(version);
        about.add(aboutDev);

        // Help Menu
        JMenu help = new JMenu("help");
        setBackAndFor(help);
        JMenuItem getHelp = new JMenuItem("getHelp");
        setBackAndFor(getHelp);
        help.add(getHelp);
        // adding the MenuBar
        menuBar.add(fileMenu);
        menuBar.add(editMenu);
        menuBar.add(about);
        menuBar.add(help);

    }

}
