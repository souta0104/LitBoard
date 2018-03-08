package com.lifeistech.android.litboard;

import android.content.Intent;
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
    static ArrayList<UserData> data;

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

        refMsg.child("user").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                data.clear();
                for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                    data.add(dataSnapshot1.getValue(UserData.class));
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        auth.addAuthStateListener(new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                user = auth.getCurrentUser();
                if (user != null) {
                    int i = 0;
                    Boolean isMatch = false;

                    do {
                        if (data.size() != 0) {
                            if (firebaseAuth.getCurrentUser().getUid().equals(data.get(i).getUID())) {
                                isMatch = true;
                                break;
                            } else {
                                isMatch = false;
                            }
                        }
                        if (isMatch) {
                            continue;
                        } else {
                            i++;
                        }
                    } while (i < data.size());

                    if (data.size() == 0) {
                        setFirebaseUser("sota", auth.getCurrentUser().getUid(), auth.getCurrentUser().getEmail());
                    } else if (isMatch == false) {
                        setFirebaseUser("sota", auth.getCurrentUser().getUid(), auth.getCurrentUser().getEmail());
                    }
                }
            }
        });

        if (user == null)

        {
            startLoginActivity();
        } else

        {
            text.setText(user.getEmail());
        }
    }

    public void logout(View v) {
        LoginManager.getInstance().logOut();
        auth.signOut();
        startLoginActivity();

    }

    public void setFirebaseUser(String name, String Uid, String email) {
        user = auth.getCurrentUser();
        data.add(new UserData(name, Uid, email));
        refMsg.child("user").setValue(data);
    }

    public void startLoginActivity() {
        startActivity(new Intent(this, LoginActivity.class));
    }

}