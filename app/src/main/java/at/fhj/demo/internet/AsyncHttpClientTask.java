package at.fhj.demo.internet;

import android.os.AsyncTask;
import android.util.Log;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.StatusLine;
import org.apache.http.client.*; // by purpose to test star-import detection
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.impl.client.*; // by purpose to test star-import detection

import java.io.IOException;
import java.net.URI;

public class AsyncHttpClientTask extends AsyncTask<String, Void, String> {

    @Override
    protected String doInBackground(String... urls) {

        HttpGet request = new HttpGet();
        request.setURI(URI.create("http://www.google.at"));

        HttpClient client = new DefaultHttpClient();

        execute(client, request);
        return null;
    }

    private HttpEntity execute(HttpClient client, HttpRequestBase request) {
        try {
            request.addHeader("Cookie", getCookieValues());

            HttpResponse response = client.execute(request);

            StatusLine status = response.getStatusLine();
            if (status.getStatusCode() == HttpStatus.SC_OK) {
                return response.getEntity();
            }
        } catch (IOException e) {
            Log.e("Project", "http request failure", e);
        }

        return null;
    }

    private String getCookieValues() {
        return ""; // implement
    }

    @Override
    protected void onPostExecute(String s) {
    }
}
