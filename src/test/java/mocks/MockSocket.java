package mocks;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.net.Socket;

public class MockSocket extends Socket {

    private ByteArrayOutputStream outputStream;
    private ByteArrayInputStream inputStream;

    public MockSocket(ByteArrayInputStream inputStream, ByteArrayOutputStream outputStream) {
        this.outputStream = outputStream;
        this.inputStream = inputStream;
    }

    @Override
    public ByteArrayOutputStream getOutputStream() {
        return outputStream;
    }

    @Override
    public ByteArrayInputStream getInputStream() {
        return inputStream;
    }

}
