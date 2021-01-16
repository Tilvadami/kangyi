package com.example.kangyi;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class Activity_mine extends AppCompatActivity {

    private ImageView iv_level;
    private ImageView iv_check;
    private ImageView iv_healthCode;
    private ImageView iv_touxiang ;
    private TextView tv_name;
//    public boolean isLogged ;
    private Bundle bundle;
    private ImageView health_code;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 1 && resultCode ==2){
            tv_name.setText(data.getStringExtra("name"));
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mine);
        bundle = getIntent().getExtras();


//        isLogged = bundle.getBoolean("isLogged");

        iv_level = (ImageView)findViewById(R.id.level);
        iv_check = (ImageView) findViewById(R.id.check);
        iv_healthCode = (ImageView) findViewById(R.id.healthCode);
        tv_name = (TextView) findViewById(R.id.tv_name);
        iv_touxiang = (ImageView) findViewById(R.id.touxiang);

        iv_level.setBackgroundResource(R.drawable.level);
        iv_check.setBackgroundResource(R.drawable.check);
        iv_healthCode.setBackgroundResource(R.drawable.healthcode);
        iv_touxiang.setBackgroundResource(R.drawable.person);

        health_code = (ImageView) findViewById(R.id.healthCode);

        tv_name.setText("请登录");
        tv_name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Activity_mine.this,LoginActivity.class);
                startActivityForResult(intent,1);
            }
        });


        health_code.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Activity_mine.this,Activity_healthCode.class);
                startActivity(intent);
            }
        });
//        if(bundle != null){
//            tv_name.setText(bundle.getString("name"));
//        }

//        if(bundle == null){
//            tv_name.setText("请登录");
//            tv_name.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    Intent intent = new Intent(Activity_mine.this,LoginActivity.class);
//                    startActivityForResult(intent,1);
//                }
//            });
//        }

//        tv_name.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(Activity_mine.this,LoginActivity.class);
//                startActivity(intent);
//                finish();
//            }
//        });
    }
}