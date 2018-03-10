package com.lifeistech.android.litboard;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;


public class MessageAdapter extends RecyclerView.Adapter<MessageViewHolder> {

    private ArrayList<MessageData> list;
    int isMine;

    public MessageAdapter(ArrayList<MessageData> list, int isMine) {
        this.list = list;
        this.isMine=isMine;
    }

    @Override
    public MessageViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        MessageViewHolder vh;
        if (viewType == 0) {
            View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_message_sent, parent, false);
            vh = new MessageViewHolder(inflate);
        } else {
            View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_message_received, parent, false);
            vh = new MessageViewHolder(inflate);

        }
        return vh;
    }

    @Override
    public void onBindViewHolder(MessageViewHolder holder, int position) {
        if (isMine == 0) {
            holder.textMessageBodyFrom.setText(list.get(position).getMessage().toString());
            holder.textMessageTimeFrom.setText(list.get(position).getHour() + ":" + list.get(position).getMinute());

        } else {
//            holder.textMessageName.setText(list.get(position).getSender());
            holder.textMessageBodyTo.setText(list.get(position).getMessage().toString());
            holder.textMessageTimeTo.setText(list.get(position).getHour() + ":" + list.get(position).getMinute());
        }
    }



    @Override
    public int getItemCount() {
        return list.size();
    }

}