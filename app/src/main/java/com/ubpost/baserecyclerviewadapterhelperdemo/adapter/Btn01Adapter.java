package com.ubpost.baserecyclerviewadapterhelperdemo.adapter;

import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.ubpost.baserecyclerviewadapterhelperdemo.R;
import com.ubpost.baserecyclerviewadapterhelperdemo.bean.Person;

import java.util.List;

/**
 * BaseRecyclerViewAdapterHelper 的简单使用
 * 继承自BaseQuickAdapter，数据适配
 * Created by xinychan on 2017/9/18.
 */

public class Btn01Adapter extends BaseQuickAdapter<Person, BaseViewHolder> {

    /**
     * 传入 BaseViewHolder 的布局ID，以及对应的数据集合
     * @param layoutResId BaseViewHolder 的布局ID
     * @param data 数据集合DataList
     */
    public Btn01Adapter(@LayoutRes int layoutResId, @Nullable List<Person> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, Person item) {
        //给BaseViewHolder中的控件赋值
        //参数：控件的ID，给控件赋的值
        helper.setText(R.id.tv_btn01_text, item.getName());
    }
}
