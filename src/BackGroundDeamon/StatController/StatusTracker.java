package BackGroundDeamon.StatController;

import BackGroundDeamon.SyntaxHighlighter.Visibilities;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.*;
import java.awt.*;

public class StatusTracker extends Thread {
    public Document document;
    SyntaxTracker tracker;
    Visibilities visibilities;
    Runnable highlighter;
    private JTextPane pane;

    public StatusTracker(JTextPane pane) {
        document = pane.getDocument();
        tracker = new SyntaxTracker(pane);
        this.pane = pane;
        addDocumentListener();
    }

    public SyntaxTracker getTracker() {
        return tracker;
    }

    private void printingStatus() {
        try {
            System.out.println(document.getText(0, document.getLength()));
        } catch (BadLocationException ex) {
            ex.printStackTrace();
        }
    }

    private void addDocumentListener() {
        document.addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                System.out.println("insert");
                printingStatus();
                tracker.fetch();


            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                System.out.println("remove");
                printingStatus();
                tracker.fetch();

            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                System.out.println("change");
                printingStatus();
                tracker.fetch();

            }
        });
    }


//    private void track() {
//        int[] LastTracked = new int[2];
//        TODO this code triggerer infinite loop modified later.
//        int[] tracked = tracker.fetch().indexes;
//        if (tracked[1] != 0) {
//            highlighter = new Runnable() {
//                @Override
//                public void run() {
//
//                    visibilities.drawStyle(tracked[0], tracked[1]);
//                    tracker.fetch();
//
//                }
//            };
//            if (tracked[1] == pane.getCaretPosition()) {
//                SwingUtilities.invokeLater(highlighter);
//            }
//             resetting the Style
//            StyleContext context = new StyleContext();
//            Style style = context.addStyle("default", null);
//            StyleConstants.setForeground(style, Color.BLACK);
//
//            try {
//                pane.removeStyle("visibilities");
//                System.out.println("highlighter triggered");
//
//            } catch (IllegalStateException k) {
//                System.out.println(k.getMessage());
//            }
//

//        }
//
//    }


}