package com.garsonzhang.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.garsonzhang.myandroid.R;

public class HomeActivity extends AppCompatActivity {

    TextView txt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        txt = (TextView) findViewById(R.id.txt_value);
        Button btn = (Button) findViewById(R.id.btn_test);
        btn.setOnClickListener(btnListerner);
    }

    View.OnClickListener btnListerner=new View.OnClickListener(){

        @Override
        public void onClick(View v) {
            txt.setText("这是初始化数据！Debug下修改");
        }
    };
}
