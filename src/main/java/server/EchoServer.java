package server;

import java.io.IOException;
import java.net.ServerSocket;

public class EchoServer {

    private ServerSocket serverSocket;
    private SocketIO socketIO;

    public EchoServer(ServerSocket serverSocket) throws IOException {
        this.serverSocket = serverSocket;
    }

    public void start() throws IOException {
        accept();
        echo();
    }

    private void accept() throws IOException {
        socketIO = new SocketIO(serverSocket.accept());
    }

    private void echo() throws IOException {
        String input = socketIO.readFromSocket();
        if (input != null) {
            socketIO.writeToSocket(input);
            echo();
        }
    }

}
