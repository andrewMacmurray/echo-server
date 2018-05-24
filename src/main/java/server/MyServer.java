package server;

import server.EchoServer;

import java.io.IOException;
import java.net.ServerSocket;

public class MyServer {

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8000);
            EchoServer echoServer = new EchoServer(serverSocket);
            echoServer.start();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

}
