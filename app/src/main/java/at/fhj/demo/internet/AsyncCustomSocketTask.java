package at.fhj.demo.internet;

import android.os.AsyncTask;

import java.io.IOException;
import java.net.InetSocketAddress;

public class AsyncCustomSocketTask extends AsyncTask<String, Void, String> {

    @Override
    protected String doInBackground(String... urls) {
        if (urls.length < 1) {
            throw new IllegalArgumentException("a URL is required");
        }

        String url = urls[0];
        try {
            CustomSocket socket = new CustomSocket();
            socket.connect(new InetSocketAddress(url, 80));                         // real match

        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    protected void onPostExecute(String s) {
    }
}
