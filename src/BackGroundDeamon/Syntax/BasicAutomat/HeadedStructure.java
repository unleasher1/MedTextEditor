package BackGroundDeamon.Syntax.BasicAutomat;

public class HeadedStructure {
    /**
     * Headed Structure are the most used structure in programming languages<br>
     * the main template is : <br>
     *
     * <pre>
     * structure_Type structureName (parameters (Optional)) {(Opener optional)<br>
     * Structure Body (Optional)<br>
     * } (Closer optional)<br>
     * </pre>
     *actual structure classified under this class are:<br>
     * {@code FlowControl} like if,switch,for ,while
     * {@code codeFragments definition} methods,classes ...
     * to define the main classes there are 4<br>
     * 1.contains params and structure name and body like methods.<br>
     * 2.contains params and body like  flow controls.<br>
     * 3.contains name and body like classes.
     * 4.contains only the structure name line method calls.
     * in this class create these 4 classes to facilitate the automat engine process
     */
    public HeadedStructure() {

    }

}
