package com.lifeistech.android.litboard;

import java.util.ArrayList;
import java.util.HashMap;

public class MessageData {
    private String message;
    private int sender;
    private int hour;
    private int minute;

    public MessageData() {

    }

    public MessageData(String message, int sender, int hour, int minute) {
        this.message = message;
        this.sender = sender;
        this.hour = hour;
        this.minute = minute;
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

    public int getSender() {
        return sender;
    }


    public void setSender(int sender) {
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


}
