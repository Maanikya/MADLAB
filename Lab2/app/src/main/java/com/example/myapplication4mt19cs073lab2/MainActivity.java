package com.example.myapplication4mt19cs073lab2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText e1;
    Button b1, b2, b3, b4, b5, b6, b7, b8, b9, b0, bC, bplus, bminus, bdiv, bmul, beq;
    boolean add=false, sub=false, mul=false, div=false;
    float v1, v2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b1 = (Button)findViewById(R.id.bt1);
        b2 = (Button)findViewById(R.id.bt2);
        b3 = (Button)findViewById(R.id.bt3);
        b4 = (Button)findViewById(R.id.bt4);
        b5 = (Button)findViewById(R.id.bt5);
        b6 = (Button)findViewById(R.id.bt6);
        b7 = (Button)findViewById(R.id.bt7);
        b8 = (Button)findViewById(R.id.bt8);
        b9 = (Button)findViewById(R.id.bt9);
        b0 = (Button)findViewById(R.id.bt0);
        bC = (Button)findViewById(R.id.btC);
        bplus = (Button)findViewById(R.id.btplus);
        bminus = (Button)findViewById(R.id.btminus);
        bdiv = (Button)findViewById(R.id.btdiv);
        bmul = (Button)findViewById(R.id.btmul);
        beq = (Button)findViewById(R.id.bteq);
        e1 = (EditText)findViewById(R.id.ed1);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                e1.setText("1");
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { e1.setText("2"); }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                e1.setText("3");
            }
        });

        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                e1.setText("4");
            }
        });

        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                e1.setText("5");
            }
        });

        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                e1.setText("6");
            }
        });

        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                e1.setText("7");
            }
        });

        b8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                e1.setText("8");
            }
        });

        b9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                e1.setText("9");
            }
        });

        b0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                e1.setText("0");
            }
        });

        bC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                e1.setText("");
            }
        });

        bplus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                v1 = Float.parseFloat(String.valueOf(e1.getText()));
                add = true;
            }
        });

        bminus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                v1 = Float.parseFloat(String.valueOf(e1.getText()));
                sub = true;
            }
        });

        bmul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                v1 = Float.parseFloat(String.valueOf(e1.getText()));
                mul = true;
            }
        });

        bdiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                v1 = Float.parseFloat(String.valueOf(e1.getText()));
                div = true;
            }
        });

        beq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                v2 = Float.parseFloat(String.valueOf(e1.getText()));

                if(add == true) {
                    float res = v1+v2;
                    e1.setText(String.valueOf(res));
                    add = false;
                }

                else if(sub == true) {
                    float res = v1-v2;
                    e1.setText(String.valueOf(res));
                    sub = false;
                }

                else if(mul == true) {
                    float res = v1*v2;
                    e1.setText(String.valueOf(res));
                    mul = false;
                }

                else if(div == true) {
                    float res = v1/v2;
                    e1.setText(String.valueOf(res));
                    div = false;
                }
            }
        });
    }
}