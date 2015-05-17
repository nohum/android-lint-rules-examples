package at.fhj.demo.internet;

import android.os.AsyncTask;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class AsyncUrlOpenTask extends AsyncTask<String, Void, String> {

    @Override
    protected String doInBackground(String... urls) {

        try {
            URL website = new URL("https://www.google.com");
            HttpURLConnection connection = (HttpURLConnection) website.openConnection();

            InputStream websiteData = connection.getInputStream();

            // ...

            connection.disconnect(); // should be done in finally-block
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    protected void onPostExecute(String s) {
    }
}
