package com.ubpost.baserecyclerviewadapterhelperdemo.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.ubpost.baserecyclerviewadapterhelperdemo.R;

/**
 * BaseRecyclerViewAdapterHelper 的使用
 * 1-添加依赖，以及maven { url "https://jitpack.io" }
 * 2-adapter 继承自BaseRecyclerViewAdapterHelper中的adapter
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private MainActivity activity;
    private Button btn01;
    private Button btn02;
    private Button btn03;
    private Button btn04;
    private Button btn05;
    private Button btn06;
    private Button btn07;
    private Button btn08;
    private Button btn09;
    private Button btn10;
    private Button btn11;
    private Button btn12;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        activity = this;
        initView();
        setOnClick();
    }

    private void setOnClick() {
        btn01.setOnClickListener(this);
        btn02.setOnClickListener(this);
        btn03.setOnClickListener(this);
        btn04.setOnClickListener(this);
        btn05.setOnClickListener(this);
        btn06.setOnClickListener(this);
        btn07.setOnClickListener(this);
        btn08.setOnClickListener(this);
        btn09.setOnClickListener(this);
        btn10.setOnClickListener(this);
        btn11.setOnClickListener(this);
        btn12.setOnClickListener(this);
    }

    private void initView() {
        btn01 = (Button) findViewById(R.id.btn_main_btn01);
        btn02 = (Button) findViewById(R.id.btn_main_btn02);
        btn03 = (Button) findViewById(R.id.btn_main_btn03);
        btn04 = (Button) findViewById(R.id.btn_main_btn04);
        btn05 = (Button) findViewById(R.id.btn_main_btn05);
        btn06 = (Button) findViewById(R.id.btn_main_btn06);
        btn07 = (Button) findViewById(R.id.btn_main_btn07);
        btn08 = (Button) findViewById(R.id.btn_main_btn08);
        btn09 = (Button) findViewById(R.id.btn_main_btn09);
        btn10 = (Button) findViewById(R.id.btn_main_btn10);
        btn11 = (Button) findViewById(R.id.btn_main_btn11);
        btn12 = (Button) findViewById(R.id.btn_main_btn12);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_main_btn01:
                toNextActivity(Btn01Activity.class);
                break;
            case R.id.btn_main_btn02:
                toNextActivity(Btn02Activity.class);
                break;
            case R.id.btn_main_btn03:
                toNextActivity(Btn03Activity.class);
                break;
            case R.id.btn_main_btn04:
                toNextActivity(Btn04Activity.class);
                break;
            case R.id.btn_main_btn05:
                toNextActivity(Btn05Activity.class);
                break;
            case R.id.btn_main_btn06:
                toNextActivity(Btn06Activity.class);
                break;
            case R.id.btn_main_btn07:
                toNextActivity(Btn07Activity.class);
                break;
            case R.id.btn_main_btn08:
                toNextActivity(Btn08Activity.class);
                break;
            case R.id.btn_main_btn09:
                toNextActivity(Btn09Activity.class);
                break;
            case R.id.btn_main_btn10:
                toNextActivity(Btn10Activity.class);
                break;
            case R.id.btn_main_btn11:
                toNextActivity(Btn11Activity.class);
                break;
            case R.id.btn_main_btn12:
                toNextActivity(Btn12Activity.class);
                break;
        }
    }

    private void toNextActivity(Class<?> cls) {
        Intent intent = new Intent(activity, cls);
        startActivity(intent);
    }
}
