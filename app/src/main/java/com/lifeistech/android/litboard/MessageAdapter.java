package com.lifeistech.android.litboard;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by Soutahagiwara on 2018/02/14.
 */

public class MessageAdapter extends RecyclerView.Adapter<MessageViewHolder> {

    private ArrayList<MessageData> list;

    public MessageAdapter(ArrayList<MessageData> list) {
        this.list = list;
    }

    @Override
    public MessageViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_message_received, parent, false);
        MessageViewHolder vh = new MessageViewHolder(inflate);
        return vh;
    }

    @Override
    public void onBindViewHolder(MessageViewHolder holder, int position) {
        holder.textMessageName.setText(list.get(position).getSender().toString());
        holder.textMessageBodyTo.setText(list.get(position).getMessage().toString());
        holder.textMessageTimeTo.setText(list.get(position).getHour() + ":" + list.get(position).getMinute());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
