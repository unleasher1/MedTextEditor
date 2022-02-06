package BackGroundDeamon.PowerShell;

public class PowerShellResponse {
    private final boolean error;
    private final String commandOutput;
    private final boolean timeout;

    PowerShellResponse(boolean isError, String commandOutput, boolean timeout) {
        this.error = isError;
        this.commandOutput = commandOutput;
        this.timeout = timeout;
    }

    /**
     * True if the command could not be correctly executed (timeout or unexpected error)<p>
     * <p>
     * If you want to check if the command itself finished in error, use the method {@link PowerShell#isLastCommandInError()}
     * instead
     *
     * @return boolean value
     */
    public boolean isError() {
        return error;
    }

    /**
     * Retrieves the content returned by the executed command
     *
     * @return boolean value
     */
    public String getCommandOutput() {
        return commandOutput;
    }

    /**
     * True if the command finished in timeout
     *
     * @return boolean value
     */
    public boolean isTimeout() {
        return timeout;
    }
}
