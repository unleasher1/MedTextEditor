package UI.Initiators.CustomComponents.InternalValues;

import java.awt.*;

public class ColorSchema {
    private final Color primiry;
    private final Color secondary;
    private final Color border;
    private final Color Text;
    private final Color transparent = new Color(Color.TRANSLUCENT);

    public ColorSchema(Color primary, Color secondary, Color border, Color text) {
        this.primiry = primary;
        this.secondary = secondary;
        this.border = border;
        Text = text;
    }

    public Color getPrimiry() {
        return primiry;
    }

    public Color getSecondary() {
        return secondary;
    }

    public Color getBorder() {
        return border;
    }

    public Color getText() {
        return Text;
    }
}
