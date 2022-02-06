import BackGroundDeamon.StatController.StatusTracker;
import UI.Initiators.ContentPaneInit;
import UI.Initiators.CustomComponents.UIDirector.Director;
import UI.Initiators.MenuBarInitiator;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    public static boolean RIGHT_TO_LEFT = false;
    JFrame frame;
    Container conatainer;
    JMenuBar menuBar;


    public MainFrame() {
        // instancing the main components
        frame = new JFrame();
        conatainer = frame.getContentPane();

        // menuBar
        MenuBarInitiator initiator = new MenuBarInitiator();
        menuBar = initiator.initiate();


        //setting the frame

        frame.setPreferredSize(new Dimension(700, 700));
        frame.setSize(700, 700);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setJMenuBar(menuBar);
        //adding stat tracker

        ContentPaneInit.addComponentsToPane(frame.getContentPane());
        // adding and getting the TextPane
        JTextPane pane = ContentPaneInit.initTextPane();
        //adding status tracker to pane
        StatusTracker tracker = new StatusTracker(pane);
        //adding the east section
        ContentPaneInit.addWestSection();
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
