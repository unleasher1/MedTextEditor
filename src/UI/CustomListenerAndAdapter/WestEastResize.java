package UI.CustomListenerAndAdapter;

import java.awt.*;
import java.awt.event.MouseEvent;

public class WestEastResize extends ResizeAdapter {

    public WestEastResize(Component parent) {
        super(parent);
    }

    @Override
    public boolean resizeEnded() {
        return false;
    }

    @Override
    public boolean resizeBegun() {
        return false;
    }

    /**
     * {@inheritDoc}
     *
     * @param e
     */
    @Override
    public void mousePressed(MouseEvent e) {
        super.mousePressed(e);
    }

    /**
     * {@inheritDoc}
     *
     * @param e
     * @since 1.6
     */
    @Override
    public void mouseDragged(MouseEvent e) {
        super.mouseDragged(e);
    }
}
