package com.lifeistech.android.litboard.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.lifeistech.android.litboard.MessageData;
import com.lifeistech.android.litboard.R;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.TimeZone;


public class SendTabFragment extends Fragment {

    EditText editText;
    ArrayList<MessageData> data;


    FirebaseDatabase database;
    DatabaseReference refMsg;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_tab_send, container, false);
        data = new ArrayList<MessageData>();
        editText = (EditText) v.findViewById(R.id.editTextSend);
        database = FirebaseDatabase.getInstance();
        refMsg = database.getReference();

        v.findViewById(R.id.imageButton3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //時間取得関係ここから
                Calendar cTime = Calendar.getInstance();
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
                //ここまで

                MessageData messageData = MessageTabFragment.dataSave(0, editText.getText().toString(),
                        cTime.get(cTime.HOUR_OF_DAY), cTime.get(cTime.MINUTE));
                data.add(messageData);
                refMsg.child("chat").child("0").child("message").setValue(data);
                editText.setText(null);
            }
        });


        refMsg.child("chat").child("0").child("message").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                data.clear();
                for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                    data.add(dataSnapshot1.getValue(MessageData.class));
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        return v;
    }

}
