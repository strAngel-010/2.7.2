package com.example.a272;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class UserRegistration extends AppCompatActivity implements View.OnClickListener{
    TextView text;
    Button signUp;
    EditText loginEditor, passwordEditor;
    final String password = "myPasswordIs12345";
    final String login = "geniusLogin";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_registration);
        text = findViewById(R.id.heading);
        signUp = findViewById(R.id.signUp);
        loginEditor = findViewById(R.id.login);
        passwordEditor = findViewById(R.id.password);
        signUp.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent i = new Intent();
        i.putExtra("login", loginEditor.getText().toString());
        i.putExtra("password", passwordEditor.getText().toString());
        setResult(1, i);
        finish();
    }
}
