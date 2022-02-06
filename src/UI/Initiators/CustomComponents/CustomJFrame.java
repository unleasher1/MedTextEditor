package UI.Initiators.CustomComponents;

import UI.Initiators.CustomComponents.InternalValues.ColorSchema;
import UI.Initiators.CustomComponents.InternalValues.UIStyle;
import UI.Initiators.CustomComponents.InternalValues.UIType;

import javax.swing.*;
import java.awt.*;

public class CustomJFrame extends JFrame {
    ColorSchema shema;

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
    public CustomJFrame(UIType style) throws HeadlessException {
        effectStyle(style);
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
    public CustomJFrame(GraphicsConfiguration gc, UIType style) {
        super(gc);
        effectStyle(style);
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
    public CustomJFrame(String title, UIType style) throws HeadlessException {
        super(title);
        effectStyle(style);
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
    public CustomJFrame(String title, GraphicsConfiguration gc, UIType style) {
        super(title, gc);
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
        super.setUndecorated(true);
        super.setPreferredSize(new Dimension(120, 120));
        super.setSize(new Dimension(120, 120));
        super.getContentPane().setBackground(shema.getPrimiry());
        super.getContentPane().setForeground(shema.getSecondary());


    }


}
