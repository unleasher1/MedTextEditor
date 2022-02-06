package UI.Initiators.CustomComponents;

import UI.Initiators.CustomComponents.InternalValues.ColorSchema;
import UI.Initiators.CustomComponents.InternalValues.UIStyle;
import UI.Initiators.CustomComponents.InternalValues.UIType;

import javax.swing.*;
import javax.swing.border.Border;

public class CustomJPopUp extends JPopupMenu {
    private ColorSchema shema;

    /**
     * Constructs a <code>JPopupMenu</code> without an "invoker".
     */
    public CustomJPopUp(UIType style) {
        effectStyle(style);
    }

    /**
     * Constructs a <code>JPopupMenu</code> with the specified title.
     *
     * @param label the string that a UI may use to display as a title
     *              for the popup menu.
     */
    public CustomJPopUp(String label, UIType style) {
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
