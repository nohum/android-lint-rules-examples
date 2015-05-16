package at.fhj.demo;

import android.os.AsyncTask;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.IOException;
import java.net.URI;

public class AsyncHttpClientTask extends AsyncTask<String, Void, String> {

    @Override
    protected String doInBackground(String... urls) {

        HttpGet request = new HttpGet();
        request.setURI(URI.create("http://www.google.at"));

        HttpClient client = new DefaultHttpClient();

        try {
            HttpResponse response = client.execute(request);

            StatusLine status = response.getStatusLine();
            HttpEntity entity = response.getEntity();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    protected void onPostExecute(String s) {
    }
}
