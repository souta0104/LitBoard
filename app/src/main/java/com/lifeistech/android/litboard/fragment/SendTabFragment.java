package com.lifeistech.android.litboard.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.lifeistech.android.litboard.MessageData;
import com.lifeistech.android.litboard.R;


public class SendTabFragment extends Fragment {

    EditText editText;
    MessageData data;

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference refMsg = database.getReference();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_tab_send, container, false);

        editText = (EditText) v.findViewById(R.id.editTextSend);

        v.findViewById(R.id.imageButton3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!editText.getText().toString().equals(null)||!editText.getText().toString().equals("")) {
                    data = MessageTabFragment.dataSave("テスターA", editText.getText().toString(), 11, 13);
                    Log.d("log", "びよーん");
                    refMsg.push().setValue(data);
                }
            }
        });

        return v;
    }

}
