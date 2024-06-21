package com.deben.recyclerviewexample;

import android.os.Bundle;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

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

        RecyclerView recyclerView = findViewById(R.id.user_recycler_view);
        List<UserData> userDataList = new ArrayList<>();
        userDataList.add(new UserData("Devendra", 24));
        userDataList.add(new UserData("Sameer", 25));
        userDataList.add(new UserData("Tejo", 24));
        userDataList.add(new UserData("Manoj", 21));
        userDataList.add(new UserData("Arvind", 24));

        ItemClickListener clickListener = userData -> {
            Toast.makeText(getApplicationContext(), "user Info : " + userData.toString(), Toast.LENGTH_SHORT).show();
        };

        UserAdapter adapter = new UserAdapter(userDataList, getApplicationContext(), clickListener);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
    }

    @Override
    protected void onResume() {
        super.onResume();


    }
}