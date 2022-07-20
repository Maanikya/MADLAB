package com.example.myapplication4mt19cs073lab3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    Button signup;
    EditText ed1, ed2;
    String usrname, passwd;
    String entered_uname, entered_pwd;
    Pattern pattern;
    Matcher matcher;

    private static final String REG = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,20})";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pattern = Pattern.compile(REG);

        ed1 = (EditText)findViewById(R.id.ed1);
        ed2 = (EditText)findViewById(R.id.ed2);

        signup = (Button)findViewById(R.id.bt1);
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                usrname = ed1.getText().toString();
                passwd = ed2.getText().toString();

                matcher = pattern.matcher(passwd);

                if(!matcher.matches()) {
                    //System.out.println("Wrong Password!!!");
                    Toast.makeText(MainActivity.this,"Sign-Up Failed", Toast.LENGTH_LONG).show();
                    System.out.println("Sign-Up Failed\n");
                }

                else {
                    //System.out.println("Correct Password");
                    Toast.makeText(MainActivity.this,"Sign-Up Success", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                    intent.putExtra("uname", usrname);
                    intent.putExtra("pwd", passwd);
                    startActivity(intent);
                }

                System.out.println("Username : " + usrname);
                System.out.println("Password : " + passwd);
            }
        });
    }
}