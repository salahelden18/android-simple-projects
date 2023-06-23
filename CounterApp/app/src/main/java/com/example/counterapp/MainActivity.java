package com.example.counterapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView welcomeText, counterText;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        counterText = findViewById(R.id.textView);
        btn = findViewById(R.id.btn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    int number = Integer.parseInt(counterText.getText().toString());
                    counterText.setText(number + 1 );
                }catch (Exception e) {
                    Toast.makeText(MainActivity.this, "should be a number", Toast.LENGTH_SHORT).show();

                }


            }
        });
    }
}