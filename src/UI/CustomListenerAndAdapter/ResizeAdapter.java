package UI.CustomListenerAndAdapter;

import java.awt.*;
import java.awt.event.MouseAdapter;

public abstract class ResizeAdapter extends MouseAdapter {
    protected Component parent;

    public ResizeAdapter(Component parent) {
        this.parent = parent;
    }

    public abstract boolean resizeEnded();

    public abstract boolean resizeBegun();
}
