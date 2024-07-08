package com.deben.mvvmexample;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.ViewModelProvider;

public class MainActivity extends AppCompatActivity {

    @SuppressLint("SetTextI18n")
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

        EditText nameEt = findViewById(R.id.name);
        EditText emailEt = findViewById(R.id.email);
        Button submitButton = findViewById(R.id.submit_btn);
        TextView outputTv = findViewById(R.id.output);

        PersonViewModel personViewModel = new ViewModelProvider(this).get(PersonViewModel.class);

        submitButton.setOnClickListener(v -> {
            String name = nameEt.getText().toString();
            String email = emailEt.getText().toString();
            personViewModel.setPersonInfo(name, email);
        });

        personViewModel.getPerson().observe(this, person -> {
            if (person != null) outputTv.setText("OUTPUT : \n\n" + person);
        });
    }
}