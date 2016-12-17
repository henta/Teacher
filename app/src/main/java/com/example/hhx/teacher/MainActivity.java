package com.example.hhx.teacher;

import android.app.DownloadManager;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.hhx.teacher.bmob.LoginBmob;

import java.util.List;

import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;

public class MainActivity extends AppCompatActivity {
    private String userName;
    private EditText editText2;
    private EditText editText;
    private String passWord;
    private BmobQuery<LoginBmob> query;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button_login = (Button) findViewById(R.id.button);
        Button buttton_register = (Button) findViewById(R.id.button2);
        editText = (EditText) findViewById(R.id.editText);
        editText2 = (EditText) findViewById(R.id.editText2);
        editText2.setTransformationMethod(PasswordTransformationMethod.getInstance());
        Bmob.initialize(this, "cb3a585d96b4bedfb1a0d55915ae8df4");
        buttton_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Registered.class);
                startActivity(intent);
            }
        });
        button_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });
    }

    //登录按钮执行判断
    public void login() {
        userName = editText.getText().toString();
        passWord = editText2.getText().toString();
        if (userName.isEmpty()) {
            Toast.makeText(this, "请输入用户名", Toast.LENGTH_SHORT).show();
        } else if (passWord.isEmpty()) {
            Toast.makeText(this, "请输入密码", Toast.LENGTH_SHORT).show();
        } else {
            loginUserQuery();
            Toast.makeText(MainActivity.this, "用户名或密码错误", Toast.LENGTH_SHORT).show();
        }
    }

    //bmob用户名查询
    public void loginUserQuery() {
        query = new BmobQuery<LoginBmob>();
        query.findObjects(new FindListener<LoginBmob>() {
            public void done(List<LoginBmob> list, BmobException e) {
                if (e == null) {
                    for (LoginBmob loginBmob : list) {
                        Log.e("user", loginBmob.getUsername());
                        if (loginBmob.getUsername().equals(userName)&&loginBmob.getPassword().equals(passWord)) {
                            Toast.makeText(MainActivity.this, "登录成功", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                            startActivity(intent);
                            break;
                        }
                    }

                } else {
                    Log.e("hhx", "失败");
                }
            }
        });

    }


}
