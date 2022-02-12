package UI.CustomComponents;

import UI.CustomComponents.InternalValues.ColorSchema;
import UI.CustomComponents.InternalValues.UIType;

public interface MComponent {
    /**
     * effect the style chosen  on this component
     */
    void effectStyle();

    /**
     * chose a style for this component
     * <pre>
     *     Values in this class <br>
     *     {@link UI.CustomComponents.InternalValues.UIStyle}<br>
     *     DARK
     *     LIGHT
     *     CUSTOM
     * </pre>
     *
     * @param style {@link UIType }
     */
    void setStyle(UIType style);

    /**
     * set Background to Transparent
     * <pre>
     *     possible before or after calling {@code paintComponent()}
     * </pre>
     *
     * @param isTransparent
     */
    void setBackgroundTransParent(boolean isTransparent);

    /**
     * /**
     * set Foreground to Transparent
     * <pre>
     *     possible before or after calling {@code paintComponent()}
     * </pre>
     *
     * @param isTransparent
     */
    void setForGroundTransParent(boolean isTransparent);

    /**
     * inherent Style from Parent Component
     *
     * @param DOinherent
     */
    void inherentStyle(boolean DOinherent);

    /**
     * get the current schema of this component
     *
     * @return {@link ColorSchema}
     */
    ColorSchema getSchema();

    /**
     * returning the Parent of this component
     *
     * @return {@link MComponent}
     */
    MComponent getMParent();

    void setMParent(MComponent parent);

}
