package UI.CustomComponents;

import UI.CustomComponents.InternalValues.ColorSchema;
import UI.CustomComponents.InternalValues.UIStyle;
import UI.CustomComponents.InternalValues.UIType;

import javax.swing.*;
import java.awt.*;

public class MButton extends JButton implements MComponent {
    ColorSchema schema;
    private MComponent parent;

    /**
     * Creates a button with no set text or icon.
     */
    public MButton(UIType style) {
        setStyle(style);
        effectStyle();
    }

    /**
     * Creates a button with an icon.
     *
     * @param icon the Icon image to display on the button
     */
    public MButton(Icon icon, UIType style) {
        super(icon);
        setStyle(style);
        effectStyle();
    }

    /**
     * Creates a button with text.
     *
     * @param text the text of the button
     */
    public MButton(String text, UIType style) {
        super(text);
        setStyle(style);
        effectStyle();
    }

    /**
     * Creates a button where properties are taken from the
     * <code>Action</code> supplied.
     *
     * @param a the <code>Action</code> used to specify the new button
     * @since 1.3
     */
    public MButton(Action a, UIType style) {
        super(a);
        setStyle(style);
        effectStyle();
    }

    /**
     * Creates a button with initial text and an icon.
     *
     * @param text the text of the button
     * @param icon the Icon image to display on the button
     */
    public MButton(String text, Icon icon, UIType style) {
        super(text, icon);
        setStyle(style);
        effectStyle();
    }

    /**
     * effect the style chosen  on this component
     */
    @Override
    public void effectStyle() {
        super.setBackground(schema.getSecondary());
        super.setForeground(schema.getText());
        super.setBorder(BorderFactory.createLineBorder(schema.getTransparent(), 1));
        super.setPreferredSize(new Dimension(70, 30));

    }

    /**
     * chose a style for this component
     * <pre>
     *     Values in this class <br>
     *     {@link UIStyle}<br>
     *     DARK
     *     LIGHT
     *     CUSTOM
     * </pre>
     *
     * @param style {@link UIType }
     */
    @Override
    public void setStyle(UIType style) {
        switch (style) {
            case DARK -> schema = UIStyle.getDark();
            case Light -> schema = UIStyle.getLight();
        }
    }

    /**
     * set Background to Transparent
     * <pre>
     *     possible before or after calling {@code paintComponent()}
     * </pre>
     *
     * @param isTransparent
     */
    @Override
    public void setBackgroundTransParent(boolean isTransparent) {
        if (isTransparent) {
            super.setBackground(schema.getTransparent());
        }
    }

    /**
     * /**
     * set Foreground to Transparent
     * <pre>
     *     possible before or after calling {@code paintComponent()}
     * </pre>
     *
     * @param isTransparent
     */
    @Override
    public void setForGroundTransParent(boolean isTransparent) {
        if (isTransparent) {
            super.setForeground(schema.getTransparent());
        }
    }

    /**
     * inherent Style from Parent Component
     *
     * @param DOinherent
     */
    @Override
    public void inherentStyle(boolean DOinherent) {
        if (DOinherent) {
            schema = parent.getSchema();
        }
    }

    /**
     * get the current schema of this component
     *
     * @return {@link ColorSchema}
     */
    @Override
    public ColorSchema getSchema() {
        return schema;
    }

    /**
     * returning the Parent of this component
     *
     * @return {@link MComponent}
     */
    @Override
    public MComponent getMParent() {
        return parent;
    }

    @Override
    public void setMParent(MComponent parent) {
        this.parent = parent;
    }
}
