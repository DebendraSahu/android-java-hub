package com.deben.retrofitexample;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private ApiService apiService;
    boolean responseReceived = false;

    EditText reqText;
    TextView resText;
    Button reqButton;
    private Runnable updateRunnable;
    private int requestCount;
    private Handler handler;

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
        reqText = findViewById(R.id.req_et);
        resText = findViewById(R.id.res_tv);
        reqButton = findViewById(R.id.req_btn);

        apiService = ApiClient.getRetrofitInstance().create(ApiService.class);
        reqButton.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                int id = 0;
                try {
                    id = Integer.parseInt(reqText.getText().toString());
                } catch (Exception e) {
                    resText.setText("Response : invalid input :" + e.getMessage());
                }
                if (id == 0) return;
                createWaitLog();
                fetchData(id);
            }
        });
    }

    @SuppressLint("SetTextI18n")
    private void fetchData(int id) {
        Call<Post> call = apiService.getPost(id);
        call.enqueue(new Callback<Post>() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onResponse(@NonNull Call<Post> call, @NonNull Response<Post> response) {

                responseReceived = true;
                handler.removeCallbacks(updateRunnable);

                if (response.isSuccessful()) {
                    Post post = response.body();
                    if (post != null) {
                        resText.setText("response : " + post);
                    } else {
                        resText.setText("response data is null");
                    }
                } else {
                    resText.setText("response unsuccessful");
                }
            }

            @Override
            public void onFailure(@NonNull Call<Post> call, @NonNull Throwable throwable) {

                responseReceived = true;
                handler.removeCallbacks(updateRunnable);

                resText.setText("response fail, Error: " + throwable.getMessage());
            }
        });
    }


    private void createWaitLog() {
        requestCount = 0;
        handler = new Handler();
        updateRunnable = new Runnable() {
            @SuppressLint("SetTextI18n")
            @Override
            public void run() {
                requestCount++;
                StringBuilder dots = new StringBuilder();
                for (int i = 0; i < requestCount; i++) {
                    dots.append(".");
                }
                resText.setText("Requesting..." + dots);
                if (!responseReceived) {
                    handler.postDelayed(this, 100);
                }
            }
        };
        handler.post(updateRunnable);
    }
}