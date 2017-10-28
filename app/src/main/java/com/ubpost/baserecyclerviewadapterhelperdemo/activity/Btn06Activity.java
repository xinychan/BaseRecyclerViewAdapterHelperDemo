package com.ubpost.baserecyclerviewadapterhelperdemo.activity;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.ubpost.baserecyclerviewadapterhelperdemo.R;
import com.ubpost.baserecyclerviewadapterhelperdemo.adapter.Btn06Adapter;
import com.ubpost.baserecyclerviewadapterhelperdemo.bean.Person;
import com.ubpost.baserecyclerviewadapterhelperdemo.utils.PersonData;
import com.ubpost.baserecyclerviewadapterhelperdemo.view.DividerItemDecoration;

import java.util.ArrayList;
import java.util.List;

/**
 * BaseRecyclerViewAdapterHelper 的使用
 * 下拉刷新/上拉加载更多
 * 注意：如果上拉结束后，下拉刷新需要再次开启上拉监听，可以使用setNewData方法填充数据。
 */
public class Btn06Activity extends AppCompatActivity {

    private Btn06Activity activity;
    private List<Person> data;
    private RecyclerView recyclerView;
    private Btn06Adapter adapter;
    private SwipeRefreshLayout swipeRefreshLayout;

    private static final int TOTAL_COUNTER = 20;//List最多展现的值

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_btn06);
        activity = this;
        data = PersonData.initData_15();
        swipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.srl_Btn06Activity_refresh);
        recyclerView = (RecyclerView) findViewById(R.id.rev_Btn06Activity_show);
        recyclerView.setLayoutManager(new LinearLayoutManager(activity));
        adapter = new Btn06Adapter(R.layout.item_btn02, data);
        recyclerView.setAdapter(adapter);
        recyclerView.addItemDecoration(new DividerItemDecoration(activity, DividerItemDecoration.VERTICAL_LIST));
        setLoadMore();
        setRefreshData();
    }

    /**
     * 上拉加载更多
     */
    private void setLoadMore() {
        //加载更多监听器
        BaseQuickAdapter.RequestLoadMoreListener requestLoadMoreListener = new BaseQuickAdapter.RequestLoadMoreListener() {
            @Override
            public void onLoadMoreRequested() {
                //因为上拉下拉不能同时操作，所以上拉加载时要关闭刷新布局的刷新功能
                swipeRefreshLayout.setEnabled(false);
                recyclerView.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        //如果当前Item数目少于执行数目，则添加数据加载；否则加载完成
                        if (adapter.getData().size() < TOTAL_COUNTER) {
                            Person person = new Person();
                            person.setName("addLoadMore");
                            person.setAge("addLoadMore");
                            adapter.addData(person);//添加数据到列表最后；可添加单个数据或者list集合
                            //加载完成（注意不是加载结束，而是本次数据加载结束并且还有下页数据）
                            adapter.loadMoreComplete();
                            //加载失败；如网络异常时调用
                            //adapter.loadMoreFail();//提示“加载失败，请点我重试”
                        } else {
                            //数据全部加载完毕
                            //加载完成，提示“没有更多数据”；方法内部其实执行了loadMoreEnd(false)
                            adapter.loadMoreEnd();
                            //是否加载结束；
                            //adapter.loadMoreEnd(true);//结束了则停止下拉加载功能,不能再继续下拉
                            //adapter.loadMoreEnd(false);//还没结束，则提示“没有更多数据”
                        }
                        //上拉加载结束时要开启刷新布局的刷新功能
                        swipeRefreshLayout.setEnabled(true);
                    }
                }, 3000);
            }
        };
        //默认第一次加载会进入回调，如果不需要可以配置：
        //adapter.disableLoadMoreIfNotFullPage();
        //预加载:当列表滑动到倒数第N个Item的时候(默认是1)回调onLoadMoreRequested方法
        //adapter.setPreLoadNumber(2);
        //滑动最后一个Item的时候回调onLoadMoreRequested方法
        adapter.setOnLoadMoreListener(requestLoadMoreListener, recyclerView);
        //设置自定义加载布局；布局需要继承 LoadMoreView，重写里面的相关方法
        //adapter.setLoadMoreView(view);
    }

    /**
     * 刷新数据
     */
    private void setRefreshData() {
        SwipeRefreshLayout.OnRefreshListener onRefreshListener = new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                //因为上拉下拉不能同时操作，所以下拉刷新时要关闭上拉加载更多
                adapter.setEnableLoadMore(false);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        //setNewData，添加整个新的List到adapter中，取代原有List数据
                        //addData,数据添加到原列表最后
                        Person person = new Person();
                        person.setName("RefreshName");
                        person.setAge("RefreshAge");
                        List<Person> list = new ArrayList<>(20);
                        list.add(person);
                        list.addAll(PersonData.initData_15());
                        adapter.setNewData(list);
                        //刷新完成，关闭刷新动画
                        swipeRefreshLayout.setRefreshing(false);
                        //数据刷新后，要开启上拉加载更多
                        adapter.setEnableLoadMore(true);
                    }
                }, 3000);

            }
        };
        swipeRefreshLayout.setOnRefreshListener(onRefreshListener);
        //设置滑动条的颜色
        swipeRefreshLayout.setColorSchemeColors(ContextCompat.getColor(activity, R.color.colorAccent),
                ContextCompat.getColor(activity, android.R.color.holo_green_light),
                ContextCompat.getColor(activity, R.color.colorPrimary));
    }
}
