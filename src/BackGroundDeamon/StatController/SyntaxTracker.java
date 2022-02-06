package BackGroundDeamon.StatController;

import BackGroundDeamon.SyntaxHighlighter.*;

import javax.swing.*;

public class SyntaxTracker {
    // testing only on visibilities
    JTextPane pane;
    Visibilities visibilities;
    Primitive primitive;
    Keywords keywords;
    Default aDefault;
    Runnable highlighter;

    String[] visibilitiesValues = {"public", "static", "private", "protected"};
    String[] PrimitiveValues = {"int", "boolean", "float", "double"};
    String[] KeyWordsValues = {"class", "interface", "new", "void"};
    int LastVFor = 0;
    int LastKFor = 0;
    int LastPFor = 0;

    public SyntaxTracker(JTextPane pane) {
        this.pane = pane;
        visibilities = new Visibilities(pane);
        primitive = new Primitive(pane);
        keywords = new Keywords(pane);
        aDefault = new Default(pane);

    }

    public Visibilities getVisibilities() {
        return visibilities;
    }


    public void fetch() {
        Code codeVisibilities = new Code(CodeType.DEFAULT, new int[2]);
        Code codePrimitive = new Code(CodeType.DEFAULT, new int[2]);
        Code codeKeyword = new Code(CodeType.DEFAULT, new int[2]);
        int[] visibilitiesIndexes = FetchVisibilities();
        int[] PrimitiveIndexes = FetchPrimitive();
        int[] KeyWordIndexes = FetchKeywords();

        if (visibilitiesIndexes[1] != 0) {
            codePrimitive = new Code(CodeType.Primitive, visibilitiesIndexes);

            Runnable runs = new Runnable() {
                @Override
                public void run() {
                    visibilities.drawStyle(visibilitiesIndexes[0], visibilitiesIndexes[1]);
                }
            };
            if (visibilitiesIndexes[1] > LastVFor) {
                System.out.println("hhhhhhhhh");
                SwingUtilities.invokeLater(runs);
                LastVFor = visibilitiesIndexes[1];
                pane.removeStyle("visibilities");
            }


            if (PrimitiveIndexes[1] == 0) {
                codePrimitive = new Code(CodeType.Primitive, PrimitiveIndexes);

                Runnable runs0 = new Runnable() {
                    @Override
                    public void run() {
                        primitive.drawStyle(PrimitiveIndexes[0], PrimitiveIndexes[1]);
                    }
                };
                if (PrimitiveIndexes[1] > LastPFor) {
                    System.out.println("hhhhhhhhh");
                    SwingUtilities.invokeLater(runs0);
                    LastPFor = PrimitiveIndexes[1];
                    pane.removeStyle("primitives");
                }
            }
            if (KeyWordIndexes[1] != 0) {
                codeKeyword = new Code(CodeType.Primitive, KeyWordIndexes);

                Runnable runs1 = new Runnable() {
                    @Override
                    public void run() {
                        primitive.drawStyle(KeyWordIndexes[0], KeyWordIndexes[1]);
                    }
                };
                if (KeyWordIndexes[1] > LastKFor) {
                    System.out.println("hhhhhhhhh");
                    SwingUtilities.invokeLater(runs1);
                    LastKFor = KeyWordIndexes[1];
                    pane.removeStyle("keywords");
                }
            }

        }

    }

    private int[] FetchVisibilities() {
        int[] index = new int[2];
        String tofetch = pane.getText();
        for (String visibility : visibilitiesValues) {
            if (tofetch.lastIndexOf(visibility) != -1) {
                index[0] = tofetch.lastIndexOf(visibility);
                index[1] = index[0] + visibility.length();
            }
        }
        return index;
    }

    private int[] FetchKeywords() {
        int[] index = new int[2];
        String tofetch = pane.getText();
        for (String keyword : KeyWordsValues) {
            if (tofetch.lastIndexOf(keyword) != -1) {
                index[0] = tofetch.lastIndexOf(keyword);
                index[1] = index[0] + keyword.length();
            }
        }
        return index;
    }

    private int[] FetchPrimitive() {
        int[] index = new int[2];
        String tofetch = pane.getText();
        for (String primitive : PrimitiveValues) {
            if (tofetch.lastIndexOf(primitive) != -1) {
                index[0] = tofetch.lastIndexOf(primitive);
                index[1] = index[0] + primitive.length();
            }
        }
        return index;
    }

    private void track() {

    }

}


