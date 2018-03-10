package com.lifeistech.android.litboard;

import java.util.ArrayList;
import java.util.HashMap;

public class MessageData {
    private String message;
    private String sender;
    private int hour;
    private int minute;
    private String senderUid;

    public MessageData() {

    }

    public MessageData(String message, String sender, int hour, int minute,String senderUid) {
        this.message = message;
        this.sender = sender;
        this.hour = hour;
        this.minute = minute;
        this.senderUid=senderUid;
    }


    public int getHour() {
        return hour;
    }

    public int getMinute() {
        return minute;
    }

    public String getMessage() {
        return message;
    }

    public String getSender() {
        return sender;
    }


    public void setSender(String sender) {
        this.sender = sender;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getSenderUid() {
        return senderUid;
    }

    public void setSenderUid(String senderUid) {
        this.senderUid = senderUid;
    }
}
