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
 * Adapter中控件的点击事件
 * Created by xinychan on 2017/9/19.
 */

public class Btn03Adapter extends BaseQuickAdapter<Person, BaseViewHolder> {

    public Btn03Adapter(@LayoutRes int layoutResId, @Nullable List<Person> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, Person item) {
        helper.setText(R.id.tv_btn02_name, item.getName());
        helper.setText(R.id.tv_btn02_age, item.getAge());
        //绑定控件的ID，然后Adapter中再设置setOnItemChildClickListener/setOnItemChildLongClickListener
        //注意：设置子控件的事件，如果不在adapter中绑定，点击事件无法生效，因为无法找到你需要设置的控件
        helper.addOnClickListener(R.id.tv_btn02_name);//点击事件
        helper.addOnClickListener(R.id.tv_btn02_age);
        helper.addOnLongClickListener(R.id.tv_btn02_name);//长按事件
        helper.addOnLongClickListener(R.id.tv_btn02_age);
    }
}
