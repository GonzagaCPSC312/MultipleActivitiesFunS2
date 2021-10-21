package com.sprint.gina.multipleactivitiesfuns2;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    static final String TAG = "MainActivityTag";
    ActivityResultLauncher<Intent> launcher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        launcher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        Log.d(TAG, "onActivityResult: ");
                        // this callback executes when MainActivity
                        // is returned to after it started an activity]
                        // for a result
                        // grab the result here
                    }
                });

        Button startButton = findViewById(R.id.startButton);
        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: ");
                // intent: a message for the Android OS
                // specifying our "intent" to start an activity
                // if the intent looks good, Android will start the activity
                // 2 types of intents
                // explicit intent: we know the name of the activity class we want to start
                // implicit intent: we want the user to choose from a list of apps
                // that can handle our "action" we want to perform
                // example actions
                // Intent.ACTION_VIEW
                // Intent.ACTION_SEND
                // Intent.ACTION_DIAL
                // Intent.ACTION_WEB_SEARCH
                // etc.

                // explicit intent example
                // we want to start another Activity in our app (SecondActivity)
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                // source, destination
                // lets say MainActivity needs to send some data
                // to SecondActivity so SecondActivity can use it!
                // example: username and pin (really String and int)
                String username = "spike";
                int pin = 1234;
                // we can send these values using key-value pairs
                // as the "extra" data of the Intent
                intent.putExtra("username", username);
                intent.putExtra("pin", pin);
                // lets say, we want to get a result back from SecondActivity
                // in the NEW WAY: we need an ActivityResultLauncher

//                startActivity(intent);
                launcher.launch(intent);
            }
        });

        Button viewButton = findViewById(R.id.viewButton);
        viewButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        Button sendButton = findViewById(R.id.sendButton);
        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                
            }
        });
    }
}