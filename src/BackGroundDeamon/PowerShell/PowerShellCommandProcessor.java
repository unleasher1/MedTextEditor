package BackGroundDeamon.PowerShell;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.concurrent.Callable;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PowerShellCommandProcessor implements Callable<String> {

    private static final String CRLF = "\r\n";

    private final BufferedReader reader;

    private boolean closed = false;

    private final boolean scriptMode;

    private final int waitPause;

    /**
     * Constructor that takes the output and the input of the PowerShell session
     *
     * @param name        the name of the CommandProcessor
     * @param inputStream the stream needed to read the command output
     * @param waitPause   long the wait pause in milliseconds
     * @param scriptMode  boolean indicates if the command executes a script
     */
    public PowerShellCommandProcessor(String name, InputStream inputStream, int waitPause, boolean scriptMode) {
        this.reader = new BufferedReader(new InputStreamReader(
                inputStream));
        this.waitPause = waitPause;
        this.scriptMode = scriptMode;
    }

    /**
     * Calls the command and returns its output
     *
     * @return String output of call
    rror when reading data
     */
    public String call() {
        StringBuilder powerShellOutput = new StringBuilder();

        try {
            if (startReading()) {
                readData(powerShellOutput);
            }
        } catch (IOException ioe) {
            Logger.getLogger(PowerShell.class.getName()).log(Level.SEVERE, "Unexpected error reading PowerShell output", ioe);
            return ioe.getMessage();
        }

        //Remove last CRLF from result
        return powerShellOutput.toString().replaceAll("\\s+$", "");
    }

    //Reads all data from output
    private void readData(StringBuilder powerShellOutput) throws IOException {
        String line;
        while (null != (line = this.reader.readLine())) {

            //In the case of script mode it finish when the last line is read
            if (this.scriptMode) {
                if (line.equals(PowerShell.END_SCRIPT_STRING)) {
                    break;
                }
            }

            powerShellOutput.append(line).append(CRLF);

            //When not in script mode, it exits when the command is finished
            if (!this.scriptMode) {
                try {
                    if (this.closed || !canContinueReading()) {
                        break;
                    }
                } catch (InterruptedException ex) {
                    Logger.getLogger(PowerShellCommandProcessor.class.getName()).log(Level.SEVERE, "Error executing command and reading result", ex);
                }
            }
        }
    }

    //Checks when we can start reading the output. Timeout if it takes too long in order to avoid hangs
    private boolean startReading() throws IOException {
        //If the reader is not ready, gives it some milliseconds
        while (!this.reader.ready()) {
//            Thread.sleep(this.waitPause);
            if (this.closed) {
                return false;
            }
        }
        return true;
    }

    //Checks when we the reader can continue to read.
    private boolean canContinueReading() throws IOException, InterruptedException {
        //If the reader is not ready, gives it some milliseconds
        //It is important to do that, because the ready method guarantees that the readline will not be blocking
        if (!this.reader.ready()) {
            Thread.sleep(this.waitPause);
        }

        //If not ready yet, wait a moment to make sure it is finished
        if (!this.reader.ready()) {
            Thread.sleep(50);
        }

        return this.reader.ready();
    }

    /**
     * Closes the command processor, canceling the current work if not finish
     */
    public void close() {
        this.closed = true;
    }
}
