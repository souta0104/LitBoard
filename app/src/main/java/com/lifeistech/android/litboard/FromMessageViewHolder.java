package com.lifeistech.android.litboard;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

/**
 * Created by Soutahagiwara on 2018/02/14.
 */

public class FromMessageViewHolder extends RecyclerView.ViewHolder {
    public TextView textMessageBody;
    public TextView textMessageTime;

    public FromMessageViewHolder(View itemView) {
        super(itemView);

        textMessageBody =(TextView) itemView.findViewById(R.id.text_message_body);
        textMessageTime = (TextView) itemView.findViewById(R.id.text_message_time);
    }
}
