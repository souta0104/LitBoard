package com.lifeistech.android.litboard;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


public class MessageAdapter extends RecyclerView.Adapter<MessageViewHolder> {

    private ArrayList<MessageData> list;

    public MessageAdapter(ArrayList<MessageData> list) {
        this.list = list;
    }

    @Override
    public MessageViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        MessageViewHolder vh;
        if (viewType == 0) {
            View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_message_received, parent, false);
            vh = new MessageViewHolder(inflate);
        } else {
            View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_message_sent, parent, false);
            vh = new MessageViewHolder(inflate);
        }
        return vh;
    }

    @Override
    public void onBindViewHolder(MessageViewHolder holder, int position) {
        if (holder.getItemViewType() == 0) {
            holder.textMessageName.setText(list.get(position).getSender().toString());
            holder.textMessageBodyTo.setText(list.get(position).getMessage().toString());
            holder.textMessageTimeTo.setText(list.get(position).getHour() + ":" + list.get(position).getMinute());
        }else {
            holder.textMessageBodyFrom.setText(list.get(position).getMessage().toString());
            holder.textMessageTimeFrom.setText(list.get(position).getHour() + ":" + list.get(position).getMinute());
        }
    }

    @Override
    public int getItemViewType(int position) {
        // サンプルコードなので手軽に position が偶数の項目と奇数の項目で view type を分ける。
        return position % 2;
    }


    @Override
    public int getItemCount() {
        return list.size();
    }
}
