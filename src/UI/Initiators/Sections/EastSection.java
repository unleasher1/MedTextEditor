package UI.Initiators.Sections;

import UI.Initiators.CustomComponents.CustomJPanel;
import UI.Initiators.CustomComponents.InternalValues.ResizeDirection;
import UI.Initiators.CustomComponents.InternalValues.UIType;

import javax.swing.*;
import java.awt.*;

public class EastSection {
    CustomJPanel panel;

    public EastSection() {
        panel = new CustomJPanel(UIType.DARK);
        panel.setDirection(ResizeDirection.East_West);

        panel.setSize(new Dimension(120, JFrame.MAXIMIZED_HORIZ));
    }

    public CustomJPanel getPanel() {
        return panel;
    }
}
