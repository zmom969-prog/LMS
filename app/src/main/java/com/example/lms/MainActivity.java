
package com.example.lms;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.CrossProfileApps;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

    private EditText etUsername, etPassword;
    private Button btnLogin;
    private TextView tvForgotPassword, tvRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getWindow().setStatusBarColor(
                android.graphics.Color.rgb(27, 9, 139)
        );

        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);
        btnLogin = findViewById(R.id.btnLogin);
        tvForgotPassword = findViewById(R.id.tvForgotPassword);
        tvRegister = findViewById(R.id.tvRegister);

        // Intent

        btnLogin.setOnClickListener(v -> {
            Intent i = new Intent(
                    MainActivity.this,
                   Profile.class
            );
            startActivity(i);
        });


    }
}
