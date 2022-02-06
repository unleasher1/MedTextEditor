package UI.Initiators.CustomComponents;

import UI.Initiators.CustomComponents.InternalValues.ColorSchema;
import UI.Initiators.CustomComponents.InternalValues.ResizeDirection;
import UI.Initiators.CustomComponents.InternalValues.UIStyle;
import UI.Initiators.CustomComponents.InternalValues.UIType;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

public class CustomJPanel extends JPanel {
    private ColorSchema shema;
    private boolean drag = false;
    private ResizeDirection direction;
    private Point dragPoint = new Point();

    /**
     * Creates a new JPanel with the specified layout manager and buffering
     * strategy.
     *
     * @param layout           the LayoutManager to use
     * @param isDoubleBuffered a boolean, true for double-buffering, which
     *                         uses additional memory space to achieve fast, flicker-free
     */
    public CustomJPanel(LayoutManager layout, boolean isDoubleBuffered, UIType style) {
        super(layout, isDoubleBuffered);
        effectStyle(style);
    }

    /**
     * Create a new buffered JPanel with the specified layout manager
     *
     * @param layout the LayoutManager to use
     */
    public CustomJPanel(LayoutManager layout, UIType style) {
        super(layout);
        effectStyle(style);
        isResizable(true);
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
    public CustomJPanel(boolean isDoubleBuffered, UIType style) {
        super(isDoubleBuffered);
        effectStyle(style);
        isResizable(true);
    }

    /**
     * Creates a new <code>JPanel</code> with a double buffer
     * and a flow layout.
     */
    public CustomJPanel(UIType style) {
        effectStyle(style);
        isResizable(true);
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
            setResiable();
        }
    }

    private void setResiable() {

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

    private void resizeCaseWEST_EAST() {

    }

    private void resizeCaseEAST_WEST() {

    }

    private void resizeCaseNORTH_SOUTH() {

    }

    private void resizeCaseSOUTH_WEST() {

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
        super.setBackground(shema.getSecondary());
        super.setForeground(shema.getPrimiry());
        Border border = BorderFactory.createLineBorder(shema.getBorder(), 3);
        super.setBorder(border);
    }


}
