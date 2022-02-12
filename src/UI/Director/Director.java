package UI.Director;

import UI.CustomComponents.MPanel;

import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

public class Director implements Runnable {
    protected MPanel center;
    protected MPanel east;
    protected MPanel west;
    protected MPanel south;


    public Director(
            MPanel center, MPanel east,
            MPanel west, MPanel south
    ) {

        this.center = center;
        this.east = east;
        this.west = west;
        this.south = south;

    }

    public void onCenterUpDate(ComponentEvent e) {
        // updating east in case of grow/shrink in the east side
        // update west in case of grow/shrink in the west side
        // update south in case of grow/shrink in the west side


    }

    public void onEastUpdate(ComponentEvent e) {
        // shrinking/growing the center side in case of grow/shrink in this side # the effect is effected the center not
        //updating the south side in case of update in grow shrink


    }

    public void onWestUpDate(ComponentEvent e) {
        // updating center 

    }

    public void onSouthUpdated(ComponentEvent e) {

    }

    private void addComponetListenerToCenter() {
        center.addComponentListener(new ComponentListener() {
            @Override
            public void componentResized(ComponentEvent e) {
                onCenterUpDate(e);
            }

            @Override
            public void componentMoved(ComponentEvent e) {

            }

            @Override
            public void componentShown(ComponentEvent e) {

            }

            @Override
            public void componentHidden(ComponentEvent e) {

            }
        });
    }

    private void addComponentListenerToEast() {
        east.addComponentListener(new ComponentListener() {
            @Override
            public void componentResized(ComponentEvent e) {
                onEastUpdate(e);
            }

            @Override
            public void componentMoved(ComponentEvent e) {

            }

            @Override
            public void componentShown(ComponentEvent e) {

            }

            @Override
            public void componentHidden(ComponentEvent e) {

            }
        });
    }

    private void addComponentListenerToWest() {
        west.addComponentListener(new ComponentListener() {
            @Override
            public void componentResized(ComponentEvent e) {
                onWestUpDate(e);
            }

            @Override
            public void componentMoved(ComponentEvent e) {

            }

            @Override
            public void componentShown(ComponentEvent e) {

            }

            @Override
            public void componentHidden(ComponentEvent e) {

            }
        });
    }

    private void addComponentListenerToSouth() {
        south.addComponentListener(new ComponentListener() {
            @Override
            public void componentResized(ComponentEvent e) {
                onSouthUpdated(e);
            }

            @Override
            public void componentMoved(ComponentEvent e) {

            }

            @Override
            public void componentShown(ComponentEvent e) {

            }

            @Override
            public void componentHidden(ComponentEvent e) {

            }
        });
    }


    /**
     * When an object implementing interface {@code Runnable} is used
     * to create a thread, starting the thread causes the object's
     * {@code run} method to be called in that separately executing
     * thread.
     * <p>
     * The general contract of the method {@code run} is that it may
     * take any action whatsoever.
     *
     * @see Thread#run()
     */
    @Override
    public void run() {

    }
}
