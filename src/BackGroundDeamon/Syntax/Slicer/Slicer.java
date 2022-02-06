package BackGroundDeamon.Syntax.Slicer;

import java.util.ArrayList;
import java.util.List;

public class Slicer {
    String BaseInput;
    ArrayList<Symbol> SlicedInput = new ArrayList<>();
    String[] separators = {" ", ";", ",", ":", "\n", "\"", "{", "}", "(", ")"};
    ArrayList<String> separator = new ArrayList<>(List.of(separators));


    /**
     * Slicer is a class take any String input and<br>
     * decomposed into Symbol sequence.
     * <pre>
     *     WorkFlow
     *     1.strip input
     *     2.decompose the input into Symbol using separator.
     *     separator are {@code ; . , whitespace newLine }
     * </pre>
     */
    public Slicer(String input) {
        this.BaseInput = input;

    }

    /**
     * the slicing process
     * <pre>
     *     for every separator found the slicer
     *     will create new Symbol and define it's type
     *     and added to Symbols sequence.
     * </pre>
     */
    private void slice(int offset, int end) {
        BaseInput = BaseInput.strip();
        String tostrip = BaseInput.substring(offset, end);
        char[] charArray = tostrip.toCharArray();
        String symbolValue = "";
        for (char c : charArray) {
            if ((separator.contains(String.valueOf(c))) && !symbolValue.equals("")) {
                // adding the symbol found before the separator
                Symbol symbol = new Symbol(symbolValue);
                symbol.setType(definingSymbolType.DefineType(symbolValue));
                SlicedInput.add(symbol);
                // adding the separator
                symbol = new Symbol(String.valueOf(c));
                symbol.setType(SymbolType.SEPARATOR);
                SlicedInput.add(symbol);
                symbolValue = "";

            } else if ((separator.contains(String.valueOf(c))) && symbolValue.equals("")) {
                Symbol symbol = new Symbol(String.valueOf(c));
                symbol.setType(SymbolType.SEPARATOR);
                SlicedInput.add(symbol);
                symbolValue = "";

            } else {
                symbolValue += String.valueOf(c);
            }
        }

    }

    public void beginSlice(int offset, int end) {
        System.out.println("begin slice called " + offset + " " + end);
        this.slice(offset, end);
    }

    public void beginSLice() {
        System.out.println("begin slice called : " + 0 + " " + BaseInput.length());
        this.slice(0, BaseInput.length());
    }

    public void addInput(String newInput) {
        System.out.println("Add Input called");
        BaseInput += newInput;


        System.out.println(getClass().toString() + " base input length : " + BaseInput.length());
        System.out.println(BaseInput);
    }


    public ArrayList<Symbol> getSlicedInput() {
        return SlicedInput;
    }

    //testing
    public void printing() {
        System.out.println("printing is called");
        for (Symbol s : SlicedInput) {
            System.out.println("Value : " + s.value + " : type : " + s.type + " : index : " + SlicedInput.indexOf(s));

        }
    }

    static class definingSymbolType {

        static ArrayList<String> visi = new ArrayList<>(
                List.of(new String[]{"public", "private", "protect", "abstract", "final"}));

        static ArrayList<String> data = new ArrayList<>(
                List.of(new String[]{"int", "float", "double", "boolean", "void"}));

        static ArrayList<String> structID = new ArrayList<>(
                List.of(new String[]{"class", "interface", "enum", "for", "if", "switch", "case", "while"}));

        static ArrayList<String> opera = new ArrayList<>(
                List.of(new String[]{"+", "-", ".", "*", "/", "="}));
        static ArrayList<String> keys = new ArrayList<>(List.of(new String[]{"new"}));

        static SymbolType DefineType(String value) {
            SymbolType type = SymbolType.NORMAL_VALUE;
            if (visi.contains(value)) {
                type = SymbolType.VISIBILITIY;
            } else if (structID.contains(value)) {
                type = SymbolType.STRUTURE_ID;
            } else if (opera.contains(value)) {
                type = SymbolType.OPERATOR;
            } else if (keys.contains(value)) {
                type = SymbolType.KEY_WORD;
            } else if (data.contains(value)) {
                type = SymbolType.DATATYPE;
            }
            return type;
        }

    }
}
