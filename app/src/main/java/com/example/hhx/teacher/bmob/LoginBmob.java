package com.example.hhx.teacher.bmob;

import com.example.hhx.teacher.Registered;

import cn.bmob.v3.BmobObject;
import cn.bmob.v3.listener.SaveListener;

/**
 * Created by 哈哈嘻 on 2016/11/6.
 */

public class LoginBmob extends BmobObject{
    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}
