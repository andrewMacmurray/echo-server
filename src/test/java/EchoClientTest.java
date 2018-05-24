import client.EchoClient;
import client.StdIO;
import mocks.MockSocket;
import org.junit.Before;
import org.junit.Test;

import java.io.*;
import java.net.Socket;

import static org.junit.Assert.assertEquals;

public class EchoClientTest {

    private ByteArrayOutputStream mockSystemOutBytes;
    private ByteArrayOutputStream socketOutputStream;
    private StdIO stdIO;
    private Socket mockClientSocket;

    @Before
    public void setup() throws IOException {
        InputStream mockSystemIn = new ByteArrayInputStream("hello".getBytes());
        mockSystemOutBytes = new ByteArrayOutputStream();
        PrintStream mockSystemOut = new PrintStream(mockSystemOutBytes);

        ByteArrayInputStream socketInputStream = new ByteArrayInputStream("hello".getBytes());
        socketOutputStream = new ByteArrayOutputStream();

        stdIO = new StdIO(mockSystemIn, mockSystemOut);
        mockClientSocket = new MockSocket(socketInputStream, socketOutputStream);
    }

    @Test
    public void echoToSocket() throws IOException {
        EchoClient echoClient = new EchoClient(mockClientSocket, stdIO);
        echoClient.start();

        assertEquals("hello", socketOutputStream.toString().trim());
    }

    @Test
    public void printEcho() throws IOException {
        EchoClient echoClient = new EchoClient(mockClientSocket, stdIO);
        echoClient.start();

        assertEquals("echo: hello", mockSystemOutBytes.toString().trim());
    }

}
