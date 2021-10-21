package com.sprint.gina.multipleactivitiesfuns2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        // grab the Intent that started this Activity (if there is one)
        Intent intent = getIntent();
        // for good practice
        if (intent != null) {
            String username = intent.getStringExtra("username");
            // username will be null if "username" is not a valid key
            int pin = intent.getIntExtra("pin", 0);
            // pin will be 0 if "pin" is not a valid key
            Toast.makeText(this, username + " " + pin, Toast.LENGTH_SHORT).show();
        }

        Button backButton = findViewById(R.id.backButton);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // when the user presses the back button
                // they should return the activity that started this activity
                // e.g. MainActivity
                SecondActivity.this.finish();
            }
        });
    }
}