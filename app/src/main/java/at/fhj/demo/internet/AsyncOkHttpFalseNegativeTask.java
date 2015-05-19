package at.fhj.demo.internet;

import android.os.AsyncTask;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;

public class AsyncOkHttpFalseNegativeTask extends AsyncTask<String, Void, String> {

    @Override
    protected String doInBackground(String... urls) {

        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("https://www.google.com")
                .build();

        Response response = null;
        try {
            // false negative, should be detected
            response = client.newCall(request).execute();

            if (response.isSuccessful()) {
                // ...
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
