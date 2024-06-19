package com.deben.fragmentexample;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class ColorFragment extends Fragment {
    FragmentTag tag;
    String fragmentName;
    FragmentEventListener fragmentEventListener;


    public ColorFragment(FragmentTag tag, FragmentEventListener fragmentEventListener) {
        this.tag = tag;
        if (tag == FragmentTag.BLUE_TAG) {
            this.fragmentName = "Blue\nFragment";
        } else if (tag == FragmentTag.RED_TAG) {
            this.fragmentName = "Red\nFragment";
        } else {
            this.fragmentName = "Yellow\nFragment";
        }

        if (fragmentEventListener == null)
            throw new IllegalArgumentException("Listener can't be null");
        this.fragmentEventListener = fragmentEventListener;
    }

    public ColorFragment() {
        this.tag = FragmentTag.YELLOW_TAG;
        this.fragmentName = "Yellow\nFragment";
        fragmentEventListener = name -> {
            Toast.makeText(getContext(), "Default event Handler on " + fragmentName, Toast.LENGTH_SHORT).show();
        };
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_color, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (tag == FragmentTag.BLUE_TAG) {
            view.setBackgroundColor(getResources().getColor(R.color.blue));
        } else if (tag == FragmentTag.RED_TAG) {
            view.setBackgroundColor(getResources().getColor(R.color.red));
        } else {
            view.setBackgroundColor(getResources().getColor(R.color.yellow));
        }

        TextView fragmentNameTv = view.findViewById(R.id.fragment_name);
        fragmentNameTv.setText(fragmentName);

        view.setOnClickListener(v -> {
            if (fragmentEventListener != null) fragmentEventListener.onClick(fragmentName);
        });
    }

}
