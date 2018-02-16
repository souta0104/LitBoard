package com.lifeistech.android.litboard;

/**
 * Created by Soutahagiwara on 2018/02/14.
 */

public class FromMassageData {
    private String message;
    private int minute;
    private int hour;
    private String sender;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }
}
