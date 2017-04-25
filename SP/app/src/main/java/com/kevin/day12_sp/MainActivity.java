package com.kevin.day12_sp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        SharedPreferences sp = getSharedPreferences("Launcher",MODE_PRIVATE);
        boolean isFirst = sp.getBoolean("isFirst",true);
        if (isFirst){
            Intent intent = new Intent(this,GuideActivity.class);
            startActivity(intent);
            finish();
        }
        setContentView(R.layout.activity_main);



        findViewById(R.id.btn_save).setOnClickListener(this);
        findViewById(R.id.btn_read).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_save:
                save();
                break;
            case R.id.btn_read:
                read();
                break;
        }
    }

    private void read() {
        // 现在要将存储的信息提取出来
        SharedPreferences sp = getSharedPreferences("keeping",MODE_PRIVATE);
        // 获取信息时有两个参数
        // 第一个参数是key值
        // 第二个参数是默认值 就是如果没有从文件中提取出来信息,那么就用默认值给对象赋值
        boolean isFirst = sp.getBoolean("first?",false);
        String str = sp.getString("Wow","我是如果没有取到值的话,那么我就是默认值");
        float secondBoy = sp.getFloat("I am tired",0.3f);
        int wolfAndTiger = sp.getInt("How many times",99);

        Log.d("ok", isFirst + str + secondBoy + wolfAndTiger);
    }

    private void save() {
        // 初始化SP对象
        // 两个参数 第一个参数是存储的文件名字
        // 第二个参数是文件类型,MODE_PRIVATE意思为文件是私有化的
        // 外部的程序不可以访问
        // 这是为了保证安全
        SharedPreferences.Editor editor = getSharedPreferences("keeping",MODE_PRIVATE).edit();
        editor.putBoolean("first?",true);
        editor.putString("How long","18+18+18");
        editor.putInt("How many times",7);
        editor.putFloat("I am tired",0.1f);
        editor.putString("isFinish?","Feeling the body was emptied");

        // 加完数据 一定要提交!!!!!!!
        editor.commit();
        // 移除某一个值
        editor.remove("isFinish?").commit();
        // 清空 (记住一定要提交)
//        editor.clear();
//        editor.commit();
    }
}
