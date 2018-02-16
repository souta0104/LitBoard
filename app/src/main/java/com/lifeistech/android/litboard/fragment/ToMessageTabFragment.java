package com.lifeistech.android.litboard.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.lifeistech.android.litboard.MainActivity;
import com.lifeistech.android.litboard.R;
import com.lifeistech.android.litboard.ToMessageAdapter;
import com.lifeistech.android.litboard.ToMessageData;

import java.util.ArrayList;

/**
 * Created by Soutahagiwara on 2018/02/14.
 */

public class ToMessageTabFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_tab_message_to, container, false);

        RecyclerView rv = (RecyclerView) v.findViewById(R.id.RecyclerViewTo);

        ArrayList<ToMessageData> list = new ArrayList<>();
        list.add(dataSave("hoge","ts1",11,13));

        ToMessageAdapter adapter = new ToMessageAdapter(list);

        LinearLayoutManager llm = new LinearLayoutManager(getContext());
        rv.setHasFixedSize(true);
        rv.setLayoutManager(llm);
        rv.setAdapter(adapter);

        list.add(dataSave("test","ts2fghjklkjhgfghjklkjhgfghjkjhgfghjklkjh",00,19));

        return v;
    }

    public ToMessageData dataSave(String sender,String message,int hour,int minute){
        ToMessageData toMessageData = new ToMessageData();
        toMessageData.setSender(sender);
        toMessageData.setMessage(message);
        toMessageData.setHour(hour);
        toMessageData.setMinute(minute);
        return toMessageData;
    }
}