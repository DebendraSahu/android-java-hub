package com.example.userloginform;

import android.content.Context;
import android.content.Intent;
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

public class Signup extends AppCompatActivity {
     public EditText nameText,emailText,passwordText,ageText,genderText;
     public Button submitButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_signup);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        nameText = findViewById(R.id.name);
        emailText = findViewById(R.id.email);
        passwordText = findViewById(R.id.password);
        ageText = findViewById(R.id.age);
        genderText = findViewById(R.id.gender);
        submitButton = findViewById(R.id.signup);
        submitButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                handleSubmit();
            }
        });
    }

    private void handleSubmit(){
        String name = nameText.getText().toString();
        String email = emailText.getText().toString();
        String password = passwordText.getText().toString();
        String age = ageText.getText().toString();
        String gender = genderText.getText().toString();

        SharedPreferences sharedPreferences = getSharedPreferences("UserPrefs", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("Name", name);
        editor.putString("Email", email);
        editor.putString("Password", password);
        editor.putString("Age", age);
        editor.putString("Gender", gender);
        editor.apply();

        Toast.makeText(Signup.this, "Signup Successful", Toast.LENGTH_LONG).show();

        Intent intent = new Intent(Signup.this, MainActivity.class);
        startActivity(intent);
    }
}