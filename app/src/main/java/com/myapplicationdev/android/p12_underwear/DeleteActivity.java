package com.myapplicationdev.android.p12_underwear;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.RemoteInput;

import android.content.Intent;
import android.os.Bundle;

public class DeleteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);
        Intent i = getIntent();
        Bundle remoteInput;
        CharSequence reply = null;
        remoteInput = RemoteInput.getResultsFromIntent(i);
        if (remoteInput != null){
            reply = remoteInput.getCharSequence("status");
        }
        if (reply != null) {
            if (reply.toString().equalsIgnoreCase("completed")) {
                int id = i.getIntExtra("ID", -1);
                DBHelper dbh = new DBHelper(DeleteActivity.this);
                dbh.deleteTask(id);
            }
        }
        Intent ii = new Intent(DeleteActivity.this, MainActivity.class);
        startActivity(ii);
    }
}