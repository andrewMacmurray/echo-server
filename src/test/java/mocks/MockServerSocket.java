package mocks;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class MockServerSocket extends ServerSocket {

    private Socket mockClientSocket;

    public MockServerSocket(Socket mockClientSocket) throws IOException {
        this.mockClientSocket = mockClientSocket;
    }

    @Override
    public Socket accept() throws IOException {
        return mockClientSocket;
    }

}
