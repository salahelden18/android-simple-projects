package com.example.luckynumber;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class LuckNumberActivity extends AppCompatActivity {
    Button shareBtn;
    TextView txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_luck_number);

        shareBtn = findViewById(R.id.share_number_btn);
        txt = findViewById(R.id.lucky);

        Intent i = getIntent();
        String username = i.getStringExtra("name");

        int randomNumber = generateRandomNumber();

        txt.setText("" + randomNumber);

        Toast.makeText(this, "Username: "+ username, Toast.LENGTH_SHORT).show();

        shareBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                shareData(username, randomNumber);
            }
        });

    }

    public int generateRandomNumber() {
        Random random = new Random();
        int upperLimit = 1000;
        int randomNumberGenerated = random.nextInt(upperLimit);

        return randomNumberGenerated;
    }

    public void shareData (String userName, int randomNumber) {
        // implicit intents

        Intent i = new Intent(Intent.ACTION_SEND);

        i.setType("text/plain");

        i.putExtra(Intent.EXTRA_SUBJECT, userName);
        i.putExtra(Intent.EXTRA_TEXT, randomNumber);

        startActivity(Intent.createChooser(i, "Choose a platform"));

    }
}