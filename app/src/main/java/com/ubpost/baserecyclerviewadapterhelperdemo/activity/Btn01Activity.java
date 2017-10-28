package com.ubpost.baserecyclerviewadapterhelperdemo.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.ubpost.baserecyclerviewadapterhelperdemo.R;
import com.ubpost.baserecyclerviewadapterhelperdemo.adapter.Btn01Adapter;
import com.ubpost.baserecyclerviewadapterhelperdemo.bean.Person;
import com.ubpost.baserecyclerviewadapterhelperdemo.utils.PersonData;
import com.ubpost.baserecyclerviewadapterhelperdemo.view.DividerItemDecoration;

import java.util.List;

/**
 * BaseRecyclerViewAdapterHelper 的简单使用
 * 数据的适配
 */
public class Btn01Activity extends AppCompatActivity {

    private Btn01Activity activity;
    private List<Person> data;
    private RecyclerView recyclerView;
    private Btn01Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_btn01);
        activity = this;
        data = PersonData.initData_15();
        recyclerView = (RecyclerView) findViewById(R.id.rev_Btn01Activity_show);
        recyclerView.setLayoutManager(new LinearLayoutManager(activity));
        adapter = new Btn01Adapter(R.layout.item_btn01, data);
        recyclerView.setAdapter(adapter);
        recyclerView.addItemDecoration(new DividerItemDecoration(activity,DividerItemDecoration.VERTICAL_LIST));
    }
}
