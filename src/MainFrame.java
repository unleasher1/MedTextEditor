import UI.CustomComponents.InternalValues.UIType;
import UI.CustomComponents.MButton;
import UI.CustomComponents.MFrame;
import UI.CustomComponents.MMenuComponents.MMenuBar;
import UI.CustomComponents.MPanel;
import UI.Initiators.Components.MenuBarInitiator;
import UI.Initiators.ContentPaneInit;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {
    public static boolean RIGHT_TO_LEFT = false;
    MFrame frame;
    Container container;
    JMenuBar menuBar;


    public MainFrame() {
        // instancing the main components

        frame = new MFrame(UIType.DARK);

        container = frame.getContentPane();

        ImageIcon close = new ImageIcon("Resources\\close.png");
        System.out.println(close.getIconHeight());

        MButton button = new MButton(close, UIType.DARK);
        button.setForGroundTransParent(true);
        button.setBackgroundTransParent(true);


        button.addActionListener(e -> frame.dispose());
        button.setPreferredSize(new Dimension(15, 15));
        button.setSize(new Dimension(15, 15));


        // menuBar
        MenuBarInitiator initiator = new MenuBarInitiator();
        MMenuBar menuBar = initiator.initiate();
        MPanel spacer = new MPanel(UIType.DARK);

        menuBar.add(spacer, BorderLayout.CENTER);

        menuBar.add(button, BorderLayout.WEST);


        // menuBar


        //setting the frame

        frame.setPreferredSize(new Dimension(700, 700));
        frame.setSize(700, 700);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setJMenuBar(menuBar);
        ContentPaneInit.addComponentsToPane(frame.getContentPane());

        //adding the east section
        ContentPaneInit.addWestSection();
        // adding center
        ContentPaneInit.addCenter();
        //adding and getting the FileTree
        ContentPaneInit.addNorthSection();

        ContentPaneInit.addSouthSection();
        ContentPaneInit.addEastSection();
        //adding Director
        frame.setVisible(true);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }


    public static void main(String[] args) {
        MainFrame frame = new MainFrame();


    }
}
