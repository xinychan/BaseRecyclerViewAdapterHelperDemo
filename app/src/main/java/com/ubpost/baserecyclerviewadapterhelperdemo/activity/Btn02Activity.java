package com.ubpost.baserecyclerviewadapterhelperdemo.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.ubpost.baserecyclerviewadapterhelperdemo.R;
import com.ubpost.baserecyclerviewadapterhelperdemo.adapter.Btn02Adapter;
import com.ubpost.baserecyclerviewadapterhelperdemo.bean.Person;
import com.ubpost.baserecyclerviewadapterhelperdemo.utils.PersonData;
import com.ubpost.baserecyclerviewadapterhelperdemo.view.DividerItemDecoration;

import java.util.List;

/**
 * BaseRecyclerViewAdapterHelper 的使用
 * Item的点击事件
 * 注意：如果有header的话需要处理一下position加上 headerlayoutcount
 * 如果需要在点击事件中获取其他子控件可以使用：
 * getViewByPosition(RecyclerView recyclerView, int position, @IdRes int viewId)
 */
public class Btn02Activity extends AppCompatActivity {

    private Btn02Activity activity;
    private List<Person> data;
    private RecyclerView recyclerView;
    private Btn02Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_btn02);
        activity = this;
        data = PersonData.initData_15();
        recyclerView = (RecyclerView) findViewById(R.id.rev_Btn02Activity_show);
        recyclerView.setLayoutManager(new LinearLayoutManager(activity));
        adapter = new Btn02Adapter(R.layout.item_btn02, data);
        recyclerView.setAdapter(adapter);
        recyclerView.addItemDecoration(new DividerItemDecoration(activity, DividerItemDecoration.VERTICAL_LIST));
        //item的点击事件
        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                Person person = (Person) adapter.getItem(position);
                String name = person.getName();
                Toast.makeText(activity, "点击了" + name, Toast.LENGTH_SHORT).show();
            }
        });
        //item的长按事件
        adapter.setOnItemLongClickListener(new BaseQuickAdapter.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(BaseQuickAdapter adapter, View view, int position) {
                Person person = (Person) adapter.getItem(position);
                String name = person.getName();
                Toast.makeText(activity, "长按了" + name, Toast.LENGTH_SHORT).show();
                return false;
            }
        });
    }
}
