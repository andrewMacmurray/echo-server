import mocks.MockSocket;
import org.junit.Before;
import org.junit.Test;
import socket.SocketIO;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.Socket;

import static org.junit.Assert.assertEquals;

public class SocketIOTest {

    private Socket mockSocket;
    private ByteArrayOutputStream outputStream;
    private final String testInput = "hello";

    @Before
    public void setup() throws IOException {
        outputStream = new ByteArrayOutputStream();
        ByteArrayInputStream inputStream = new ByteArrayInputStream(testInput.getBytes());
        mockSocket = new MockSocket(inputStream, outputStream);
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
