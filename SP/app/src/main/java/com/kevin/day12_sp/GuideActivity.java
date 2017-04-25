package com.kevin.day12_sp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

public class GuideActivity extends AppCompatActivity {
    private ArrayList<View> data;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);

        // 我们要存储启动的状态(是不是第一次启动)
        SharedPreferences.Editor editor = getSharedPreferences("Launcher",MODE_PRIVATE).edit();
        editor.putBoolean("isFirst",false);
        editor.commit();


        data = new ArrayList<>();
        viewPager = (ViewPager) findViewById(R.id.vp);
        View view1 = getLayoutInflater().inflate(R.layout.viewone,null);
        View view2 = getLayoutInflater().inflate(R.layout.viewone,null);
        View view3 = getLayoutInflater().inflate(R.layout.viewone,null);

        data.add(view1);
        data.add(view2);
        data.add(view3);
        MyAdapter adapter = new MyAdapter(this);
        adapter.setData(data);
        viewPager.setAdapter(adapter);

        view3.findViewById(R.id.img).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(GuideActivity.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
