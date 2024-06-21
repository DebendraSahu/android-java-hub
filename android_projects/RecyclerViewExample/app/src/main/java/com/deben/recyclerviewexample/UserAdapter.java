package com.deben.recyclerviewexample;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class UserAdapter extends RecyclerView.Adapter<UserViewHolder> {
    List<UserData> userDataList;
    Context context;
    ItemClickListener clickListener;

    public UserAdapter(List<UserData> userDataList, Context context, ItemClickListener clickListener) {
        this.userDataList = userDataList;
        this.context = context;
        this.clickListener = clickListener;
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View userDataview = inflater.inflate(R.layout.user_item_view, parent, false);
        return new UserViewHolder(userDataview);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        if (userDataList != null) {
            holder.bind(userDataList.get(position), clickListener);
        }
    }

    @Override
    public int getItemCount() {
        return userDataList.size();
    }
}
