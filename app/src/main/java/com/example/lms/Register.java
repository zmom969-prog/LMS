
package com.example.lms;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class Register extends Activity {

    EditText fullName, email, username;
    EditText password, confirmPassword;

    Button registerButton;
    TextView backButton, loginText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_register);

        // Initialize Views
        fullName = findViewById(R.id.fullName);
        email = findViewById(R.id.email);
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        confirmPassword = findViewById(R.id.confirmPassword);

        registerButton = findViewById(R.id.registerButton);
        backButton = findViewById(R.id.backButton);
        loginText = findViewById(R.id.loginText);

        // Back Button
        backButton.setOnClickListener(v -> finish());

        // Register Button
        registerButton.setOnClickListener(v -> {

            String name = fullName.getText().toString().trim();
            String mail = email.getText().toString().trim();
            String user = username.getText().toString().trim();
            String pass = password.getText().toString();
            String confirm = confirmPassword.getText().toString();

            if (name.isEmpty()) {
                fullName.setError("Enter your name");
                fullName.requestFocus();

            } else if (mail.isEmpty()) {
                email.setError("Enter your email");
                email.requestFocus();

            } else if (!android.util.Patterns.EMAIL_ADDRESS
                    .matcher(mail).matches()) {
                email.setError("Invalid email");
                email.requestFocus();

            } else if (user.isEmpty()) {
                username.setError("Enter username");
                username.requestFocus();

            } else if (pass.isEmpty()) {
                password.setError("Enter password");
                password.requestFocus();

            } else if (confirm.isEmpty()) {
                confirmPassword.setError("Confirm password");
                confirmPassword.requestFocus();

            } else if (!pass.equals(confirm)) {
                confirmPassword.setError("Password does not match");
                confirmPassword.requestFocus();

            } else {
                Toast.makeText(this,
                        "Register Successful!",
                        Toast.LENGTH_SHORT).show();
            }
        });

        // Login Text
        loginText.setOnClickListener(v -> {

            Intent i = new Intent(
                    Register.this,
                    MainActivity.class
            );

            startActivity(i);
        });


        // btn back
        backButton.setOnClickListener(v -> {

            Intent i = new Intent(
                    Register.this,
                    MainActivity.class
            );

            startActivity(i);
        });

    }
}
