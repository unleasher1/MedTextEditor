package BackGroundDeamon.Syntax.AutomatEngine;

import java.util.ArrayList;

public class Automate {

    /**
     * this is the class will be our regex but with more flexibilities:<br>
     * Automat objects contains:<br>
     * {@code sequence} will work as the regex that will define the syntax of structure <br>
     * and {@code hashID} is the id of this automat<br>
     *
     * @param sequence {@link ArrayList<AUTOCommand>}
     */
    public Automate(ArrayList<AUTOCommand> sequence) {
        String hashID = "" + sequence.get(0).getTarget().getValue().hashCode();
    }
}
