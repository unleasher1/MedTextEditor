package UI.Initiators.Sections;

import UI.CustomComponents.InternalValues.UIStyle;
import UI.CustomComponents.InternalValues.UIType;
import UI.CustomComponents.MLabel;
import UI.CustomComponents.MPanel;
import UI.CustomComponents.VerticalMLabel;
import UI.Initiators.Initiating;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class WestSection implements Initiating {
    MPanel westContainerPanel; // the container for all components in this section
    JPanel ButtonContainer;
    MPanel wesToolContainer; // the container for the file tree component.
    JTree fileTree;
    private boolean showFileTree;
    private MPanel structureSection;
    private boolean structIsVis = false;
    private MPanel treeContainer;
    private boolean toolISshown = false;

    /**
     * East section will contain
     * file tree for now
     * this class will be improved later.
     */
    public WestSection() {
        westContainerPanel = new MPanel(new BorderLayout(), UIType.DARK);
        westContainerPanel.setName("west");
        westContainerPanel.setVisible(true);

        initTree();
        initToolSection();
        initTreeSection();
        initFileButtonContainer();

        westContainerPanel.add(ButtonContainer, BorderLayout.WEST);
        wesToolContainer.setBackground(UIStyle.getDark().getSecondary());
        westContainerPanel.add(wesToolContainer, BorderLayout.CENTER);
        initStructureSection();
        initStructureButton();
    }

    private void initFileButtonContainer() {
        VerticalMLabel project = new VerticalMLabel("Project", UIType.DARK);
        project.setName("project");
        project.setSize(new Dimension(20, 50));
        project.setPreferredSize(new Dimension(20, 50));


        project.addMouseListener(new MouseAdapter() {
            /**
             * {@inheritDoc}
             *
             * @param e
             */
            @Override
            public void mouseClicked(MouseEvent e) {
                showFileTree = !showFileTree;
                treeContainer.setVisible(showFileTree);
                fileTree.setVisible(showFileTree);
                wesToolContainer.setVisible(structIsVis || showFileTree);

            }
        });

        ButtonContainer = new MPanel(UIType.DARK);
        ButtonContainer.setPreferredSize(new Dimension(20, JFrame.MAXIMIZED_HORIZ));


        ButtonContainer.add(project, BorderLayout.NORTH);
    }

    private void initStructureButton() {
        VerticalMLabel structure = new VerticalMLabel("Structure", UIType.DARK);
        structure.setPreferredSize(new Dimension(20, 80));
        MPanel strcutButton = new MPanel(UIType.DARK);
        strcutButton.setBackgroundTransParent(true);
        strcutButton.add(structure);
        strcutButton.addMouseListener(new MouseAdapter() {
            /**
             * {@inheritDoc}
             *
             * @param e
             */
            @Override
            public void mouseClicked(MouseEvent e) {

                structIsVis = !structIsVis;
                wesToolContainer.setVisible(structIsVis || showFileTree);
                structureSection.setVisible(structIsVis);

            }
        });

        ButtonContainer.add(strcutButton, BorderLayout.SOUTH);

    }

    private void initToolSection() {

        wesToolContainer = new MPanel(UIType.DARK);
        wesToolContainer.add(fileTree);

        wesToolContainer.setSize(200, JFrame.MAXIMIZED_HORIZ);
        wesToolContainer.setPreferredSize(new Dimension(200, JFrame.MAXIMIZED_HORIZ));
        wesToolContainer.setVisible(showFileTree || structIsVis);
        wesToolContainer.setName("westToolContainer");


    }

    void initTreeSection() {
        treeContainer = new MPanel(UIType.DARK);
        treeContainer.setSize(180, JFrame.MAXIMIZED_HORIZ);
        treeContainer.setPreferredSize(new Dimension(200, JFrame.MAXIMIZED_HORIZ));
        wesToolContainer.add(treeContainer, BorderLayout.NORTH);

    }

    /**
     * for now this tree will have no parameter
     * But it will when I add the open command.
     */
    private void initTree() {
        DefaultMutableTreeNode root = new DefaultMutableTreeNode("root");
        DefaultMutableTreeNode root2 = new DefaultMutableTreeNode("root2");
        root.add(root2);
        fileTree = new JTree(root);
        fileTree.setSize(120, Frame.MAXIMIZED_HORIZ);
        fileTree.setPreferredSize(new Dimension(180, 500));
    }

    private void initStructureSection() {
        structureSection = new MPanel(UIType.DARK);
        structureSection.add(new MLabel("structure", UIType.DARK), BorderLayout.CENTER);
        structureSection.setSize(120, JFrame.MAXIMIZED_HORIZ);
        structureSection.setVisible(structIsVis);
        wesToolContainer.add(structureSection, BorderLayout.SOUTH);
    }


    @Override
    public JPanel getInitiatedPanel() {
        return westContainerPanel;
    }

}
