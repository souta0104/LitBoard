package com.lifeistech.android.litboard.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_tab_message, container, false);

        RecyclerView rv = (RecyclerView) v.findViewById(R.id.RecyclerView);

        list = new ArrayList<>();
        adapter = new MessageAdapter(list);

        LinearLayoutManager llm = new LinearLayoutManager(getContext());
        rv.setHasFixedSize(true);
        rv.setLayoutManager(llm);
        rv.setAdapter(adapter);

        refMsg.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        return v;
    }

    public static MessageData dataSave(String sender, String message, int hour, int minute) {
        MessageData messageData = new MessageData();
        return messageData;
    }
}