package com.ubpost.baserecyclerviewadapterhelperdemo.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.ubpost.baserecyclerviewadapterhelperdemo.R;
import com.ubpost.baserecyclerviewadapterhelperdemo.adapter.Btn02Adapter;
import com.ubpost.baserecyclerviewadapterhelperdemo.adapter.Btn04Adapter;
import com.ubpost.baserecyclerviewadapterhelperdemo.bean.Person;
import com.ubpost.baserecyclerviewadapterhelperdemo.utils.PersonData;
import com.ubpost.baserecyclerviewadapterhelperdemo.view.DividerItemDecoration;

import java.util.List;

/**
 * BaseRecyclerViewAdapterHelper 的使用
 * 添加列表加载动画
 * 默认提供5种方法（渐显、缩放、从下到上，从左到右、从右到左）
 */
public class Btn04Activity extends AppCompatActivity {

    private Btn04Activity activity;
    private List<Person> data;
    private RecyclerView recyclerView;
    private Btn04Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_btn04);
        activity = this;
        data = PersonData.initData_50();
        recyclerView = (RecyclerView) findViewById(R.id.rev_Btn04Activity_show);
        recyclerView.setLayoutManager(new LinearLayoutManager(activity));
        adapter = new Btn04Adapter(R.layout.item_btn02, data);
        recyclerView.setAdapter(adapter);
        recyclerView.addItemDecoration(new DividerItemDecoration(activity, DividerItemDecoration.VERTICAL_LIST));
        //开启动画(默认为渐显效果)
//        adapter.openLoadAnimation();//默认为渐显效果
        adapter.openLoadAnimation(BaseQuickAdapter.ALPHAIN);//渐显效果
//        adapter.openLoadAnimation(BaseQuickAdapter.SCALEIN);//缩放效果
//        adapter.openLoadAnimation(BaseQuickAdapter.SLIDEIN_BOTTOM);//从下到上
//        adapter.openLoadAnimation(BaseQuickAdapter.SLIDEIN_LEFT);//从左到右
//        adapter.openLoadAnimation(BaseQuickAdapter.SLIDEIN_RIGHT);//从右到左
        //动画默认只执行一次,如果想重复执行可设置
//        adapter.isFirstOnly(false);
        //设置不显示动画数量；比如最初几个不进行动画
//        adapter.setNotDoAnimationCount(10);
    }
}
