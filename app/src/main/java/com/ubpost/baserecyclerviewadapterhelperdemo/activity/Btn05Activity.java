package com.ubpost.baserecyclerviewadapterhelperdemo.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.ubpost.baserecyclerviewadapterhelperdemo.R;
import com.ubpost.baserecyclerviewadapterhelperdemo.adapter.Btn05Adapter;
import com.ubpost.baserecyclerviewadapterhelperdemo.bean.Person;
import com.ubpost.baserecyclerviewadapterhelperdemo.utils.PersonData;
import com.ubpost.baserecyclerviewadapterhelperdemo.view.DividerItemDecoration;

import java.util.List;

/**
 * BaseRecyclerViewAdapterHelper 的使用
 * 添加/删除头部和尾部
 */
public class Btn05Activity extends AppCompatActivity implements View.OnClickListener {

    private Btn05Activity activity;
    private List<Person> data;
    private RecyclerView recyclerView;
    private Btn05Adapter adapter;
    private Button btn_Btn05Activity_addHead;
    private Button btn_Btn05Activity_addFoot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_btn05);
        activity = this;
        setRecycleView();
        btn_Btn05Activity_addHead = (Button) findViewById(R.id.btn_Btn05Activity_addHead);
        btn_Btn05Activity_addFoot = (Button) findViewById(R.id.btn_Btn05Activity_addFoot);
        btn_Btn05Activity_addHead.setOnClickListener(this);
        btn_Btn05Activity_addFoot.setOnClickListener(this);
    }

    private void setRecycleView() {
        recyclerView = (RecyclerView) findViewById(R.id.rev_Btn05Activity_show);
        data = PersonData.initData_15();
        recyclerView.setLayoutManager(new LinearLayoutManager(activity));
        adapter = new Btn05Adapter(R.layout.item_btn02, data);
        recyclerView.setAdapter(adapter);
        recyclerView.addItemDecoration(new DividerItemDecoration(activity, DividerItemDecoration.VERTICAL_LIST));
        //开启动画(默认为渐显效果)
        adapter.openLoadAnimation();
        adapter.setOnItemLongClickListener(new BaseQuickAdapter.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(BaseQuickAdapter adapter, View view, int position) {
                //删除某一个item
                adapter.remove(position);
                adapter.notifyDataSetChanged();
                return true;
            }
        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_Btn05Activity_addHead://添加头布局
                final View viewHead = LayoutInflater.from(activity).inflate(R.layout.item_head, (ViewGroup) recyclerView.getParent(), false);
                adapter.addHeaderView(viewHead);
                View.OnClickListener onClickListener_head = new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        adapter.removeHeaderView(viewHead);//删除头部局
//                        adapter.removeAllHeaderView();//删除全部头部局
                    }
                };
                viewHead.setOnClickListener(onClickListener_head);
                break;
            case R.id.btn_Btn05Activity_addFoot://添加尾部局
                final View viewFoot = LayoutInflater.from(activity).inflate(R.layout.item_foot, (ViewGroup) recyclerView.getParent(), false);
                adapter.addFooterView(viewFoot);
                View.OnClickListener onClickListener_foot = new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        adapter.removeFooterView(viewFoot);//删除尾部局
//                        adapter.removeAllFooterView();//删除全部尾部局
                    }
                };
                viewFoot.setOnClickListener(onClickListener_foot);
                break;
        }
    }
}
