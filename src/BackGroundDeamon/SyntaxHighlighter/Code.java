package BackGroundDeamon.SyntaxHighlighter;

public class Code {
    public CodeType type;
    public int[] indexes;

    public Code(CodeType type, int[] indexes) {
        this.indexes = indexes;
        this.type = type;
    }

    public CodeType getType() {
        return type;
    }

    public int[] getIndexes() {
        return indexes;
    }
}
