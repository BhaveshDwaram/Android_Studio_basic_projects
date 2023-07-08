package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText e1, e2;
    Button b1, b2, b3, b4;
    TextView t1;
   Double x,y,z;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        e1 = (EditText) findViewById(R.id.n1);
        e2 = (EditText) findViewById(R.id.n2);
        b1 = (Button) findViewById(R.id.b1);
        b2 = (Button) findViewById(R.id.b2);
        b3 = (Button) findViewById(R.id.b3);
        b4 = (Button) findViewById(R.id.b4);
        t1 = (TextView) findViewById(R.id.t1);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                x = Double.parseDouble(e1.getText().toString());
                y =Double.parseDouble(e2.getText().toString());
                z = x + y;
                t1.setText("The Sum is " + z);

            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                x = Double.parseDouble(e1.getText().toString());
                y = Double.parseDouble(e2.getText().toString());
                z = x - y;
                t1.setText("The difference is " + z);

            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                x = Double.parseDouble(e1.getText().toString());
                y = Double.parseDouble(e2.getText().toString());
                z = x * y;
                t1.setText("The product is " + z);

            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                x = Double.parseDouble(e1.getText().toString());
                y = Double.parseDouble(e2.getText().toString());
                if(y==0) {
                    t1.setText("Can't divide a number by zero");
                    return;
                }
                z = x / y;
                t1.setText("The Quotient is "+z);

            }
        });
    }
}