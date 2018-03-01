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

    public int getUserId() {
        return userId;
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

    public int getChatroomId() {
        return chatroomId;
    }

    public int getMessageId() {
        return messageId;
    }

    public int getSender() {
        return sender;
    }

    public String getChatrommName() {
        return chatrommName;
    }

    public String getUserName() {
        return userName;
    }

    public HashMap<String, Boolean> getIsChatroomJoin() {
        return isChatroomJoin;
    }

    public HashMap<String, Boolean> getIsMessageHave() {
        return isMessageHave;
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

    public void setChatrommName(String chatrommName) {
        this.chatrommName = chatrommName;
    }

    public void setChatroomId(int chatroomId) {
        this.chatroomId = chatroomId;
    }

    public void setIsChatroomJoin(HashMap<String, Boolean> isChatroomJoin) {
        this.isChatroomJoin = isChatroomJoin;
    }

    public void setIsMessageHave(HashMap<String, Boolean> isMessageHave) {
        this.isMessageHave = isMessageHave;
    }

    public void setMessageId(int messageId) {
        this.messageId = messageId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
