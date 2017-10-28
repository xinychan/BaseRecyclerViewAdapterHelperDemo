package com.ubpost.baserecyclerviewadapterhelperdemo.adapter;

import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.ubpost.baserecyclerviewadapterhelperdemo.R;
import com.ubpost.baserecyclerviewadapterhelperdemo.bean.Person;

import java.util.List;

/**
 * BaseRecyclerViewAdapterHelper 的使用
 * 下拉加载新数据/上拉加载更多
 * Created by xinychan on 2017/9/19.
 */

public class Btn07Adapter extends BaseQuickAdapter<Person, BaseViewHolder> {

    public Btn07Adapter(@LayoutRes int layoutResId, @Nullable List<Person> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, Person item) {
        helper.setText(R.id.tv_btn02_name, item.getName());
        helper.setText(R.id.tv_btn02_age, item.getAge());
    }
}
