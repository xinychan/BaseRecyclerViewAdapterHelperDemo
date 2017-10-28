package com.ubpost.baserecyclerviewadapterhelperdemo.adapter;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.ubpost.baserecyclerviewadapterhelperdemo.R;
import com.ubpost.baserecyclerviewadapterhelperdemo.bean.PersonMultiItem;

import java.util.List;

/**
 * 多布局Adapter
 * 1-实体类必须实现MultiItemEntity
 * 2-Adapter 继承 BaseMultiItemQuickAdapter
 * 在构造里面addItemType绑定type和layout的关系
 * Created by xinychan on 2017/9/19.
 */
public class Btn09Adapter extends BaseMultiItemQuickAdapter<PersonMultiItem, BaseViewHolder> {

    public Btn09Adapter(List<PersonMultiItem> data) {
        super(data);
        //在构造里面addItemType绑定type和layout的关系
        addItemType(PersonMultiItem.BIG, R.layout.item_btn01);
        addItemType(PersonMultiItem.SMALL, R.layout.item_btn02);
    }

    @Override
    protected void convert(BaseViewHolder helper, PersonMultiItem item) {
        //对不同类型的对象，展示不同的布局界面
        switch (helper.getItemViewType()) {
            case PersonMultiItem.BIG:
                helper.setText(R.id.tv_btn01_text, item.getPerson().getName());
                break;
            case PersonMultiItem.SMALL:
                helper.setText(R.id.tv_btn02_name, item.getPerson().getName());
                helper.setText(R.id.tv_btn02_age, item.getPerson().getAge());
                break;
        }
    }
}
