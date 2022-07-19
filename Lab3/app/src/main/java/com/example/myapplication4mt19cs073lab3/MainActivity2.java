package com.example.myapplication4mt19cs073lab3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {

    EditText usrname_signin, passwd_signin;
    Button login;
    String registerd_username, registered_passwd;
    String entered_username_sigin, entered_passwd_sigin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        usrname_signin = (EditText)findViewById(R.id.uns);
        passwd_signin = (EditText)findViewById(R.id.pwds);
        login = (Button)findViewById(R.id.logins);

        Bundle extras = getIntent().getExtras();
        registerd_username = extras.getString("uname");
        registered_passwd = extras.getString("pwd");

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                entered_username_sigin = usrname_signin.getText().toString();
                entered_passwd_sigin = passwd_signin.getText().toString();

                if(entered_username_sigin.equals(registerd_username)&&(entered_passwd_sigin.equals(registered_passwd))) {
                    Toast.makeText(MainActivity2.this, "Success", Toast.LENGTH_SHORT).show();
                    System.out.println("\nValid Username and Password. Sign In Successful.\n");

                }

                else {
                    Toast.makeText(MainActivity2.this, "Invalid Credentials", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}