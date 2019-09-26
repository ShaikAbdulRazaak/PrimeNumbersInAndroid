package com.roger.higherorlower;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {
    EditText e;
    Button check;
    TextView result;
    String i;
    int n;
    Button next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        e = (EditText) findViewById(R.id.input);
        check = (Button) findViewById(R.id.check);
        result = (TextView) findViewById(R.id.result);
        next = (Button) findViewById(R.id.clickHere);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), Main3Activity.class);
                startActivity(i);
                finish();
            }
        });
    }

    public void check(View view) {
        if(e.getText()==null){
            return;
        }else {
            try{
        i = e.getText().toString();
        n = Integer.parseInt(i);
        boolean isPrime = false;
        if (n >= 2) {
            for (int i = 2; i <= n / 2; i++) {
                if (n % i == 0) {
                    isPrime = true;
                }
            }
            if (!isPrime) {
                result.setText("The number " + n + " is a Prime Number");
            } else {
                result.setText("The number " + n + " is not a Prime Number");
            }
        } else {
            result.setText("Enter a correct Value");
        }}catch (Exception c){
                c.printStackTrace();
            }
        }
    }

}
