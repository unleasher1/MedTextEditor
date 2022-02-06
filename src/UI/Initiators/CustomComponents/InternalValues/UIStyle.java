package UI.Initiators.CustomComponents.InternalValues;

import java.awt.*;

public class UIStyle {

    private static final ColorSchema DARK;
    private static final ColorSchema Light;

    static {
        // darkSchema initiating
        Color DarkPrim = Color.decode("#000000");
        Color DarkSec = Color.decode("#2c2c2c");
        Color Text = Color.decode("#ffebee");
        Color DarkBorder = Color.decode("#4f5b62");
        DARK = new ColorSchema(DarkPrim, DarkSec, DarkBorder, Text);
        //LightSchema initiating
        Color LightPrim = Color.decode("#e0e0e0");
        Color LightSec = Color.decode("#a7c0cd");
        Color LightText = Color.decode("#000a12");
        Color LightBorder = Color.decode("#90a4ae");
        Light = new ColorSchema(LightPrim, LightSec, LightBorder, LightText);


    }

    public static ColorSchema getDark() {
        return DARK;
    }

    public static ColorSchema getLight() {
        return Light;
    }
}
