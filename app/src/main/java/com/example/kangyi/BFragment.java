package com.example.kangyi;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class BFragment extends Fragment {

    private RadioButton rb_total;
    private RadioGroup rg ;
    private ImageView iv ;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_guowai,container,false);
        rb_total = (RadioButton) view.findViewById(R.id.tatol);
        rb_total.setChecked(true);
        rg = (RadioGroup) view.findViewById(R.id.natarize);
        iv = (ImageView) view.findViewById(R.id.map);
        iv.setBackgroundResource(R.drawable.tatol);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton rb = (RadioButton) group.findViewById(checkedId);
                switch (rb.getId()){
                    case R.id.tatol:
                        iv.setBackgroundResource(R.drawable.tatol);
//                        iv.setScaleType(ImageView.ScaleType.FIT_CENTER);
                        break;
                    case R.id.now:
                        iv.setBackgroundResource(R.drawable.now);
//                        iv.setScaleType(ImageView.ScaleType.FIT_CENTER);
                        break;
                }
            }
        });
    }
}
