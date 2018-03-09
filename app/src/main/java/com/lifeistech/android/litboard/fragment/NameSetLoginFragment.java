package com.lifeistech.android.litboard.fragment;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.lifeistech.android.litboard.LoginActivity;
import com.lifeistech.android.litboard.MainActivity;
import com.lifeistech.android.litboard.R;
import com.lifeistech.android.litboard.UserData;

import java.util.ArrayList;

/**
 * Created by Soutahagiwara on 2018/03/09.
 */

public class NameSetLoginFragment extends android.support.v4.app.Fragment {
    View v;
    ImageButton sendName;
    EditText editText;
    SharedPreferences pref;
    FirebaseUser user;
    FirebaseAuth auth;
    ArrayList<UserData> data;
    FirebaseDatabase database;
    DatabaseReference refMsg;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_login_set_name, container, false);
        sendName = (ImageButton) v.findViewById(R.id.button3);
        editText = (EditText) v.findViewById(R.id.editTextuser);
        pref = this.getActivity().getSharedPreferences("userName", Context.MODE_PRIVATE);
        user = FirebaseAuth.getInstance().getCurrentUser();
        auth = FirebaseAuth.getInstance();
        data = new ArrayList<UserData>();
        database = FirebaseDatabase.getInstance();
        refMsg = database.getReference();

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

        sendName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                user = auth.getCurrentUser();
                if (user != null) {
                    int i = 0;
                    Boolean isMatch = false;

                    do {
                        if (data.size() != 0) {
                            if (FirebaseAuth.getInstance().getCurrentUser().getUid().equals(data.get(i).getUID())) {
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
                        setFirebaseUser(editText.getText().toString(), auth.getCurrentUser().getUid(), auth.getCurrentUser().getEmail());
                    } else if (isMatch == false) {
                        setFirebaseUser(editText.getText().toString(), auth.getCurrentUser().getUid(), auth.getCurrentUser().getEmail());
                    }

                }
                getActivity().finish();

            }
        });

        return v;
    }

    public void setFirebaseUser(String name, String Uid, String email) {
        user = auth.getCurrentUser();
        data.add(new UserData(name, Uid, email));
        refMsg.child("user").setValue(data);
    }

}
