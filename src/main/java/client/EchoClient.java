package client;

import server.SocketIO;

import java.io.*;
import java.net.Socket;

public class EchoClient {

    private SocketIO socketIO;
    private BufferedReader stdIn;
    private PrintStream stdOut;

    public EchoClient(Socket socket, InputStream stdIn, PrintStream stdOut) throws IOException {
        socketIO = new SocketIO(socket);
        createReader(stdIn);
        this.stdOut = stdOut;
    }

    public void start() throws IOException {
        echo();
    }

    private void echo() throws IOException {
        String input = stdIn.readLine();
        if (input != null) {
            socketIO.writeToSocket(input);
            stdOut.println("echo: " + socketIO.readFromSocket());
            echo();
        }
    }

    private void createReader(InputStream stdIn) {
        this.stdIn = new BufferedReader(new InputStreamReader(stdIn));
    }

}
