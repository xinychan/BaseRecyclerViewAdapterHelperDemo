package com.ubpost.baserecyclerviewadapterhelperdemo.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.ubpost.baserecyclerviewadapterhelperdemo.R;
import com.ubpost.baserecyclerviewadapterhelperdemo.adapter.Btn02Adapter;
import com.ubpost.baserecyclerviewadapterhelperdemo.bean.Person;
import com.ubpost.baserecyclerviewadapterhelperdemo.utils.PersonData;
import com.ubpost.baserecyclerviewadapterhelperdemo.view.DividerItemDecoration;

import java.util.List;

/**
 * 设置空布局
 * mQuickAdapter.setEmptyView(getView());
 */
public class Btn10Activity extends AppCompatActivity implements View.OnClickListener {

    private Btn10Activity activity;
    private List<Person> list;
    private RecyclerView recyclerView;
    private Button btn_Btn10Activity_error;
    private Button btn_Btn10Activity_nodata;
    private Button btn_Btn10Activity_show;
    private Btn02Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_btn10);
        activity = this;
        list = PersonData.initData_15();
        btn_Btn10Activity_error = (Button) findViewById(R.id.btn_Btn10Activity_error);
        btn_Btn10Activity_nodata = (Button) findViewById(R.id.btn_Btn10Activity_nodata);
        btn_Btn10Activity_show = (Button) findViewById(R.id.btn_Btn10Activity_show);
        btn_Btn10Activity_error.setOnClickListener(this);
        btn_Btn10Activity_nodata.setOnClickListener(this);
        btn_Btn10Activity_show.setOnClickListener(this);
        recyclerView = (RecyclerView) findViewById(R.id.rev_Btn10Activity_show);
        recyclerView.setLayoutManager(new LinearLayoutManager(activity));
        adapter = new Btn02Adapter(R.layout.item_btn02, list);
        recyclerView.setAdapter(adapter);
        recyclerView.addItemDecoration(new DividerItemDecoration(activity, DividerItemDecoration.VERTICAL_LIST));
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_Btn10Activity_error:
                //网络错误的时候默认显示该布局
                View view_error = LayoutInflater.from(activity).inflate(
                        R.layout.layout_error, (ViewGroup) recyclerView.getParent(), false);
                adapter.setEmptyView(view_error);
                break;
            case R.id.btn_Btn10Activity_nodata:
                //没有数据的时候默认显示该布局
                View view_nodata = LayoutInflater.from(activity).inflate(
                        R.layout.layout_nodata, (ViewGroup) recyclerView.getParent(), false);
                adapter.setEmptyView(view_nodata);
                break;
            case R.id.btn_Btn10Activity_show:
                //赋空值展示
                adapter.setNewData(null);
                break;
        }
    }
}
