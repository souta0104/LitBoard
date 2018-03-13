package com.lifeistech.android.litboard;

public class MessageData {
    private String message;
    private String sender;
    private int hour;
    private int minute;
    private String senderUid;
    private int isMine;

    public MessageData() {

    }

    public MessageData(String message, String sender, int hour, int minute, String senderUid, int isMine) {
        this.message = message;
        this.sender = sender;
        this.hour = hour;
        this.minute = minute;
        this.senderUid = senderUid;
        this.isMine = isMine;
    }

    public MessageData(String sender, String message, int hour, int minute, String senderUid) {
        this.message = message;
        this.sender = sender;
        this.hour = hour;
        this.minute = minute;
        this.senderUid = senderUid;
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

    public boolean euqals(Object obj) {
        if (obj == MessageData.class) {
            MessageData ud = (MessageData) obj;
            String tcStr = ud.getSenderUid();
            return ud.equals(tcStr);
        } else if (obj.equals(String.class)) {
            String ud = obj.toString();
            String tcStr = ud;
            return ud.equals(tcStr);
        } else {
            return false;
        }
    }

    public void setMine(int isMine) {
        this.isMine = isMine;
    }

    public int getMine() {
        return isMine;
    }
}
