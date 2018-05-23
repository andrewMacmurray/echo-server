import org.junit.Before;
import org.junit.Test;
import socket.SocketIO;

import java.io.*;
import java.net.Socket;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class SocketIOTest {

    private Socket mockSocket;
    private OutputStream outputStream;
    private InputStream inputStream;
    private final String testInput = "hello";

    @Before
    public void setup() throws IOException {
        mockSocket = mock(Socket.class);
        outputStream = new ByteArrayOutputStream();
        inputStream = new ByteArrayInputStream(testInput.getBytes());

        when(mockSocket.getOutputStream()).thenReturn(outputStream);
        when(mockSocket.getInputStream()).thenReturn(inputStream);
    }

    @Test
    public void writeToSocket() throws IOException {
        SocketIO socketIO = new SocketIO(mockSocket);
        socketIO.writeToSocket(testInput);

        assertEquals(testInput, outputStream.toString().trim());
    }

    @Test
    public void readFomSocket() throws IOException {
        SocketIO socketIO = new SocketIO(mockSocket);
        String output = socketIO.readFromSocket();
        assertEquals(testInput, output);
    }

}
