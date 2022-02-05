import javax.swing.*;

public class MainFrame extends JFrame {
    JFrame frame;
    JTextArea textArea;
    JMenuBar menuBar;
    public MainFrame(){
        // instancing the main components
        frame = new JFrame();
        textArea = new JTextArea();
        menuBar = new JMenuBar();
        // menuBar
        JMenu menuFile = new JMenu("File");
        JMenuItem newItem = new JMenuItem("New");
        JMenuItem openItem = new JMenuItem("Open");
        JMenuItem saveItem = new JMenuItem("save");
        menuFile.add(newItem);
        menuFile.add(openItem);
        menuFile.add(saveItem);
    }
    public static void main(String[] args){

    }
}
