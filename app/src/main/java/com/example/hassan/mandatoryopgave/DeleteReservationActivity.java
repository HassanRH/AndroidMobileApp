package com.example.hassan.mandatoryopgave;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class DeleteReservationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_reservation);
    }


    public void dele(View view) {


        TextView vieww = findViewById(R.id.view);
        EditText input = findViewById(R.id.idd);

        String id = input.getText().toString();
        DeleteTask task = new DeleteTask();
        task.execute("https://anbo-roomreservation.azurewebsites.net/api/reservations/" + id);


        if (id == "1") {
            vieww.setText("the reservation  with " + id + " has been deleted");
        }
    }

    public void back(View view) {
        finish();
    }


    private class DeleteTask extends AsyncTask<String, Void, CharSequence> {
        @Override
        protected CharSequence doInBackground(String... urls) {
            String urlString = urls[0];
            try {
                URL url = new URL(urlString);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("DELETE");
                int responseCode = connection.getResponseCode();
                if (responseCode % 100 != 2) {
                    throw new IOException("Response code: " + responseCode);
                }
                return "Nothing";
            } catch (MalformedURLException e) {
                return e.getMessage() + " " + urlString;
            } catch (IOException e) {
                return e.getMessage();
            }
        }

        @Override
        protected void onCancelled(CharSequence charSequence) {
            super.onCancelled(charSequence);
            TextView messageView = findViewById(R.id.view);
            messageView.setText(charSequence);
        }
    }



}

