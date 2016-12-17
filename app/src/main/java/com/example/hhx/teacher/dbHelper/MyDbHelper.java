package com.example.hhx.teacher.dbHelper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

/**
 * Created by 哈哈嘻 on 2016/11/5.
 */

public class MyDbHelper extends SQLiteOpenHelper {
    private Context mContext;
    public static final String CREATE_LOGIN="create table Login("+"id integer primary key autoincrement,"+"username text,"+"password text)";
    public MyDbHelper(Context context, String name, SQLiteDatabase.CursorFactory factory,int version) {
        super(context, name, null, version);
        mContext=context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_LOGIN);
        Toast.makeText(mContext,"数据库创建成功", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}