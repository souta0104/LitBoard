package com.lifeistech.android.litboard;

import java.util.ArrayList;
import java.util.HashMap;


public class UserData {
    private String userName;
    private String UID;
    private HashMap<Integer, Boolean> chatJoin;
    private String email;

    public UserData() {

    }

    public UserData(String userName, String UID, String email) {
        this.userName = userName;
        this.UID = UID;
        this.email = email;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public HashMap<Integer, Boolean> getChatJoin() {
        return chatJoin;
    }

    public void setChatJoin(HashMap<Integer, Boolean> chatJoin) {
        this.chatJoin = chatJoin;
    }

    public void setUID(String UID) {
        this.UID = UID;
    }

    public String getUID() {
        return UID;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }
}
