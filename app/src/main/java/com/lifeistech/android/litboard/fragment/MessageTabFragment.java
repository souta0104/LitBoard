package com.lifeistech.android.litboard.fragment;

import android.content.ClipData;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.lifeistech.android.litboard.R;
import com.lifeistech.android.litboard.MessageAdapter;
import com.lifeistech.android.litboard.MessageData;

import java.util.ArrayList;

public class MessageTabFragment extends Fragment {
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference refMsg = database.getReference();
    ArrayList<MessageData> list;
    MessageAdapter adapter;

    ArrayList<MessageData> message;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_tab_message, container, false);

        RecyclerView rv = (RecyclerView) v.findViewById(R.id.RecyclerView);

        message = new ArrayList<MessageData>();
        adapter = new MessageAdapter(message);


        LinearLayoutManager llm = new LinearLayoutManager(getContext());
        rv.setHasFixedSize(true);
        rv.setLayoutManager(llm);
        rv.setAdapter(adapter);


        refMsg.child("chat").child("0").child("message").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                message.clear();
                for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                    message.add(dataSnapshot1.getValue(MessageData.class));
                }

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        return v;
    }


    public static MessageData dataSave(int sender, String message, int hour, int minute) {
        MessageData messageData = new MessageData();
        messageData.setSender(sender);
        messageData.setMessage(message);
        messageData.setHour(hour);
        messageData.setMinute(minute);
        return messageData;
    }
}