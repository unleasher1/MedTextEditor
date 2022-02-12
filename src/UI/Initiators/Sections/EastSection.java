package UI.Initiators.Sections;

import UI.CustomComponents.MPanel;
import UI.CustomComponents.InternalValues.ResizeDirection;
import UI.CustomComponents.InternalValues.UIType;
import UI.Initiators.Initiating;

import javax.swing.*;
import java.awt.*;

public class EastSection implements Initiating {
    MPanel panel;

    public EastSection() {
        panel = new MPanel(UIType.DARK);
        panel.setDirection(ResizeDirection.East_West);

        panel.setSize(new Dimension(120, JFrame.MAXIMIZED_HORIZ));
    }



    @Override
    public JPanel getInitiatedPanel() {
        return panel;
    }
}
