package com.lifeistech.android.litboard;

import java.util.ArrayList;
import java.util.HashMap;


public class UserData {
    private String userName;
    private String UID;
    private HashMap<Integer, Boolean> chatJoin;
    private String email;
    private String Uid_userName;

    public UserData() {

    }


    public UserData(String userName, String UID, String email, String uid_userName) {
        this.userName = userName;
        this.UID = UID;
        this.email = email;
        this.Uid_userName = uid_userName;
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

    public String getUid_userName() {
        return Uid_userName;
    }

    public void setUid_userName(String uid_userName) {
        Uid_userName = uid_userName;
    }

    public boolean equals(Object obj) {
        if (obj == UserData.class) {
            UserData ud = (UserData) obj;
            String tcStr = ud.getUserName();
            return ud.equals(tcStr);
        } else if (obj.equals(String.class)) {
            String ud = obj.toString();
            String tcStr = ud;
            return ud.equals(tcStr);
        }else{
            return false;
        }
    }
}
