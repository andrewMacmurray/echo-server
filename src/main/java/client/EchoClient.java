package client;

import socket.SocketIO;

import java.io.*;
import java.net.Socket;

public class EchoClient {

    private SocketIO socketIO;
    private StdIO stdIO;

    public EchoClient(Socket socket, StdIO stdIO) throws IOException {
        socketIO = new SocketIO(socket);
        this.stdIO = stdIO;
    }

    public void start() throws IOException {
        echoInput();
    }

    private void echoInput() throws IOException {
        String input = stdIO.readLine();
        if (input != null) {
            sendReceive(input);
            echoInput();
        }
    }

    private void sendReceive(String input) throws IOException {
        socketIO.writeToSocket(input);
        stdIO.println("echo: " + socketIO.readFromSocket());
    }

}
