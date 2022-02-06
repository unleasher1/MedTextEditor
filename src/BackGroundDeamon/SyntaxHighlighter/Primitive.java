package BackGroundDeamon.SyntaxHighlighter;

import javax.swing.*;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;
import java.awt.*;

public class Primitive {
    JTextPane pane;
    Style style;
    StyleContext context;

    public Primitive(JTextPane pane) {
        this.pane = pane;
        context = new StyleContext();
        style = context.addStyle("primitives", null);
        StyleConstants.setForeground(style, Color.YELLOW);
    }

    public Style getStyle() {
        return style;
    }
    public void drawStyle(int offset, int end) {
        System.out.println("offset = " + offset + " end = " + end);
        try {
            pane.getStyledDocument().setCharacterAttributes(offset, end - offset + 1,
                    style.copyAttributes(), true);
            System.out.println("highlighter triggered");

        } catch (IllegalStateException k) {
            System.out.println(k.getMessage());
        }
    }
}
