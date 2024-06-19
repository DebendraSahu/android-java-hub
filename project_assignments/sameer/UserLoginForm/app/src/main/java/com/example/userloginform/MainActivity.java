package com.example.userloginform;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    public EditText usernameL, passwordL;
    public Button loginButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        usernameL = findViewById(R.id.usernameLogin);
        passwordL = findViewById(R.id.passwordLogin);
        loginButton = findViewById(R.id.login);

        loginButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                handleLogin();
            }
        });
    }

    private void handleLogin(){
        String username = usernameL.getText().toString();
        String password = passwordL.getText().toString();

        SharedPreferences sharedPreferences = getSharedPreferences("UserPrefs", Context.MODE_PRIVATE);
        String savedName = sharedPreferences.getString("Name", null);
        String savedPassword = sharedPreferences.getString("Password", null);

        // Check if the retrieved data matches the user input
        if (savedName != null && savedPassword != null) {
            if (username.equals(savedName) && password.equals(savedPassword)) {
                Toast.makeText(MainActivity.this, "Login Successful", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(MainActivity.this, "Invalid Credentials", Toast.LENGTH_LONG).show();
            }
        } else {
            Toast.makeText(MainActivity.this, "No Signup Data Found", Toast.LENGTH_LONG).show();
        }
    }
}