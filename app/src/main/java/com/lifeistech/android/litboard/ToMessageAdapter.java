package com.lifeistech.android.litboard;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by Soutahagiwara on 2018/02/14.
 */

public class ToMessageAdapter extends RecyclerView.Adapter<ToMessageViewHolder> {

    private ArrayList<ToMessageData> list;

    public ToMessageAdapter(ArrayList<ToMessageData> list) {
        this.list = list;
    }

    @Override
    public ToMessageViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_message_received, parent, false);
        ToMessageViewHolder vh = new ToMessageViewHolder(inflate);
        return vh;
    }

    @Override
    public void onBindViewHolder(ToMessageViewHolder holder, int position) {
        holder.textMessageName.setText(list.get(position).getSender().toString());
        holder.textMessageBodyTo.setText(list.get(position).getMessage().toString());
        holder.textMessageTimeTo.setText(list.get(position).getHour() + ":" + list.get(position).getMinute());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
