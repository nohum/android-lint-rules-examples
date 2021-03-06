package at.fhj.demo.internet;

import android.os.AsyncTask;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.URI;

import at.fhj.demo.SocketHelper;

public class AsyncSocketTask extends AsyncTask<String, Void, String> {

    @Override
    protected String doInBackground(String... urls) {
        if (urls.length < 1) {
            throw new IllegalArgumentException("a URL is required");
        }

        String url = urls[0];
        try {
            Socket socket = new Socket();
            socket.connect(new InetSocketAddress(url, 80));                         // real match

            if (socket.isConnected()) {
                StringBuilder plainRequest = new StringBuilder();
                plainRequest.append("GET /index.html HTTP/1.1");
                plainRequest.append("Host: ");
                plainRequest.append(URI.create(url).getHost());
                plainRequest.append("\n");

                socket.getOutputStream().write(plainRequest.toString().getBytes("ASCII"));
            }

            // though being not a useful statements, inner expressions like this must be detected too
            (socket != null ? socket : null).connect(null);
            // same here
            ((Socket) socket).connect(null);                                       // real match
        } catch (IOException e) {
            e.printStackTrace();

            // simulate the SAME variable name as above (though different class): CLEAR FALSE POSITIVE
            SocketHelper socket = new SocketHelper();
            socket.execute(); // even same method name                             // false positive
        }

        return null;
    }

    @Override
    protected void onPostExecute(String s) {
    }
}
