package com.lifeistech.android.litboard;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

/**
 * Created by Soutahagiwara on 2018/02/14.
 */

public class MessageViewHolder extends RecyclerView.ViewHolder {
    public TextView textMessageName;
    public TextView textMessageBodyTo;
    public TextView textMessageTimeTo;
    
    public MessageViewHolder(View itemView) {
        super(itemView);

        textMessageName = (TextView) itemView.findViewById(R.id.text_message_name);
        textMessageBodyTo = (TextView) itemView.findViewById(R.id.text_message_body_to);
        textMessageTimeTo = (TextView) itemView.findViewById(R.id.text_message_time_to);
    }
}
