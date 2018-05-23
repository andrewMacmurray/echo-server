import org.junit.Before;
import org.junit.Test;
import server.EchoServer;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class EchoServerTest {

    private ByteArrayOutputStream outputStream;
    private ByteArrayInputStream inputStream;
    private Socket mockClientSocket;
    private ServerSocket mockServerSocket;

    @Before
    public void setup() throws IOException {
        inputStream = new ByteArrayInputStream("hello".getBytes());
        outputStream = new ByteArrayOutputStream();

        mockClientSocket = mock(Socket.class);
        mockServerSocket = mock(ServerSocket.class);

        configureMocks();
    }

    private void configureMocks() throws IOException {
        // clientSocket
        when(mockClientSocket.getInputStream()).thenReturn(inputStream);
        when(mockClientSocket.getOutputStream()).thenReturn(outputStream);

        // serverSocket
        when(mockServerSocket.accept()).thenReturn(mockClientSocket);
    }

    @Test
    public void startServer() throws IOException {
        EchoServer echoServer = new EchoServer(mockServerSocket);
        echoServer.start();

        assertEquals("hello", outputStream.toString().trim());
    }

}