package com.example.kangyi;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.Calendar;
import java.util.Date;

public class AFragment extends Fragment {

    private TextView update_time;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_guonei,container,false);
        update_time  = view.findViewById(R.id.update_date);
        Date date = new Date();
//        update_time.setText("数据更新至"+(1900+date.getYear())+"年"+(date.getMonth()+1)+"月"+date.getDay()+"日"+date.getHours()+"点");

        update_time.setText("数据更新至2020年12月30日 15:00");
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}
