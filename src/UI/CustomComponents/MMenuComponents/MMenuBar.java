package UI.CustomComponents.MMenuComponents;

import UI.CustomComponents.InternalValues.ColorSchema;
import UI.CustomComponents.InternalValues.UIStyle;
import UI.CustomComponents.InternalValues.UIType;
import UI.CustomComponents.MComponent;

import javax.swing.*;
import javax.swing.border.Border;

public class MMenuBar extends JMenuBar implements MComponent {
    private ColorSchema schema;
    private MComponent parent;

    public MMenuBar(UIType style) {
        setStyle(style);
        effectStyle();
    }
    public void addBorder(){
        Border border = BorderFactory.createLineBorder(schema.getBorder(), 4);
        super.setBorder(border);
    }


    /**
     * effect the style chosen  on this component
     */
    @Override
    public void effectStyle() {
        super.setBackground(schema.getSecondary());
        super.setForeground(schema.getPrimiry());

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
            this.schema = parent.getSchema();
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
