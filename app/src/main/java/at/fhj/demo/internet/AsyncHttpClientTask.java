package at.fhj.demo.internet;

import android.os.AsyncTask;
import android.util.Log;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.IOException;
import java.lang.reflect.Method;
import java.net.URI;

public class AsyncHttpClientTask extends AsyncTask<String, Void, String> {

    @Override
    protected String doInBackground(String... urls) {
        doRequest(urls[0]);
        return null;
    }

    private String doRequest(String url) {
        HttpGet request = new HttpGet();
        request.setURI(URI.create(url));
        request.addHeader("Cookie", getCookieValues());

        HttpClient client = new DefaultHttpClient();
        HttpEntity result = execute(client, request);                              // false positive
        return processResult(result);
    }

    private HttpEntity execute(HttpClient client, HttpRequestBase request) {
        try {
            HttpResponse response = client.execute(request);                       // real match
            StatusLine status = response.getStatusLine();
            if (status.getStatusCode() == HttpStatus.SC_OK) {
                return response.getEntity();
            }
        } catch (IOException e) {
            Log.e("App", "http doRequest failure", e);
        }

        return null;
    }

    private HttpEntity executeWithReflection(HttpRequestBase request) {
        try {
            Class<DefaultHttpClient> clientClass = DefaultHttpClient.class;
            DefaultHttpClient client = clientClass.newInstance();
            Method execute = clientClass.getMethod("execute", HttpUriRequest.class);

            HttpResponse response = (HttpResponse) execute.invoke(client, request);// false negative
            StatusLine status = response.getStatusLine();
            if (status.getStatusCode() == HttpStatus.SC_OK) {
                return response.getEntity();
            }
        } catch (Exception e) {
            Log.e("App", "http doRequest/reflection failure", e);
        }

        return null;
    }

    private String getCookieValues() {
        return ""; // implement
    }

    private String processResult(HttpEntity result) {
        return null; // implement
    }

    @Override
    protected void onPostExecute(String s) {
    }
}
