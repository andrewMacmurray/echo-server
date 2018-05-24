import mocks.MockServerSocket;
import mocks.MockSocket;
import org.junit.Before;
import org.junit.Test;
import server.EchoServer;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import static org.junit.Assert.assertEquals;

public class EchoServerTest {

    private ByteArrayOutputStream outputStream;
    private ByteArrayInputStream inputStream;
    private Socket mockClientSocket;
    private ServerSocket mockServerSocket;

    @Before
    public void setup() throws IOException {
        inputStream = new ByteArrayInputStream("hello".getBytes());
        outputStream = new ByteArrayOutputStream();

        mockClientSocket = new MockSocket(inputStream, outputStream);
        mockServerSocket = new MockServerSocket(mockClientSocket);
    }

    @Test
    public void startServer() throws IOException {
        EchoServer echoServer = new EchoServer(mockServerSocket);
        echoServer.start();

        assertEquals("hello", outputStream.toString().trim());
    }

}