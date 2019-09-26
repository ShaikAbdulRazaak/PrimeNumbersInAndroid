package com.roger.higherorlower;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;


public class MainActivity extends AppCompatActivity {
    int n;
    EditText e;

    void randomNumber() {
        Random rand = new Random();
        n = rand.nextInt(20) + 1;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        e = (EditText) findViewById(R.id.textinput);
        randomNumber();
        Button b = (Button) findViewById(R.id.anotherGame);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), Main2Activity.class);
                startActivity(i);
                finish();
            }
        });
    }

    public void guess(View view) {
        if (e.getText() == null) {
            Toast.makeText(this, "Please enter a value", Toast.LENGTH_SHORT).show();
        } else {
            try {
                int i = Integer.parseInt(e.getText().toString());
                Log.i("info", "The button guess is pressed and the number is " + Integer.toString(n));
                Log.i("info", "the number in text is " + i);
                String message;
                if (i < n) {
                    message = "Higher!";
                } else if (i > n) {
                    message = "Lower!";
                } else {
                    message = "Yay its Correct! Try Again";
                    randomNumber();
                }
                Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
            }catch(Exception c){
                c.printStackTrace();
            }
        }
    }
}
