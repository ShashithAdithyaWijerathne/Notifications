package com.example.notifications;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class Registration extends AppCompatActivity {
    EditText name,email;
    Button SignIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        SignIn =(Button) findViewById(R.id.SignIn);
        name =(EditText) findViewById(R.id.name);
        email=(EditText)findViewById(R.id.email);
    }
}
