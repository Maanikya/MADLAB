package com.example.myapplication4mt19cs073lab8;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    Button call_button, save_button, del_button;
    EditText phoneNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        call_button = (Button) findViewById(R.id.btCall);
        save_button = (Button) findViewById(R.id.btSave);
        del_button = (Button) findViewById(R.id.btDel);
        phoneNumber = (EditText) findViewById(R.id.display);

        call_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent call_intent = new Intent(Intent.ACTION_DIAL);
                call_intent.setData(Uri.parse("tel:" + phoneNumber.getText().toString()));
                startActivity(call_intent);
            }
        });

        save_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_INSERT);
                intent.setType(ContactsContract.Contacts.CONTENT_TYPE);

                intent.putExtra(ContactsContract.Intents.Insert.PHONE, phoneNumber.getText().toString());
                startActivity(intent);
            }
        });

        del_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                phoneNumber.setText("");
            }
        });
    }

    public void number(View V) {
        Button button = (Button) V;
        String digit = button.getText().toString();
        String phoneNum = phoneNumber.getText().toString();
        phoneNumber.setText(phoneNum + digit);
    }
}