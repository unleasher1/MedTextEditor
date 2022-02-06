package BackGroundDeamon.Syntax.AutomatEngine;

import BackGroundDeamon.Syntax.Slicer.Symbol;

public class AUTOCommand {
    private final Command command;
    private final Symbol target;

    public AUTOCommand(Command command, Symbol target) {
        this.command = command;
        this.target = target;
    }

    public Command getCommand() {
        return command;
    }

    public Symbol getTarget() {
        return target;
    }
}
