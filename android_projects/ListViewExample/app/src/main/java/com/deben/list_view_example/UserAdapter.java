package com.deben.list_view_example;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class UserAdapter extends BaseAdapter {
    ArrayList<String> mUserNames;
    Context mContext;

    public UserAdapter(Context context, ArrayList<String> userNames) {
        mContext = context;
        mUserNames = userNames;
    }


    @Override
    public int getCount() {
        return mUserNames.size();
    }

    @Override
    public Object getItem(int position) {
        return mUserNames.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @SuppressLint({"UseCompatLoadingForDrawables", "DefaultLocale"})
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.user_item, parent, false);
        }
        convertView.setBackground(mContext.getDrawable(R.drawable.ic_launcher_background));
        TextView slNoTv = convertView.findViewById(R.id.sl_no_tv);
        TextView userNameTv = convertView.findViewById(R.id.user_name);

        slNoTv.setText(String.format("%d", position + 1));
        userNameTv.setText(mUserNames.get(position));
        return convertView;
    }
}
