package UI.Initiators.Sections;

import UI.Initiators.CustomComponents.ConsoleDocumentFilter;

import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.Document;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class SouthSection {
    private JPanel southContainer; // main container of this section
    private JPanel panelNamesConatiner; // the container of the tool names
    private JPanel toolContainer; // the container of the tool [console ,git ,run]
    private ArrayList<JPanel> toolNameContainers; // the tool Name containers
    private boolean consoleIsVisible = false;
    private Dimension expand = new Dimension(JFrame.MAXIMIZED_VERT, 300);
    private Dimension shrink = new Dimension(JFrame.MAXIMIZED_VERT, 36);

    public SouthSection() {
        southContainer = new JPanel(new BorderLayout());

        southContainer.setBackground(Color.YELLOW);
        southContainer.setPreferredSize(shrink);
        toolContainer = new JPanel(new BorderLayout());

        southContainer.add(toolContainer, BorderLayout.CENTER);
        initConsol();
        initPanelNamesContainers();


    }

    public JPanel getSouthContainer() {
        return southContainer;
    }

    private void initConsol() {
        JTextPane console = new JTextPane();

        console.setBackground(Color.BLACK);
        console.setForeground(Color.white);
        DefaultStyledDocument document = new DefaultStyledDocument();
        ConsoleDocumentFilter consoleDocumentFilter = new ConsoleDocumentFilter();

        document.setDocumentFilter(consoleDocumentFilter);


        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy,mm,HH:mm:ss");
        LocalDateTime now = getInstancedate();
        String defaultString = "# " + dtf.format(now) + ">>> ";
        consoleDocumentFilter.setOffset(defaultString.length());
        consoleDocumentFilter.setDefaultString(defaultString);
        consoleDocumentFilter.setDocument(document);


        console.setDocument(document);
        console.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (e.getKeyChar() == '\n') {

//                        document.insertString(document.getLength(), ">", null);
                    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy,mm,HH:mm:ss");
                    LocalDateTime now = getInstancedate();
                    try {
                        document.insertString(0, "Mohamed jlassi", null);
                    } catch (BadLocationException ex) {
                        ex.printStackTrace();
                    }


                }
            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });
        JScrollPane consoleScroll = new JScrollPane(console);

        consoleScroll.setBounds(150, 500, 300, 800);
        consoleScroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);


        toolContainer.add(consoleScroll, BorderLayout.CENTER);

        toolContainer.setVisible(false);
        console.setPreferredSize(new Dimension(consoleScroll.getParent().getWidth(), consoleScroll.getParent().getHeight()));

    }

    private void initPanelNamesContainers() {
        panelNamesConatiner = new JPanel(new BorderLayout());
        panelNamesConatiner.setBackground(Color.GREEN);
        southContainer.add(panelNamesConatiner, BorderLayout.NORTH);
        JPanel console = new JPanel();
        Color my = new Color(204, 0, 255);
        console.setBackground(my);
        JLabel text = new JLabel("Console");
        JButton exite = new JButton("x");
        console.add(text, BorderLayout.WEST);
        console.add(exite, BorderLayout.WEST);
        console.addMouseListener(new MouseAdapter() {
            /**
             * {@inheritDoc}
             *
             * @param e
             */
            @Override
            public void mouseClicked(MouseEvent e) {
                consoleIsVisible = !consoleIsVisible;
                toolContainer.setVisible(consoleIsVisible);
                if (!consoleIsVisible) {
                    southContainer.setPreferredSize(shrink);
                } else {
                    southContainer.setPreferredSize(expand);
                }
                toolContainer.getParent().validate();
                toolContainer.getParent().repaint();
            }
        });

        panelNamesConatiner.add(console, BorderLayout.WEST);
    }

    private LocalDateTime getInstancedate() {

        return LocalDateTime.now();
    }

}

class addDocumentListener {
    static Document doc;

    public static void addDocumentListener1(Document doc1) {
        doc = doc1;
    }

    public void defaultStringHighLiter() {

    }


}

