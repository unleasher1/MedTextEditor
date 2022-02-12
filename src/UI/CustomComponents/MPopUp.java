package UI.CustomComponents;

import UI.CustomComponents.InternalValues.ColorSchema;
import UI.CustomComponents.InternalValues.UIStyle;
import UI.CustomComponents.InternalValues.UIType;

import javax.swing.*;
import javax.swing.border.Border;

public class MPopUp extends JPopupMenu {
    private ColorSchema shema;

    /**
     * Constructs a <code>JPopupMenu</code> without an "invoker".
     */
    public MPopUp(UIType style) {
        effectStyle(style);
    }

    /**
     * Constructs a <code>JPopupMenu</code> with the specified title.
     *
     * @param label the string that a UI may use to display as a title
     *              for the popup menu.
     */
    public MPopUp(String label, UIType style) {
        super(label);
        effectStyle(style);
    }

    public void setStyle(UIType type) {
        switch (type) {

            case DARK -> shema = UIStyle.getDark();
            case Light -> shema = UIStyle.getLight();
        }
        System.out.println(type.name());
    }

    private void effectStyle(UIType style) {
        setStyle(style);
        JFrame.setDefaultLookAndFeelDecorated(false);
        super.setBackground(shema.getSecondary());
        super.setForeground(shema.getPrimiry());
        Border border = BorderFactory.createLineBorder(shema.getBorder(), 2);
        super.setBorder(border);


    }
}
