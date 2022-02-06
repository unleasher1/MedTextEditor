package BackGroundDeamon.Syntax.Slicer;

public class Symbol {
    String value;
    SymbolType type;

    /**
     * Symbol Type is the Type of String in code
     * SymbolTypes
     * visibilities: public protected private <br>
     * DataTypes       : int; float ;boolean;double;void;
     * structure id: any name of structure like {class,for,if...}
     * keyword     : new
     * separator   : ; whitespace {,},(,),[,],newLine ...
     * operator    : " ' + - / * =
     * Normal Values Any String that not classified as one of the above
     */
    public Symbol(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setType(SymbolType type) {
        this.type = type;
    }
}
