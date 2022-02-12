package UI.CustomComponents;

import UI.CustomComponents.InternalValues.UIType;

import java.awt.*;
import java.awt.geom.AffineTransform;

public class VerticalMLabel extends MLabel {
    private boolean needsRotate;

    public VerticalMLabel(String text, UIType style) {
        super(text,style);
    }

    @Override
    public Dimension getSize() {
        if (!needsRotate) {
            return super.getSize();
        }

        Dimension size = super.getSize();
        return new Dimension(size.height, size.width);

    }

    @Override
    public int getHeight() {
        return getSize().height;
    }

    @Override
    public int getWidth() {
        return getSize().width;
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D gr = (Graphics2D) g.create();


        gr.translate(0, getSize().getHeight());
        gr.transform(AffineTransform.getQuadrantRotateInstance(-1));


        needsRotate = true;
        super.paintComponent(gr);
        needsRotate = false;
    }


}
