package at.fhj.demo.internet;

import android.os.AsyncTask;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;

public class AsyncSocketTask extends AsyncTask<String, Void, String> {

    @Override
    protected String doInBackground(String... urls) {

        try {
            Socket socket = new Socket();
            socket.connect(new InetSocketAddress("google.com", 80));

            if (socket.isConnected()) {
                // do something
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


        return null;
    }

    @Override
    protected void onPostExecute(String s) {
    }
}
