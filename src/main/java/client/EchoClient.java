package client;

import socket.SocketIO;

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
        echoStdIn();
    }

    private void echoStdIn() throws IOException {
        String input = stdIn.readLine();
        if (input != null) {
            sendReceive(input);
            echoStdIn();
        }
    }

    private void sendReceive(String input) throws IOException {
        socketIO.writeToSocket(input);
        stdOut.println("echo: " + socketIO.readFromSocket());
    }

    private void createReader(InputStream stdIn) {
        this.stdIn = new BufferedReader(new InputStreamReader(stdIn));
    }

}
