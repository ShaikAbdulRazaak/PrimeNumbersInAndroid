package com.roger.higherorlower;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Main3Activity extends AppCompatActivity {
    EditText number;
    Button result;
    TextView resultprime;
    String s;
    int n;
    ArrayList<Integer> arr = new ArrayList<Integer>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        number = (EditText) findViewById(R.id.inputprime);
        result = (Button) findViewById(R.id.resultButton);
        resultprime = (TextView) findViewById(R.id.resultprime);
    }

    public void result(View view) {
        try {
            s = number.getText().toString();
            n = Integer.parseInt(s);
            if (number.getText() == null) {
                Toast.makeText(this, "Enter a value", Toast.LENGTH_SHORT).show();
            } else {
                try {
                    int high = n;
                    if (high > 1434) {
                        resultprime.setText("number is too large");
                        Toast.makeText(getApplicationContext(), "Number is too large", Toast.LENGTH_SHORT).show();
                    } else {
                        int low = 2;
                        int sum = 0;
                        while (low <= high) {
                            boolean flag = false;
                            for (int i = 2; i <= low / 2; ++i) {
                                if (low % i == 0) {
                                    flag = true;
                                    break;
                                }
                            }
                            if (!flag) {
                                arr.add(low);
                                sum = sum + low;
                            }
                            ++low;
                        }
                        resultprime.setText(arr.toString());
                        arr.clear();
                        Toast.makeText(getApplicationContext(), "The sum of these numbers is " + sum, Toast.LENGTH_LONG).show();
                    }
                } catch (Exception c) {
                    c.printStackTrace();
                }
            }
        } catch (Exception c) {
            c.printStackTrace();
        }
    }

}
