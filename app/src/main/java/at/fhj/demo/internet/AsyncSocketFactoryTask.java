package at.fhj.demo.internet;

import android.os.AsyncTask;

import java.io.IOException;
import java.net.Socket;

import javax.net.SocketFactory;

public class AsyncSocketFactoryTask extends AsyncTask<String, Void, String> {

    @Override
    protected String doInBackground(String... urls) {
        if (urls.length < 1) {
            throw new IllegalArgumentException("a URL is required");
        }

        SocketFactory factory = SocketFactory.getDefault();

        try {
            Socket falsePositive = factory.createSocket();                         // false positive
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            Socket shouldBeDetected = factory.createSocket(urls[0], 80);           // real match
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    protected void onPostExecute(String s) {
    }
}
