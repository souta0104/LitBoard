package com.lifeistech.android.litboard;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;


public class MessageViewHolder extends RecyclerView.ViewHolder {
    public TextView textMessageName;
    public TextView textMessageBodyTo;
    public TextView textMessageTimeTo;
    public TextView textMessageBodyFrom;
    public TextView textMessageTimeFrom;

    public MessageViewHolder(View itemView) {
        super(itemView);

        textMessageName = (TextView) itemView.findViewById(R.id.text_message_name);
        textMessageBodyTo = (TextView) itemView.findViewById(R.id.text_message_body_to);
        textMessageTimeTo = (TextView) itemView.findViewById(R.id.text_message_time_to);

        textMessageBodyFrom = (TextView) itemView.findViewById(R.id.text_message_body);
        textMessageTimeFrom = (TextView) itemView.findViewById(R.id.text_message_time);
    }
}