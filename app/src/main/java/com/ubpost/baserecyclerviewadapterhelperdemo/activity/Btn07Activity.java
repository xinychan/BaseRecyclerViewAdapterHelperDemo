package com.ubpost.baserecyclerviewadapterhelperdemo.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.ubpost.baserecyclerviewadapterhelperdemo.R;
import com.ubpost.baserecyclerviewadapterhelperdemo.adapter.Btn07Adapter;
import com.ubpost.baserecyclerviewadapterhelperdemo.bean.Person;
import com.ubpost.baserecyclerviewadapterhelperdemo.utils.PersonData;
import com.ubpost.baserecyclerviewadapterhelperdemo.view.DividerItemDecoration;

import java.util.List;

/**
 * BaseRecyclerViewAdapterHelper 的使用
 * 下拉加载新数据/上拉加载更多
 * 注意：如果上拉结束后，下拉刷新需要再次开启上拉监听，可以使用setNewData方法填充数据。
 */
public class Btn07Activity extends AppCompatActivity {

    private Btn07Activity activity;
    private List<Person> data;
    private RecyclerView recyclerView;
    private Btn07Adapter adapter;

    private static final int TOTAL_COUNTER = 25;//List最多展现的值

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_btn07);
        activity = this;
        data = PersonData.initData_15();
        recyclerView = (RecyclerView) findViewById(R.id.rev_Btn07Activity_show);
        recyclerView.setLayoutManager(new LinearLayoutManager(activity));
        adapter = new Btn07Adapter(R.layout.item_btn02, data);
        recyclerView.setAdapter(adapter);
        recyclerView.addItemDecoration(new DividerItemDecoration(activity, DividerItemDecoration.VERTICAL_LIST));
        setLoadMore();
        setUpMore();
    }

    /**
     * 上拉加载更多
     */
    private void setLoadMore() {

        BaseQuickAdapter.RequestLoadMoreListener requestLoadMoreListener = new BaseQuickAdapter.RequestLoadMoreListener() {
            @Override
            public void onLoadMoreRequested() {
                //上拉加载时，允许同时进行下拉加载操作，这里不需要关闭下拉加载功能
                //adapter.setUpFetchEnable(false);
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
                    }
                }, 3000);
            }
        };
        adapter.setOnLoadMoreListener(requestLoadMoreListener, recyclerView);
    }

    /**
     * 下拉加载
     */
    private void setUpMore() {
        //开启下拉加载功能，不开启无法下拉加载
        adapter.setUpFetchEnable(true);
        BaseQuickAdapter.UpFetchListener upFetchListener = new BaseQuickAdapter.UpFetchListener() {
            @Override
            public void onUpFetch() {
                //下拉加载开启时，不能关闭上拉加载更多功能，否则报错
                //adapter.setEnableLoadMore(false);//下拉加载时，允许同时进行上拉加载更多操作
                //开启下拉加载动画
                adapter.setUpFetching(true);
                recyclerView.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        //添加数据到第一个Item
                        Person person = new Person();
                        person.setName("UpFetchingName");
                        person.setAge("UpFetchingAge");
                        adapter.addData(0, person);
                        //下拉加载完成，暂时停止下拉加载的进行，不停止则会一直继续加载
                        adapter.setUpFetching(false);
                        if (adapter.getData().size() > TOTAL_COUNTER) {
                            //数据满了，停止下拉加载
                            adapter.setUpFetchEnable(false);
                        }
                    }
                }, 500);
            }
        };
        adapter.setUpFetchListener(upFetchListener);
        //开始加载的位置，相当于从第几个Item开始预加载
        //adapter.setStartUpFetchPosition(3);
    }

}
