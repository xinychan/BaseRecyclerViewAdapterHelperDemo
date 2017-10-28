package com.ubpost.baserecyclerviewadapterhelperdemo.adapter;

import com.chad.library.adapter.base.BaseItemDraggableAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.ubpost.baserecyclerviewadapterhelperdemo.R;
import com.ubpost.baserecyclerviewadapterhelperdemo.bean.Person;

import java.util.List;

/**
 * 添加拖拽、滑动删除
 * adapter需要继承BaseItemDraggableAdapter
 * Created by xinychan on 2017/9/19.
 */

public class Btn11Adapter extends BaseItemDraggableAdapter<Person, BaseViewHolder> {

    public Btn11Adapter(int layoutResId, List<Person> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, Person item) {
        helper.setText(R.id.tv_btn02_name, item.getName());
        helper.setText(R.id.tv_btn02_age, item.getAge());
    }
}
