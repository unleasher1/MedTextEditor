package BackGroundDeamon.SyntaxHighlighter;

import javax.swing.*;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;
import java.awt.*;

public class Default {
    JTextPane pane;
    StyleContext context;
    Style style;

    public Default(JTextPane pane) {
        this.pane = pane;
        context = new StyleContext();
        style = context.addStyle("visibilities", null);
        StyleConstants.setForeground(style, Color.ORANGE);

    }

    public Style getStyle() {
        return style;
    }
}
