package client;

import java.io.*;

public class StdIO {

    private BufferedReader stdIn;
    private PrintStream out;

    public StdIO(InputStream in, PrintStream out) {
        createReader(in);
        this.out = out;
    }

    public String readLine() throws IOException {
        return stdIn.readLine();
    }

    public void println(String message) {
        out.println(message);
    }

    private void createReader(InputStream in) {
        stdIn = new BufferedReader(new InputStreamReader(in));
    }

}
