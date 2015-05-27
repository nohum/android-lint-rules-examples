package at.fhj.demo.internet;

import java.io.IOException;
import java.net.Socket;
import java.net.SocketAddress;

public class CustomSocket extends Socket {

    @Override
    public void connect(SocketAddress remoteAddr) throws IOException {
        super.connect(remoteAddr);
    }

    @Override
    public void connect(SocketAddress remoteAddr, int timeout) throws IOException {
        super.connect(remoteAddr, timeout);
    }
}
