package UI.CustomComponents;

import UI.CustomComponents.InternalValues.ColorSchema;
import UI.CustomComponents.InternalValues.ResizeDirection;
import UI.CustomComponents.InternalValues.UIStyle;
import UI.CustomComponents.InternalValues.UIType;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

public class MPanel extends JPanel implements MComponent {
    private ColorSchema schema;
    private boolean drag = false;
    private ResizeDirection direction;
    private Point dragPoint = new Point();
    private MComponent parent;

    /**
     * Creates a new JPanel with the specified layout manager and buffering
     * strategy.
     *
     * @param layout           the LayoutManager to use
     * @param isDoubleBuffered a boolean, true for double-buffering, which
     *                         uses additional memory space to achieve fast, flicker-free
     */
    public MPanel(LayoutManager layout, boolean isDoubleBuffered, UIType style) {
        super(layout, isDoubleBuffered);
        setStyle(style);
        effectStyle();
    }

    /**
     * Create a new buffered JPanel with the specified layout manager
     *
     * @param layout the LayoutManager to use
     */
    public MPanel(LayoutManager layout, UIType style) {
        super(layout);
        setStyle(style);
        effectStyle();

    }

    /**
     * Creates a new <code>JPanel</code> with <code>FlowLayout</code>
     * and the specified buffering strategy.
     * If <code>isDoubleBuffered</code> is true, the <code>JPanel</code>
     * will use a double buffer.
     *
     * @param isDoubleBuffered a boolean, true for double-buffering, which
     *                         uses additional memory space to achieve fast, flicker-free
     *                         updates
     */
    public MPanel(boolean isDoubleBuffered, UIType style) {
        super(isDoubleBuffered);
        setStyle(style);
        effectStyle();
    }

    /**
     * Creates a new <code>JPanel</code> with a double buffer
     * and a flow layout.
     */
    public MPanel(UIType style) {
        setStyle(style);
        effectStyle();

    }

    public boolean isDrag() {
        return drag;
    }

    public void setDirection(ResizeDirection direction) {
        this.direction = direction;
    }

    private void setCursor() {
        this.setCursor(new Cursor(Cursor.E_RESIZE_CURSOR));
    }

    private void resetCursor() {
        this.setCursor(Cursor.getDefaultCursor());
    }

    private void refrech() {
        getParent().validate();
        getParent().repaint();
    }

    public void isResizable(boolean resizable) {
        if (resizable) {
            setResizable();
        }
    }

    private void setResizable() {

        addMouseListener(new MouseAdapter() {
            /**
             * {@inheritDoc}
             *
             * @param e
             */
            @Override
            public void mousePressed(MouseEvent e) {
                drag = true;
                e.getPoint();
                setCursor();


            }

            /**
             * {@inheritDoc}
             *
             * @param e
             */
            @Override
            public void mouseReleased(MouseEvent e) {
                drag = false;
                resetCursor();
            }
        });
        addMouseMotionListener(new MouseMotionAdapter() {
            /**
             * Invoked when a mouse button is pressed on a component and then
             * dragged.  Mouse drag events will continue to be delivered to
             * the component where the first originated until the mouse button is
             * released (regardless of whether the mouse position is within the
             * bounds of the component).
             *
             * @param e {@link MouseEvent}
             */
            @Override
            public void mouseDragged(MouseEvent e) {
                if (drag && direction == ResizeDirection.West_East) {
                    if (dragPoint.getX() != getWidth()) {
                        //setting the position

                        //setting the size
                        setSize((int) (getWidth() + (e.getPoint().getX() - dragPoint.getX())),
                                (getHeight()));
                        getParent().setSize((int) (getWidth() + (e.getPoint().getX() - dragPoint.getX())),
                                (getHeight()));
                        dragPoint = e.getPoint();


                    }
                    if (drag && (direction == ResizeDirection.East_West)) {
                        //setting the x
                        setAlignmentX((float) e.getPoint().getX());
                        setSize((int) (getWidth() + (e.getPoint().getX() - dragPoint.getX())),
                                (getHeight()));
                        getParent().setSize((int) (getWidth() + (e.getPoint().getX() - dragPoint.getX())),
                                (getHeight()));

                    }
                }

            }
        });

    }

    public void onChildUpDated(Component child) {
        this.validate();
        this.repaint();
    }

    public void onParentUpDated(Component parent) {

    }

    private void resizeCaseWEST_EAST() {

    }

    private void resizeCaseEAST_WEST() {

    }

    private void resizeCaseNORTH_SOUTH() {

    }

    private void resizeCaseSOUTH_WEST() {

    }

    public void addBorder() {
        Border border = BorderFactory.createLineBorder(schema.getBorder(), 3);
        super.setBorder(border);
    }

    /**
     * effect the style chosen  on this component
     */
    @Override
    public void effectStyle() {
        super.setBackground(schema.getPrimiry());
//        super.setForeground(schema.getSecondary());

    }

    @Override
/**
 * {@inheritDoc}
 */
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
            super.setBackground(schema.getTransparent());
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
            this.schema = getMParent().getSchema();
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

