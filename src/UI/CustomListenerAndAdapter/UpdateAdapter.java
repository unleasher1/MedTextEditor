package UI.CustomListenerAndAdapter;

import java.awt.*;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;

public class UpdateAdapter implements ComponentListener {
    Component child;
    Component parent;
    int callIndex = 0;

    /**
     * this class create to handle the event of<br>
     * is case of updates
     *
     * @param parent
     * @param child
     */
    public UpdateAdapter(Component parent, Component child) {
        this.parent = parent;
        this.child = child;
    }

    /**
     * this method take e as source and test is the source of the event is the child<br>
     * this method is created to handler the infinite loop created by component updated event.
     *
     * @return TriggerEvent{@code boolean }
     */
    protected boolean check(ComponentEvent e) {
        boolean triggerEvent = false;
        //testing is the source of the event
        if (e.getSource().equals(parent)) {

            triggerEvent = true;

        }
        System.out.println(callIndex);
        System.out.println("triggered : " + triggerEvent);
        return triggerEvent;
    }

    /**
     * Invoked when the component's size changes.
     *
     * @param e the event to be processed
     */
    @Override
    public void componentResized(ComponentEvent e) {

    }

    /**
     * Invoked when the component's position changes.
     *
     * @param e the event to be processed
     */
    @Override
    public void componentMoved(ComponentEvent e) {

    }

    /**
     * Invoked when the component has been made visible.
     *
     * @param e the event to be processed
     */
    @Override
    public void componentShown(ComponentEvent e) {

    }

    /**
     * Invoked when the component has been made invisible.
     *
     * @param e the event to be processed
     */
    @Override
    public void componentHidden(ComponentEvent e) {

    }
}
