package UI.CustomComponents;

import UI.CustomComponents.InternalValues.ColorSchema;
import UI.CustomComponents.InternalValues.UIStyle;
import UI.CustomComponents.InternalValues.UIType;

import javax.swing.*;

public class MLabel extends JLabel implements MComponent {
    private ColorSchema schema;
    private MComponent parent;

    /**
     * Creates a <code>JLabel</code> instance with the specified
     * text, image, and horizontal alignment.
     * The label is centered vertically in its display area.
     * The text is on the trailing edge of the image.
     *
     * @param text                The text to be displayed by the label.
     * @param icon                The image to be displayed by the label.
     * @param horizontalAlignment One of the following constants
     *                            defined in <code>SwingConstants</code>:
     *                            <code>LEFT</code>,
     *                            <code>CENTER</code>,
     *                            <code>RIGHT</code>,
     *                            <code>LEADING</code> or
     */
    public MLabel(String text, Icon icon, int horizontalAlignment, UIType style) {
        super(text, icon, horizontalAlignment);
        setStyle(style);
        effectStyle();
    }

    /**
     * Creates a <code>JLabel</code> instance with the specified
     * text and horizontal alignment.
     * The label is centered vertically in its display area.
     *
     * @param text                The text to be displayed by the label.
     * @param horizontalAlignment One of the following constants
     *                            defined in <code>SwingConstants</code>:
     *                            <code>LEFT</code>,
     *                            <code>CENTER</code>,
     *                            <code>RIGHT</code>,
     *                            <code>LEADING</code> or
     */
    public MLabel(String text, int horizontalAlignment, UIType style) {
        super(text, horizontalAlignment);
        setStyle(style);
        effectStyle();
    }

    /**
     * Creates a <code>JLabel</code> instance with the specified text.
     * The label is aligned against the leading edge of its display area,
     * and centered vertically.
     *
     * @param text The text to be displayed by the label.
     */
    public MLabel(String text, UIType style) {
        super(text);
        setStyle(style);
        effectStyle();
    }

    /**
     * Creates a <code>JLabel</code> instance with the specified
     * image and horizontal alignment.
     * The label is centered vertically in its display area.
     *
     * @param image               The image to be displayed by the label.
     * @param horizontalAlignment One of the following constants
     *                            defined in <code>SwingConstants</code>:
     *                            <code>LEFT</code>,
     *                            <code>CENTER</code>,
     *                            <code>RIGHT</code>,
     *                            <code>LEADING</code> or
     */
    public MLabel(Icon image, int horizontalAlignment, UIType style) {
        super(image, horizontalAlignment);
        setStyle(style);
        effectStyle();
    }

    /**
     * Creates a <code>JLabel</code> instance with the specified image.
     * The label is centered vertically and horizontally
     * in its display area.
     *
     * @param image The image to be displayed by the label.
     */
    public MLabel(Icon image, UIType style) {
        super(image);
        setStyle(style);
        effectStyle();
    }

    /**
     * Creates a <code>JLabel</code> instance with
     * no image and with an empty string for the title.
     * The label is centered vertically
     * in its display area.
     * The label's contents, once set, will be displayed on the leading edge
     * of the label's display area.
     */
    public MLabel(UIType style) {
        setStyle(style);
        effectStyle();
    }


    public void setBackTranslucent() {
        super.setBackground(schema.getSecondary());

    }

    /**
     * effect the style chosen  on this component
     */
    @Override
    public void effectStyle() {
        super.setOpaque(true);
        super.setBackground(schema.getPrimiry());
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
            case DARK -> this.schema = UIStyle.getDark();
            case Light -> this.schema = UIStyle.getLight();
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

    }

    /**
     * inherent Style from Parent Component
     *
     * @param DOinherent
     */
    @Override
    public void inherentStyle(boolean DOinherent) {

    }

    /**
     * get the current schema of this component
     *
     * @return {@link ColorSchema}
     */
    @Override
    public ColorSchema getSchema() {
        return this.schema;
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
