package com.example.a272;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    TextView text;
    Button signIn;
    EditText loginEditor, passwordEditor;
    String password = "myPasswordIs12345";
    String login = "geniusLogin";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text = findViewById(R.id.heading);
        signIn = findViewById(R.id.signUp);
        loginEditor = findViewById(R.id.login);
        passwordEditor = findViewById(R.id.password);
        signIn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String loginField = loginEditor.getText().toString();
        String passwordField = passwordEditor.getText().toString();
        if (login.equals(loginField) && password.equals(passwordField)){
            text.setText(R.string.rightPassword);
        } else {
            text.setText(R.string.wrongPassword);
            Intent i = new Intent(MainActivity.this, UserRegistration.class);
            startActivityForResult(i, 1);
        }
        loginEditor.setText("");
        passwordEditor.setText("");
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (resultCode){
            case 1:
                loginEditor.setText(data.getStringExtra("login"));
                login = data.getStringExtra("login");
                password = data.getStringExtra("password");
                break;
        }
    }
}
