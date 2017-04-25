package com.kevin.day12_sp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText etName,etPsw;
    private CheckBox checkBox;
    private Button button;
    private SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etName = (EditText) findViewById(R.id.et_name);
        etPsw = (EditText) findViewById(R.id.et_pass);
        checkBox = (CheckBox) findViewById(R.id.checkbox_login);
        button = (Button) findViewById(R.id.btn_login);

        button.setOnClickListener(this);

        SharedPreferences preferences = getSharedPreferences("Login",MODE_PRIVATE);
        boolean isFirst = preferences.getBoolean("isFirst",false);
        if (isFirst){
            String name = preferences.getString("name","请输入账号");
            String psw = preferences.getString("psw", "请输入密码");
            etName.setText(name);
            etPsw.setText(psw);
            checkBox.setChecked(true);
        }

    }

    @Override
    public void onClick(View view) {
        login();
    }

    private void login() {
        editor = getSharedPreferences("Login",MODE_PRIVATE).edit();
        if (checkBox.isChecked()){
            String name = etName.getText().toString();
            String psw = etPsw.getText().toString();
            editor.putBoolean("isFirst",true);
            editor.putString("name",name);
            editor.putString("psw",psw);
            editor.commit();
        }else {
            editor.clear().commit();
        }
        Intent intent = new Intent(this,GuideActivity.class);
        startActivity(intent);
    }
}
