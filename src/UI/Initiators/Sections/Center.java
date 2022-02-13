package UI.Initiators.Sections;

import UI.CustomComponents.InternalValues.UIType;
import UI.CustomComponents.MButton;
import UI.CustomComponents.MLabel;
import UI.CustomComponents.MPanel;
import UI.Initiators.Initiating;

import javax.swing.*;
import javax.swing.text.DefaultStyledDocument;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class Center implements Initiating {
    /**
     * center will have 2 main Panels
     * 1 for the file editor Text Panels
     * and the other for the file names
     */
    ArrayList<Runnable> StatusTrackers = new ArrayList<>();
    JPanel centerPanel;
    JPanel TextEditorContainer;
    MPanel fileTitleContainer;
    JTextPane TextEditor;
    MPanel relativePanel;
    ArrayList<DefaultStyledDocument> openedDocument = new ArrayList<>();
    ArrayList<JComponent> fileNameLabels = new ArrayList<>();


    boolean showFIletree = false;
    private int width;

    public Center() {
        centerPanel = new MPanel(new BorderLayout(), UIType.DARK);
        centerPanel.setPreferredSize(new Dimension(300, 300));
        centerPanel.setMinimumSize(new Dimension(300, 300));
        width = centerPanel.getWidth();
        centerPanel.setBorder(null);
        TextEditorContainer = new JPanel(new BorderLayout());
        relativePanel = new MPanel(new BorderLayout(), UIType.DARK);
        relativePanel.setBorder(null);


        fileTitleContainer = new MPanel(new FlowLayout(), UIType.DARK);
        fileTitleContainer.setBorder(null);
        relativePanel.add(fileTitleContainer, BorderLayout.WEST);


        centerPanel.add(relativePanel, BorderLayout.NORTH);
        centerPanel.add(TextEditorContainer, BorderLayout.CENTER);


        MButton addFile = new MButton("+", UIType.DARK);
        fileTitleContainer.add(addFile);
        addFile.addActionListener(e -> {
            addTextEditor(new DefaultStyledDocument(), "Unnamed");
            refresh(addFile.getParent());
        });
        addFile.setPreferredSize(new Dimension(30, 30));
        addFile.setSize(new Dimension(70, 30));
        fileTitleContainer.add(addFile, fileTitleContainer.getComponentCount() - 1);
        initTextContainer();
        refresh(fileTitleContainer);


    }


    public void addTextEditor(DefaultStyledDocument doc, String docName) {
        int index = openedDocument.indexOf(doc);
        if (index != -1) {
            fileNameLabels.get(index).setBackground(Color.ORANGE);
            TextEditor.setDocument(doc);
        } else {
            openedDocument.add(doc);
            JPanel panel = FileTitleContainer(doc, docName);
            System.out.println("new File created");
            fileTitleContainer.add(panel, FlowLayout.LEFT);
            fileNameLabels.add(panel);

            refresh(fileTitleContainer);

        }
    }

    private JPanel FileTitleContainer(DefaultStyledDocument document, String docName) {
        MPanel panel = new MPanel(UIType.DARK);
        panel.setBackgroundTransParent(true);
        MLabel titleLabel = addFileTitle(document, docName);
        titleLabel.setBackTranslucent();
        MButton quite = new MButton("x", UIType.DARK);
        quite.addActionListener(e -> {
            openedDocument.remove(document);
            fileNameLabels.remove(panel);
            destroy(panel);
            refresh(fileTitleContainer);


        });
        quite.setPreferredSize(new Dimension(20, 20));
        panel.add(titleLabel);
        panel.add(quite);

        return panel;
    }

    private void destroy(JComponent component) {
        Container parent = component.getParent();
        parent.remove(component);
        parent.validate();
        parent.repaint();

    }

    private void refresh(Component component) {
        component.getParent().validate();
        component.getParent().repaint();
    }

    private MLabel addFileTitle(DefaultStyledDocument doc, String docName) {
        MLabel textTitle = new MLabel(docName, UIType.DARK);


        //init MouseAdapter
        textTitle.addMouseListener(new MouseAdapter() {
            /**
             * {@inheritDoc}
             *
             * @param e
             */
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("Mouse Clicked on file : " + docName);
                addTextEditor(doc, docName);
            }
        });
        return textTitle;
    }

    private void initTextContainer() {
        DefaultStyledDocument wellcome = new DefaultStyledDocument();
        TextEditor = new JTextPane();
        TextEditorContainer.add(TextEditor, BorderLayout.CENTER);
    }

    @Override
    public JPanel getInitiatedPanel() {
        return centerPanel;
    }

}
