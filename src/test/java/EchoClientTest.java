import client.EchoClient;
import mocks.MockSocket;
import org.junit.Before;
import org.junit.Test;

import java.io.*;
import java.net.Socket;

import static org.junit.Assert.assertEquals;

public class EchoClientTest {

    private ByteArrayOutputStream mockSystemOutBytes;
    private PrintStream mockSystemOut;
    private InputStream mockSystemIn;
    private ByteArrayOutputStream socketOutputStream;
    private Socket mockClientSocket;

    @Before
    public void setup() throws IOException {
        mockSystemIn = new ByteArrayInputStream("hello".getBytes());
        mockSystemOutBytes = new ByteArrayOutputStream();
        mockSystemOut = new PrintStream(mockSystemOutBytes);

        ByteArrayInputStream socketInputStream = new ByteArrayInputStream("hello".getBytes());
        socketOutputStream = new ByteArrayOutputStream();

        mockClientSocket = new MockSocket(socketInputStream, socketOutputStream);
    }

    @Test
    public void echoToSocket() throws IOException {
        EchoClient echoClient = new EchoClient(mockClientSocket, mockSystemIn, mockSystemOut);
        echoClient.start();

        assertEquals("hello", socketOutputStream.toString().trim());
    }

    @Test
    public void printEcho() throws IOException {
        EchoClient echoClient = new EchoClient(mockClientSocket, mockSystemIn, mockSystemOut);
        echoClient.start();

        assertEquals("echo: hello", mockSystemOutBytes.toString().trim());
    }

}
