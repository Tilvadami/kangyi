package com.example.kangyi;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {

    private Button btn_login;
    private EditText edit_Name;
    private EditText edit_Pwd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //获取到组件
        getViews();

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent ;
                String name = edit_Name.getText().toString();
                String pwd = edit_Pwd.getText().toString();
                if("admin".equals(name) && "123456".equals(pwd)){
                    intent = new Intent(LoginActivity.this, Activity_mine.class);
//                    Bundle bundle = new Bundle();
//                    bundle.putString("name",edit_Name.getText().toString());
//                    bundle.putString("pwd",edit_Pwd.getText().toString());
                    intent.putExtra("name",edit_Name.getText().toString());
                    setResult(2,intent);
                    finish();
                }
            }
        });

    }
    //封装获取组件的方法
    private void getViews(){
        btn_login = (Button) findViewById(R.id.btn_login);
        edit_Name = (EditText) findViewById(R.id.name);
        edit_Pwd = (EditText) findViewById(R.id.pwd);
    }
}