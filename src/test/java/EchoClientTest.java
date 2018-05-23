import client.EchoClient;
import org.junit.Before;
import org.junit.Test;

import java.io.*;
import java.net.Socket;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class EchoClientTest {

    private ByteArrayOutputStream mockSystemOutBytes;
    private PrintStream mockSystemOut;
    private InputStream mockSystemIn;
    private ByteArrayOutputStream socketOutputStream;
    private Socket mockClientSocket;

    @Before
    public void setup() throws IOException {
        mockClientSocket = mock(Socket.class);

        mockSystemIn = new ByteArrayInputStream("hello".getBytes());
        mockSystemOutBytes = new ByteArrayOutputStream();
        mockSystemOut = new PrintStream(mockSystemOutBytes);

        ByteArrayInputStream socketInputStream = new ByteArrayInputStream("hello".getBytes());
        socketOutputStream = new ByteArrayOutputStream();

        when(mockClientSocket.getInputStream()).thenReturn(socketInputStream);
        when(mockClientSocket.getOutputStream()).thenReturn(socketOutputStream);
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
