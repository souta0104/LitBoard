package com.lifeistech.android.litboard;

import java.util.ArrayList;
import java.util.HashMap;

public class MessageData {
    private int userId;
    private String userName;
    private int chatroomId;
    private String chatrommName;
    private HashMap<String, Boolean> isChatroomJoin;
    private HashMap<String, Boolean> isMessageHave;
    private int messageId;
    private String message;
    private int sender;
    private int hour;
    private int minute;

    public MessageData() {

    }

    public MessageData(int userId, String userName, int chatroomId, String chatrommName,
                       HashMap<String, Boolean> isChatroomJoin, HashMap<String, Boolean> isMessageHave, int messageId, String message, int sender, int hour, int minute) {
        this.userId = userId;
        this.userName = userName;
        this.chatroomId = chatroomId;
        this.chatrommName = chatrommName;
        this.isChatroomJoin = isChatroomJoin;
        this.isMessageHave = isMessageHave;
        this.messageId = messageId;
        this.message = message;
        this.sender = sender;
        this.hour = hour;
        this.minute = minute;
    }

}
