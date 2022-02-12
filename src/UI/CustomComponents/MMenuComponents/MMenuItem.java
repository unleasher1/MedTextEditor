package UI.CustomComponents.MMenuComponents;

import UI.CustomComponents.InternalValues.ColorSchema;
import UI.CustomComponents.InternalValues.UIStyle;
import UI.CustomComponents.InternalValues.UIType;
import UI.CustomComponents.MComponent;

import javax.swing.*;

public class MMenuItem extends JMenuItem implements MComponent {
    private UIType style;
    private ColorSchema schema;
    private MComponent parent;

    /**
     * Creates a <code>JMenuItem</code> with no set text or icon.
     */
    public MMenuItem(UIType style) {

        setStyle(style);
        effectStyle();
    }

    /**
     * Creates a <code>JMenuItem</code> with the specified icon.
     *
     * @param icon the icon of the <code>JMenuItem</code>
     */
    public MMenuItem(Icon icon, UIType style) {
        super(icon);

        setStyle(style);
        effectStyle();
    }

    /**
     * Creates a <code>JMenuItem</code> with the specified text.
     *
     * @param text the text of the <code>JMenuItem</code>
     */
    public MMenuItem(String text, UIType style) {
        super(text);

        setStyle(style);
        effectStyle();
    }


    /**
     * Creates a menu item whose properties are taken from the
     * specified <code>Action</code>.
     *
     * @param a the action of the <code>JMenuItem</code>
     * @since 1.3
     */
    public MMenuItem(Action a, UIType style) {
        super(a);

        setStyle(style);
        effectStyle();
    }

    /**
     * Creates a <code>JMenuItem</code> with the specified text and icon.
     *
     * @param text the text of the <code>JMenuItem</code>
     * @param icon the icon of the <code>JMenuItem</code>
     */
    public MMenuItem(String text, Icon icon, UIType style) {
        super(text, icon);

        setStyle(style);
        effectStyle();
    }

    /**
     * Creates a <code>JMenuItem</code> with the specified text and
     * keyboard mnemonic.
     *
     * @param text     the text of the <code>JMenuItem</code>
     * @param mnemonic the keyboard mnemonic for the <code>JMenuItem</code>
     */
    public MMenuItem(String text, int mnemonic, UIType style) {
        super(text, mnemonic);
    }

    /**
     * effect the style chosen  on this component
     */
    @Override
    public void effectStyle() {
        super.setBackground(schema.getSecondary());
        super.setForeground(schema.getText());
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
