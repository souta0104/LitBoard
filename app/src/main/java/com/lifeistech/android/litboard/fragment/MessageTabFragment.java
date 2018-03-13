package com.lifeistech.android.litboard.fragment;

import android.content.ClipData;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.lifeistech.android.litboard.R;
import com.lifeistech.android.litboard.MessageAdapter;
import com.lifeistech.android.litboard.MessageData;

import java.util.ArrayList;
import java.util.HashMap;

public class MessageTabFragment extends Fragment {
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference refMsg = database.getReference();
    MessageAdapter adapter;
    int isMine;
    RecyclerView rv;
    ArrayList<MessageData> message;
    SharedPreferences pref;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_tab_message, container, false);
        rv = (RecyclerView) v.findViewById(R.id.RecyclerView);
        pref = this.getActivity().getSharedPreferences("user", Context.MODE_PRIVATE);
        isMine = 0;

        message = new ArrayList<MessageData>();
        adapter = new MessageAdapter(message);


        LinearLayoutManager llm = new LinearLayoutManager(getContext());
        rv.setHasFixedSize(true);
        rv.setLayoutManager(llm);
        rv.setAdapter(adapter);

        refMsg.child("chat").child("0").child("message").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                rv.scrollToPosition(adapter.getItemCount() - 1);
                message.clear();
                int i = 0;
                for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                    MessageData messageData = dataSnapshot1.getValue(MessageData.class);
                    if (pref.getString("userUid", "").equals(messageData.getSenderUid())) {
                        isMine = 0;
                    } else {
                        isMine = 1;
                    }
                    message.add(messageData);
                    message.get(i).setMine(isMine);
                    i++;
                }
                rv.scrollToPosition(adapter.getItemCount() - 1);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        refMsg.child("chat").child("0").child("message").removeEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {
                rv.scrollToPosition(adapter.getItemCount() - 1);
                message.clear();
                for (DataSnapshot dataSnapshot1 : dataSnapshot.getChildren()) {
                    MessageData messageData = dataSnapshot1.getValue(MessageData.class);
                    if (pref.getString("userUid", "").equals(messageData.getSenderUid())) {
                        isMine = 0;
                    } else {
                        isMine = 1;
                    }
                    message.add(messageData);
                }
                rv.scrollToPosition(adapter.getItemCount() - 1);
            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });


        return v;
    }


    public static MessageData dataSave(String sender, String message, int hour, int minute, String senderUid) {
        MessageData messageData = new MessageData(sender, message, hour, minute, senderUid);
        return messageData;
    }

}