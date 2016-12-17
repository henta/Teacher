package com.example.hhx.teacher;

    import android.content.ContentValues;
    import android.content.Intent;
    import android.database.sqlite.SQLiteDatabase;
    import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
    import android.text.method.PasswordTransformationMethod;
    import android.view.View;
import android.widget.Button;
import android.widget.EditText;
    import android.widget.Toast;

    import com.example.hhx.teacher.bmob.LoginBmob;
    import com.example.hhx.teacher.dbHelper.MyDbHelper;

    import cn.bmob.v3.exception.BmobException;
    import cn.bmob.v3.listener.SaveListener;

public class Registered extends AppCompatActivity {
    private Button button;
    private EditText et1,et2,et3;
    private MyDbHelper dbHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registered);
        button= (Button) findViewById(R.id.button_re);
        et1= (EditText) findViewById(R.id.editText_re);
        et2= (EditText) findViewById(R.id.editText2_re);
        et3= (EditText) findViewById(R.id.editText3_re);
        et2.setTransformationMethod(PasswordTransformationMethod.getInstance());
        et3.setTransformationMethod(PasswordTransformationMethod.getInstance());
        dbHelper=new MyDbHelper(this,"login.db",null,1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                click();

            }
        });
    }
    private void click(){
        Boolean show=true;
        String user;
        String psw;
        String psw2;
        user=et1.getText().toString();
        psw=et2.getText().toString();
        psw2=et3.getText().toString();
        if(user.isEmpty()&&show){
            Toast.makeText(this,"用户名不能为空",Toast.LENGTH_SHORT).show();
            show=false;
        }
        if(user.length()!=12&&show){
            Toast.makeText(this,"用户名为12为学号",Toast.LENGTH_SHORT).show();
            show=false;
        }
        if(psw.isEmpty()&&show){
            Toast.makeText(this,"密码不能为空",Toast.LENGTH_SHORT).show();
            show=false;
        }
        if(!psw.equals(psw2)&&show){
            Toast.makeText(this,"两次密码不相等",Toast.LENGTH_SHORT).show();
            show=false;
        }

        if(show){
            SQLiteDatabase db=dbHelper.getWritableDatabase();
            ContentValues values=new ContentValues();
            values.put("username",user);
            values.put("password",psw);
            db.insert("Login",null,values);
            LoginBmob loginbb=new LoginBmob();
            loginbb.setUsername(user);
            loginbb.setPassword(psw);
            loginbb.save(new SaveListener<String>() {
                @Override
                public void done(String s, BmobException e) {

                }
            });
            Toast.makeText(this,"注册成功",Toast.LENGTH_LONG).show();
            Intent intent=new Intent(Registered.this,MainActivity.class);
            startActivity(intent);

        }
    }
}
