package com.ubpost.baserecyclerviewadapterhelperdemo.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.ubpost.baserecyclerviewadapterhelperdemo.R;
import com.ubpost.baserecyclerviewadapterhelperdemo.adapter.Btn09Adapter;
import com.ubpost.baserecyclerviewadapterhelperdemo.bean.PersonMultiItem;
import com.ubpost.baserecyclerviewadapterhelperdemo.utils.PersonMultiItemData;
import com.ubpost.baserecyclerviewadapterhelperdemo.view.DividerItemDecoration;

import java.util.List;

/**
 * BaseRecyclerViewAdapterHelper 的使用
 * 多布局
 * 1-实体类必须实现MultiItemEntity，在设置数据的时候，需要给每一个数据设置itemType
 * 2-Adapter 继承 BaseMultiItemQuickAdapter
 */
public class Btn09Activity extends AppCompatActivity {

    private Btn09Activity activity;
    private List<PersonMultiItem> list;//实体类实现了MultiItemEntity
    private RecyclerView recyclerView;
    private Btn09Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_btn09);
        activity = this;
        list = PersonMultiItemData.initData_15();
        recyclerView = (RecyclerView) findViewById(R.id.rev_Btn09Activity_show);
        recyclerView.setLayoutManager(new LinearLayoutManager(activity));
        adapter = new Btn09Adapter(list);
        recyclerView.setAdapter(adapter);
        recyclerView.addItemDecoration(new DividerItemDecoration(activity, DividerItemDecoration.VERTICAL_LIST));
    }
}
