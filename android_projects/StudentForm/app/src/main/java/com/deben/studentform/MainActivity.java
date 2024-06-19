package com.deben.studentform;

import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

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
        EditText ageEt = findViewById(R.id.age);
        RadioGroup genderRg = findViewById(R.id.gender);
        CheckBox mathCb = findViewById(R.id.math_sub);
        CheckBox scienceCb = findViewById(R.id.sc_sub);
        CheckBox socialScienceCb = findViewById(R.id.so_sc_sub);
        CheckBox englishCb = findViewById(R.id.eng_sub);
        CheckBox teluguCb = findViewById(R.id.telugu_sub);
        Button submitBtn = findViewById(R.id.submit_btn);

        submitBtn.setOnClickListener(v -> {
            String name = nameEt.getText().toString();
            String email = emailEt.getText().toString();
            String age = ageEt.getText().toString();
            RadioButton genderBtn = findViewById(genderRg.getCheckedRadioButtonId());
            String gender = genderBtn.getText().toString();
            String isMathSelected = mathCb.isChecked() ? "Math" : "";
            String isScSelected = scienceCb.isChecked() ? ",Science" : "";
            String isSoScSelected = socialScienceCb.isChecked() ? ",Social Science" : "";
            String isEngSelected = englishCb.isChecked() ? ",English" : "";
            String isTeluguSelected = teluguCb.isChecked() ? ",Telugu" : "";

            Toast.makeText(getApplicationContext(), "name: " + name + ", email: " + email + ", age: " + age + ", gender: " + gender, Toast.LENGTH_LONG).show();
            Snackbar.make(v, "Subject Chosen: " + isMathSelected + isScSelected + isSoScSelected + isEngSelected + isTeluguSelected, Snackbar.LENGTH_LONG).show();
        });

    }
}