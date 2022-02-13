package UI.Initiators.Components;

import UI.CustomComponents.InternalValues.UIType;
import UI.CustomComponents.MFrame;
import UI.CustomComponents.MMenuComponents.MMenu;
import UI.CustomComponents.MMenuComponents.MMenuBar;
import UI.CustomComponents.MMenuComponents.MMenuItem;

import javax.swing.*;
import java.awt.*;

public class MenuBarInitiator {
    MMenuBar menuBar;

    public MenuBarInitiator() {
        this.menuBar = new MMenuBar(UIType.DARK);
        setBackAndFor(menuBar);
    }

    public MMenuBar initiate() {
        initComponents();
        return menuBar;
    }

    private void setBackAndFor(JComponent component) {
        component.setBackground(Color.BLACK);
        component.setForeground(Color.CYAN);
    }

    private void initComponents() {
        //File Menu

        MMenu fileMenu = new MMenu("file", UIType.DARK);

        MMenuItem newItem = new MMenuItem("new", UIType.DARK);

        newItem.addActionListener(e -> System.out.println("new Triggred"));
        MMenuItem saveItem = new MMenuItem("save", UIType.DARK);
        saveItem.addActionListener(e -> {
            System.out.println("save Triggred");
            MFrame mFrame = new MFrame(UIType.DARK);
            mFrame.setVisible(true);
        });

        MMenuItem openItem = new MMenuItem("open", UIType.DARK);
        openItem.addActionListener(e -> System.out.println("open Triggred"));

        MMenuItem closeItem = new MMenuItem("close", UIType.DARK);
        closeItem.addActionListener(e -> System.out.println("close Triggred"));

        fileMenu.add(newItem);
        fileMenu.add(saveItem);
        fileMenu.add(openItem);
        fileMenu.add(closeItem);

        UIType type = UIType.DARK;
        //Edit Menu
        MMenu editMenu = new MMenu("edit", type);

        MMenuItem undoItem = new MMenuItem("undo", type);
        undoItem.addActionListener(e -> System.out.println("undo Triggred"));

        MMenuItem sudoItem = new MMenuItem("sudo", type);
        sudoItem.addActionListener(e -> System.out.println("sudo Triggred"));

        MMenuItem searchItem = new MMenuItem("search", type);
        searchItem.addActionListener(e -> System.out.println("search Triggred"));

        editMenu.add(undoItem);
        editMenu.add(sudoItem);
        editMenu.add(searchItem);

        //About Menu
        MMenu about = new MMenu("about", type);

        MMenuItem version = new MMenuItem("version", type);
        version.addActionListener(e -> System.out.println("version Triggred"));
        MMenuItem aboutDev = new MMenuItem("AboutDev", type);
        aboutDev.addActionListener(e -> System.out.println("aboutDev Triggered"));

        about.add(version);
        about.add(aboutDev);

        // Help Menu
        MMenu help = new MMenu("help", type);

        MMenuItem getHelp = new MMenuItem("getHelp", type);
        help.add(getHelp);
        // adding the MenuBar
        menuBar.add(fileMenu);
        menuBar.add(editMenu);
        menuBar.add(about);
        menuBar.add(help);

    }

}
