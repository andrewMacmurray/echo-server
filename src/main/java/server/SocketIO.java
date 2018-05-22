package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class SocketIO {

    private BufferedReader in;
    private PrintWriter out;

    public SocketIO(Socket socket) throws IOException {
        createReadStream(socket);
        createWriteStream(socket);
    }

    public String readFromSocket() throws IOException {
        return in.readLine();
    }

    public void writeToSocket(String input) {
        out.println(input);
    }

    private void createReadStream(Socket socket) throws IOException {
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
    }

    private void createWriteStream(Socket socket) throws IOException {
        out = new PrintWriter(socket.getOutputStream(), true);
    }

}
