package com.deben.sqliteexample;

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
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    UserDatabaseHelper mUserDatabaseHelper;

    ArrayList<UserData> mUserDataList;
    UserDataAdapter mUserAdapter;
    RecyclerView mUserListView;
    TextView mUserIdTv;
    EditText mUserNameEt, mEmailEt;
    Button mSaveBtn, mDeleteBtn, mUpdateBtn, mViewAllBtn;
    UserData mSelectedUserData;

    ItemClickListener mItemClickListener = new ItemClickListener() {
        @SuppressLint("DefaultLocale")
        @Override
        public void onItemClick(UserData data) {
            mSelectedUserData = data;
            mUserNameEt.setText(data.name);
            mEmailEt.setText(data.email);
            mUserIdTv.setText(String.format("id: %d", data.id));
        }
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
        initDataBaseHelper();

        mUserDataList = new ArrayList<>();
        initView();
        initClickListeners();

        mUserAdapter = new UserDataAdapter(mUserDataList, mItemClickListener);
        mUserListView.setAdapter(mUserAdapter);
        mUserListView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
    }

    private void initDataBaseHelper() {
        mUserDatabaseHelper = new UserDatabaseHelper(getApplicationContext());
    }

    private void initView() {
        mUserListView = findViewById(R.id.user_recycler_view);
        mUserNameEt = findViewById(R.id.user_name_et);
        mEmailEt = findViewById(R.id.user_email_et);
        mUserIdTv = findViewById(R.id.userId);
        mSaveBtn = findViewById(R.id.save);
        mDeleteBtn = findViewById(R.id.delete);
        mUpdateBtn = findViewById(R.id.update);
        mViewAllBtn = findViewById(R.id.view);
    }

    private void initClickListeners() {
        mSaveBtn.setOnClickListener(v -> insertIntoDataBase());
        mDeleteBtn.setOnClickListener(v -> deleteFromDataBase());
        mUpdateBtn.setOnClickListener(v -> updateIntoDataBase());
        mViewAllBtn.setOnClickListener(v -> viewFromDataBase());

    }

    private void viewFromDataBase() {
        mUserDataList = mUserDatabaseHelper.retrieveFromTable();
        mUserAdapter.setUserDataList(mUserDataList);
    }

    private void updateIntoDataBase() {
        mSelectedUserData.name = mUserNameEt.getText().toString();
        mSelectedUserData.email = mEmailEt.getText().toString();
        mUserDatabaseHelper.updateDataInTable(mSelectedUserData);
        viewFromDataBase();
    }

    private void deleteFromDataBase() {
        if (mSelectedUserData != null) mUserDatabaseHelper.deleteFromTable(mSelectedUserData.id);
        viewFromDataBase();
    }

    private void insertIntoDataBase() {
        String userName = mUserNameEt.getText().toString();
        String email = mEmailEt.getText().toString();
        if (!userName.isEmpty() && !email.isEmpty())
            mUserDatabaseHelper.insertIntoTable(new UserData(0, userName, email));
        viewFromDataBase();
    }
}