import client.EchoClient;

import java.io.IOException;
import java.net.Socket;

public class MyClient {

    public static void main(String[] args) {
        try {
            Socket socket = new Socket("localhost", 8000);
            EchoClient echoClient = new EchoClient(socket, System.in, System.out);
            echoClient.start();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

}
