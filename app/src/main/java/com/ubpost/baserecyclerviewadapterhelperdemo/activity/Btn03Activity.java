package com.ubpost.baserecyclerviewadapterhelperdemo.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.ubpost.baserecyclerviewadapterhelperdemo.R;
import com.ubpost.baserecyclerviewadapterhelperdemo.adapter.Btn03Adapter;
import com.ubpost.baserecyclerviewadapterhelperdemo.bean.Person;
import com.ubpost.baserecyclerviewadapterhelperdemo.utils.PersonData;
import com.ubpost.baserecyclerviewadapterhelperdemo.view.DividerItemDecoration;

import java.util.List;

/**
 * BaseRecyclerViewAdapterHelper 的使用
 * Item中控件的点击事件
 * 注意：设置子控件的事件，如果不在adapter中绑定，点击事件无法生效，因为无法找到你需要设置的控件
 * 注意：Item中子控件的设置了点击事件，则Item的点击事件则不再起作用
 * 注意：如果有header的话需要处理一下position加上 headerlayoutcount
 * 如果需要在点击事件中获取其他子控件可以使用：
 * getViewByPosition(RecyclerView recyclerView, int position, @IdRes int viewId)
 */
public class Btn03Activity extends AppCompatActivity {

    private Btn03Activity activity;
    private List<Person> data;
    private RecyclerView recyclerView;
    private Btn03Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_btn03);
        activity = this;
        data = PersonData.initData_15();
        recyclerView = (RecyclerView) findViewById(R.id.rev_Btn03Activity_show);
        recyclerView.setLayoutManager(new LinearLayoutManager(activity));
        adapter = new Btn03Adapter(R.layout.item_btn02, data);
        recyclerView.setAdapter(adapter);
        recyclerView.addItemDecoration(new DividerItemDecoration(activity, DividerItemDecoration.VERTICAL_LIST));
        //注意：设置子控件的事件，如果不在adapter中绑定，点击事件无法生效，因为无法找到你需要设置的控件
        //item中控件的点击事件
        adapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                switch (view.getId()) {
                    case R.id.tv_btn02_name:
                        Person person = (Person) adapter.getItem(position);
                        String name = person.getName();
                        Toast.makeText(activity, "点击了" + name, Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.tv_btn02_age:
                        Person person2 = (Person) adapter.getItem(position);
                        String age = person2.getAge();
                        Toast.makeText(activity, "点击了" + age, Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });
        //item中控件的长按事件
        adapter.setOnItemChildLongClickListener(new BaseQuickAdapter.OnItemChildLongClickListener() {
            @Override
            public boolean onItemChildLongClick(BaseQuickAdapter adapter, View view, int position) {
                switch (view.getId()) {
                    case R.id.tv_btn02_name:
                        Person person = (Person) adapter.getItem(position);
                        String name = person.getName();
                        Toast.makeText(activity, "长按了" + name, Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.tv_btn02_age:
                        Person person2 = (Person) adapter.getItem(position);
                        String age = person2.getAge();
                        Toast.makeText(activity, "长按了" + age, Toast.LENGTH_SHORT).show();
                        break;
                }
                //返回true，则长按后不附带点击
                //返回false，则长按后附带一次点击
                return true;
            }
        });
        //只要Adapter中有控件添加了点击监听器addOnClickListener/addOnLongClickListener
        //则会与setOnItemClickListener发生冲突，Item的点击事件被子控件的点击事件取代，Item的点击事件会失效
        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                Person person = (Person) adapter.getItem(position);
                String name = person.getName();
                Toast.makeText(activity, "触发Item点击:" + name, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
