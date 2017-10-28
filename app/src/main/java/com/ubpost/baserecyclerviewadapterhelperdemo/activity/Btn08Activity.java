package com.ubpost.baserecyclerviewadapterhelperdemo.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.ubpost.baserecyclerviewadapterhelperdemo.R;
import com.ubpost.baserecyclerviewadapterhelperdemo.adapter.Btn08Adapter;
import com.ubpost.baserecyclerviewadapterhelperdemo.bean.PersonSection;
import com.ubpost.baserecyclerviewadapterhelperdemo.utils.PersonSectionData;
import com.ubpost.baserecyclerviewadapterhelperdemo.view.DividerItemDecoration;

import java.util.List;

/**
 * BaseRecyclerViewAdapterHelper 的使用
 * 分组布局
 * 实体类必须继承SectionEntity
 */
public class Btn08Activity extends AppCompatActivity {

    private Btn08Activity activity;
    private RecyclerView recyclerView;
    private List<PersonSection> list;//具有分组功能的实例
    private Btn08Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_btn08);
        activity = this;
        recyclerView = (RecyclerView) findViewById(R.id.rev_Btn08Activity_show);
        recyclerView.setLayoutManager(new LinearLayoutManager(activity));
        list = PersonSectionData.initData_15();//具有分组功能的实例
        //参数：普通Item布局，分组Item布局，数据集合List
        adapter = new Btn08Adapter(R.layout.item_btn02, R.layout.item_head, list);
        recyclerView.setAdapter(adapter);
        recyclerView.addItemDecoration(new DividerItemDecoration(activity, DividerItemDecoration.VERTICAL_LIST));
    }
}
