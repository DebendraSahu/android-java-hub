package com.deben.recyclerviewexample;

import android.annotation.SuppressLint;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class UserViewHolder extends RecyclerView.ViewHolder {
    UserData userData;
    ItemClickListener clickListener;
    TextView userNameTv;
    TextView userAgeTv;
    ImageView userProfileIv;
    View view;

    public UserViewHolder(@NonNull View itemView) {
        super(itemView);
        view = itemView;
        userNameTv = itemView.findViewById(R.id.user_name);
        userAgeTv = itemView.findViewById(R.id.user_age);
        userProfileIv = itemView.findViewById(R.id.user_profile);

    }

    @SuppressLint("DefaultLocale")
    public void bind(UserData data, ItemClickListener listener) {
        if (data == null) return;
        userNameTv.setText(data.name);
        userAgeTv.setText(String.format("%d", data.age));
        clickListener = listener;
        userData = data;
        view.setOnClickListener(v -> clickListener.onClick(data));
    }
}
