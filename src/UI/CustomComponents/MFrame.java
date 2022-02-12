package UI.CustomComponents;

import UI.CustomComponents.InternalValues.ColorSchema;
import UI.CustomComponents.InternalValues.UIStyle;
import UI.CustomComponents.InternalValues.UIType;

import javax.swing.*;
import java.awt.*;

public class MFrame extends JFrame implements MComponent {

    ColorSchema schema;

    /**
     * Constructs a new frame that is initially invisible.
     * <p>
     * This constructor sets the component's locale property to the value
     * returned by <code>JComponent.getDefaultLocale</code>.
     *
     * @throws HeadlessException if GraphicsEnvironment.isHeadless()
     *                           returns true.
     * @see GraphicsEnvironment#isHeadless
     * @see Component#setSize
     * @see Component#setVisible
     * @see JComponent#getDefaultLocale
     */
    public MFrame(UIType style) throws HeadlessException {
        setStyle(style);
        effectStyle();
    }

    /**
     * Creates a <code>Frame</code> in the specified
     * <code>GraphicsConfiguration</code> of
     * a screen device and a blank title.
     * <p>
     * This constructor sets the component's locale property to the value
     * returned by <code>JComponent.getDefaultLocale</code>.
     *
     * @param gc the <code>GraphicsConfiguration</code> that is used
     *           to construct the new <code>Frame</code>;
     *           if <code>gc</code> is <code>null</code>, the system
     *           default <code>GraphicsConfiguration</code> is assumed
     * @throws IllegalArgumentException if <code>gc</code> is not from
     *                                  a screen device.  This exception is always thrown when
     *                                  GraphicsEnvironment.isHeadless() returns true.
     * @see GraphicsEnvironment#isHeadless
     * @see JComponent#getDefaultLocale
     * @since 1.3
     */
    public MFrame(GraphicsConfiguration gc, UIType style) {
        super(gc);
        setStyle(style);
        effectStyle();
    }

    /**
     * Creates a new, initially invisible <code>Frame</code> with the
     * specified title.
     * <p>
     * This constructor sets the component's locale property to the value
     * returned by <code>JComponent.getDefaultLocale</code>.
     *
     * @param title the title for the frame
     * @throws HeadlessException if GraphicsEnvironment.isHeadless()
     *                           returns true.
     * @see GraphicsEnvironment#isHeadless
     * @see Component#setSize
     * @see Component#setVisible
     * @see JComponent#getDefaultLocale
     */
    public MFrame(String title, UIType style) throws HeadlessException {
        super(title);
        setStyle(style);
        effectStyle();
    }

    /**
     * Creates a <code>JFrame</code> with the specified title and the
     * specified <code>GraphicsConfiguration</code> of a screen device.
     * <p>
     * This constructor sets the component's locale property to the value
     * returned by <code>JComponent.getDefaultLocale</code>.
     *
     * @param title the title to be displayed in the
     *              frame's border. A <code>null</code> value is treated as
     *              an empty string, "".
     * @param gc    the <code>GraphicsConfiguration</code> that is used
     *              to construct the new <code>JFrame</code> with;
     *              if <code>gc</code> is <code>null</code>, the system
     *              default <code>GraphicsConfiguration</code> is assumed
     * @throws IllegalArgumentException if <code>gc</code> is not from
     *                                  a screen device.  This exception is always thrown when
     *                                  GraphicsEnvironment.isHeadless() returns true.
     * @see GraphicsEnvironment#isHeadless
     * @see JComponent#getDefaultLocale
     * @since 1.3
     */
    public MFrame(String title, GraphicsConfiguration gc, UIType style) {
        super(title, gc);
        setStyle(style);
        effectStyle();
    }


    @Override
    public void setStyle(UIType type) {
        switch (type) {

            case DARK -> schema = UIStyle.getDark();
            case Light -> schema = UIStyle.getLight();
        }
        System.out.println(type.name());
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
        if(isTransparent){
            super.setBackground(schema.getTransparent());        }
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
        if (isTransparent){
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
        //TODO check if Frame can have parent
        //TODO if it can check how to create method to do so.

    }

    /**
     * get the current schema of this component
     *
     * @return {@link ColorSchema}
     */
    @Override
    public ColorSchema getSchema() {
        return null;
    }

    /**
     * returning the Parent of this component
     *
     * @return {@link MComponent}
     */
    @Override
    public MComponent getMParent() {
        return null;
    }

    @Override
    public void setMParent(MComponent parent) {

    }

    /**
     * effect the style chosen  on this component
     */
    @Override
    public void effectStyle() {
        super.setUndecorated(true);
        super.setPreferredSize(new Dimension(120, 120));
        super.setSize(new Dimension(120, 120));
        super.getContentPane().setBackground(schema.getPrimiry());
        super.getContentPane().setForeground(schema.getSecondary());
    }
}
