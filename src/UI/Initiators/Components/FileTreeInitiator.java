package UI.Initiators.Components;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;

public class FileTreeInitiator {
    JTree tree;

    public FileTreeInitiator() {
        // constructing the root nodes
        DefaultMutableTreeNode style = new DefaultMutableTreeNode("Style");
        DefaultMutableTreeNode color = new DefaultMutableTreeNode("color");
        DefaultMutableTreeNode font = new DefaultMutableTreeNode("font");
        // adding the root node to main root
        style.add(color);
        style.add(font);
        DefaultMutableTreeNode red = new DefaultMutableTreeNode("red");
        DefaultMutableTreeNode blue = new DefaultMutableTreeNode("blue");
        DefaultMutableTreeNode black = new DefaultMutableTreeNode("black");
        DefaultMutableTreeNode green = new DefaultMutableTreeNode("green");
        color.add(red);
        color.add(blue);
        color.add(black);
        color.add(green);
        //constrcuting the tree

        tree = new JTree(style);
        tree.setVisible(true);
        tree.setSize(100, 100);

    }

    public JTree getTree() {
        return this.tree;
    }
}
