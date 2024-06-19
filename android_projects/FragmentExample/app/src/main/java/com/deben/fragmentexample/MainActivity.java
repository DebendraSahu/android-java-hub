package com.deben.fragmentexample;

import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

public class MainActivity extends AppCompatActivity {
    private Fragment mPrevFragment;
    private final FragmentEventListener mFragmentListener = name -> {
        Toast.makeText(getApplicationContext(), "Now You are in " + name, Toast.LENGTH_SHORT).show();
    };

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


        ColorFragment blueFragment = new ColorFragment(FragmentTag.BLUE_TAG, mFragmentListener);
        ColorFragment redFragment = new ColorFragment(FragmentTag.RED_TAG, mFragmentListener);
        ColorFragment yellowFragment = new ColorFragment(FragmentTag.YELLOW_TAG, mFragmentListener);
        mPrevFragment = blueFragment;

        Button button = findViewById(R.id.nav_button);

        button.setOnClickListener(v -> {
            FragmentManager manager = getSupportFragmentManager();
            Fragment fragment;
            if (mPrevFragment.equals(blueFragment)) {
                fragment = redFragment;
            } else if (mPrevFragment.equals(redFragment)) {
                fragment = yellowFragment;
            } else {
                fragment = blueFragment;
            }
            manager.beginTransaction().replace(R.id.fragment_view, fragment).commit();
            mPrevFragment = fragment;

        });
    }
}