package com.example.kangyi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.util.zip.Inflater;

public class Activity_index extends AppCompatActivity {

    //    private Button btn_guoNei;
//    private Button btn_guoWai;
    private RadioGroup rg;
    private FrameLayout frameLayout;
    private AFragment aFragment;
    private BFragment bFragment;
    private ImageView iv_mine;
//    private boolean isLogged;
//    private String name;
    private Bundle bundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_index);

        bundle = getIntent().getExtras();

        rg = (RadioGroup) findViewById(R.id.rg);
        iv_mine = (ImageView) findViewById(R.id.mine);

        iv_mine.setScaleType(ImageView.ScaleType.FIT_XY);
        iv_mine.setBackgroundResource(R.drawable.mine);
        iv_mine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Activity_index.this,Activity_mine.class);
//                Bundle bundle1 = new Bundle();
//                bundle1.putBoolean("isLogged",isChecked);
//                if(bundle == null){
//                    bundle = new Bundle();
//                }
//                intent.putExtras(bundle);
//                startActivity(intent);
                if(bundle != null){
                    intent.putExtras(bundle);
                }else{
                    bundle = null;
                }
                startActivity(intent);
            }
        });

        aFragment = new AFragment();
        bFragment = new BFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.fl4fragment,aFragment).commitAllowingStateLoss();

//        FragmentManager fragmentManager = getSupportFragmentManager();
//        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {


            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                RadioButton rb = (RadioButton) group.findViewById(checkedId);
//                System.out.println(rb.getId());
                switch (rb.getId()) {
                    case R.id.guoNei:
                        if (aFragment == null) {
                            aFragment = new AFragment();
                        }
                        fragmentTransaction.replace(R.id.fl4fragment, aFragment);
                        break;
                    case R.id.guoWai:
                        if (bFragment == null) {
                            bFragment = new BFragment();
                        }
                        fragmentTransaction.replace(R.id.fl4fragment, bFragment);
                        break;
                }
                fragmentTransaction.commitAllowingStateLoss();

            }
        });
//            aFragment = new AFragment();
//            btn_change = (Button) findViewById(R.id.btn_changeFragment);
//            getSupportFragmentManager().beginTransaction().add(R.id.fl4fragment,aFragment).commitAllowingStateLoss();
//            btn_change.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    if(bFragment == null){
//                        bFragment = new BFragment();
//                        getSupportFragmentManager().beginTransaction().add(R.id.fl4fragment,bFragment).commitAllowingStateLoss();
//                    }
//                }
//            });
    }
}