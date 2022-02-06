package UI.Initiators.Sections;

import UI.Initiators.CustomComponents.CustomJPanel;
import UI.Initiators.CustomComponents.GenerateRotatedLable;
import UI.Initiators.CustomComponents.InternalValues.ResizeDirection;
import UI.Initiators.CustomComponents.InternalValues.UIStyle;
import UI.Initiators.CustomComponents.InternalValues.UIType;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class WestSection {
    boolean drag = false;
    Point dragLocation = new Point();
    JPanel westContainerPanel; // the container for all components in this section
    JPanel ButtonContainer;
    CustomJPanel fileTreeContainer; // the container for the file tree component.
    JTree fileTree;
    private boolean showFIletree;

    /**
     * East section will contain
     * file tree for now
     * this class will be improved later.
     */
    public WestSection() {
        westContainerPanel = new JPanel(new BorderLayout());
        initTree();
        initTreeSection();
        initFileButtonContainer();
        ButtonContainer.setBackground(UIStyle.getDark().getPrimiry());
        westContainerPanel.add(ButtonContainer, BorderLayout.WEST);
        fileTreeContainer.setBackground(UIStyle.getDark().getSecondary());
        westContainerPanel.add(fileTreeContainer, BorderLayout.CENTER);
        initStructureButton();
    }

    private void initFileButtonContainer() {
        JLabel project = GenerateRotatedLable.generate("project");
        project.setOpaque(true);
        project.setBackground(Color.BLACK);
        project.setForeground(Color.ORANGE);
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
                showFIletree = !showFIletree;
                fileTreeContainer.setVisible(showFIletree);
            }
        });

        ButtonContainer = new JPanel();
        ButtonContainer.setPreferredSize(new Dimension(20, JFrame.MAXIMIZED_HORIZ));


        ButtonContainer.add(project, BorderLayout.NORTH);
    }

    private void initStructureButton() {
        JLabel structuere = GenerateRotatedLable.generate("Structure");
        structuere.setBackground(new Color(120, 23, 250));
        structuere.setOpaque(true);
        structuere.setPreferredSize(new Dimension(20, 80));
        JPanel StructureButtonContainer = new JPanel();
        StructureButtonContainer.add(structuere);
        ButtonContainer.add(StructureButtonContainer, BorderLayout.SOUTH);

    }

    private void initTreeSection() {

        fileTreeContainer = new CustomJPanel(UIType.DARK);
        fileTreeContainer.add(fileTree);
        fileTreeContainer.setDirection(ResizeDirection.West_East);
        fileTreeContainer.setSize(200, JFrame.MAXIMIZED_HORIZ);

        fileTreeContainer.setVisible(showFIletree);
        showFIletree = !showFIletree;

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
    }


    public JPanel getWestContainerPanel() {
        return westContainerPanel;
    }
}
