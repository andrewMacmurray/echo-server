package socket;

import java.io.*;
import java.net.Socket;

public class SocketIO {

    private BufferedReader in;
    private PrintWriter out;

    public SocketIO(Socket socket) throws IOException {
        createReadStream(socket.getInputStream());
        createWriteStream(socket.getOutputStream());
    }

    public String readFromSocket() throws IOException {
        return in.readLine();
    }

    public void writeToSocket(String input) {
        out.println(input);
    }

    private void createReadStream(InputStream in) {
        this.in = new BufferedReader(new InputStreamReader(in));
    }

    private void createWriteStream(OutputStream out) {
        this.out = new PrintWriter(out, true);
    }

}
