package com.lifeistech.android.litboard;

import android.content.Intent;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.facebook.login.LoginManager;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    FirebaseAuth auth;
    TextView text;
    FirebaseDatabase database;
    DatabaseReference refMsg;
    FirebaseUser user;
    HashMap<Integer, Boolean> chatJoin;
    ArrayList<UserData> userData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        auth = FirebaseAuth.getInstance();
        text = (TextView) findViewById(R.id.text1);
        database = FirebaseDatabase.getInstance();
        refMsg = database.getReference();

        user = auth.getCurrentUser();

        user = auth.getCurrentUser();

        if (user == null) {
            startActivity(new Intent(this, LoginActivity.class));

        } else {
            text.setText(user.getEmail().toString());

        }
    }

    public void logout(View v) {
        LoginManager.getInstance().logOut();
        auth.signOut();
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }
}