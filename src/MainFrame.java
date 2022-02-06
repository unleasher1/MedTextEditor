import BackGroundDeamon.StatController.StatusTracker;
import BackGroundDeamon.Syntax.Slicer.Slicer;
import UI.Initiators.MenuInitiator;

import javax.swing.*;

public class MainFrame extends JFrame {
    JFrame frame;
    JPanel container;
    JMenuBar menuBar;

    public MainFrame() {
        // instancing the main components
        frame = new JFrame();
        container = new JPanel();
        JTextPane textPane = new JTextPane();


        // menuBar
        MenuInitiator initiator = new MenuInitiator();
        menuBar = initiator.initiate();


        frame.add(container);

        //setting the frame
        frame.setLocationRelativeTo(null);
        frame.setSize(600, 500);
        frame.setJMenuBar(menuBar);
        frame.add(textPane);
        //adding stat tracker
        StatusTracker tracker = new StatusTracker(textPane);


        frame.setVisible(true);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        MainFrame frame = new MainFrame();
        Slicer slicer =
                new Slicer("Mohamed Jlassi; what are the best programming language \n hello ");
    }
}
