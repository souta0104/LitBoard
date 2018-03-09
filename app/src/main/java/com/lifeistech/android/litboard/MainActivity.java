package com.lifeistech.android.litboard;

import android.content.Intent;
import android.content.SharedPreferences;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.facebook.login.LoginManager;
import com.google.firebase.FirebaseApp;
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
    ArrayList<UserData> data;
    SharedPreferences pref;
    String userName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        auth = FirebaseAuth.getInstance();
        text = (TextView) findViewById(R.id.text1);
        database = FirebaseDatabase.getInstance();
        refMsg = database.getReference();
        data = new ArrayList<UserData>();
        user = auth.getCurrentUser();
        pref = getSharedPreferences("userName", MODE_PRIVATE);


        if (user == null) {
            startLoginActivity();
        } else {
            text.setText(user.getEmail());
        }
    }

    public void logout(View v) {
        LoginManager.getInstance().logOut();
        auth.signOut();
        startLoginActivity();

    }

//    public void setFirebaseUser(String name, String Uid, String email) {
//        user = auth.getCurrentUser();
//        data.add(new UserData(name, Uid, email));
//        refMsg.child("user").setValue(data);
//    }

    public void startLoginActivity() {
        startActivity(new Intent(this, LoginActivity.class));
    }

}