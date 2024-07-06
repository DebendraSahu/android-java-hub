package com.deben.sqliteexample;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class UserDataAdapter extends RecyclerView.Adapter<UserDataAdapter.UserViewHolder> {
    ArrayList<UserData> mUserDataList;
    ItemClickListener mItemClickListener;

    public UserDataAdapter(ArrayList<UserData> userList, ItemClickListener listener) {
        mUserDataList = userList;
        mItemClickListener = listener;
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.user_item, parent, false);
        return new UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        holder.onBind(mItemClickListener, mUserDataList.get(position));
    }

    @Override
    public int getItemCount() {
        return mUserDataList.size();
    }

    @SuppressLint("NotifyDataSetChanged")
    public void setUserDataList(ArrayList<UserData> dataList) {
        mUserDataList = dataList;
        notifyDataSetChanged();
    }


    public static class UserViewHolder extends RecyclerView.ViewHolder {
        public TextView userIdTv;
        public TextView userNameTv;
        public TextView emailTv;
        public ItemClickListener clickListener;
        public UserData userData;

        @SuppressLint("DefaultLocale")
        public void onBind(ItemClickListener listener, UserData data) {
            userIdTv.setText(String.format("%d", data.id));
            userNameTv.setText(data.name);
            emailTv.setText(data.email);
            clickListener = listener;
            userData = data;
        }


        public UserViewHolder(@NonNull View itemView) {
            super(itemView);
            userIdTv = itemView.findViewById(R.id.user_id);
            userNameTv = itemView.findViewById(R.id.user_name);
            emailTv = itemView.findViewById(R.id.user_email);

            itemView.setOnClickListener(v -> {
                if (clickListener != null && userData != null)
                    clickListener.onItemClick(userData);
            });
        }


    }
}
