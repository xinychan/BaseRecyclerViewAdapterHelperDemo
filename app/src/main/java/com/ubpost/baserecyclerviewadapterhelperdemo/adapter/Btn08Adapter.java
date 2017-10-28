package com.ubpost.baserecyclerviewadapterhelperdemo.adapter;

import com.chad.library.adapter.base.BaseSectionQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.ubpost.baserecyclerviewadapterhelperdemo.R;
import com.ubpost.baserecyclerviewadapterhelperdemo.bean.Person;
import com.ubpost.baserecyclerviewadapterhelperdemo.bean.PersonSection;

import java.util.List;

/**
 * BaseRecyclerViewAdapterHelper 的使用
 * 分组布局的Adapter
 * 1-实体类必须继承SectionEntity
 * 2-Adapter 继承 BaseSectionQuickAdapter
 * adapter构造需要传入两个布局id，第一个是item的，第二个是head 的，
 * 在convert方法里面加载item数据，在convertHead方法里面加载head数据
 */

public class Btn08Adapter extends BaseSectionQuickAdapter<PersonSection, BaseViewHolder> {

    /**
     * 分组布局的适配器
     *
     * @param layoutResId      普通Item布局
     * @param sectionHeadResId 分组Item布局
     * @param data             数据集合
     */
    public Btn08Adapter(int layoutResId, int sectionHeadResId, List<PersonSection> data) {
        super(layoutResId, sectionHeadResId, data);
    }

    /**
     * 设置分组Item布局数据
     * 如果是分组的，则会再分组的Item布局中展现
     */
    @Override
    protected void convertHead(BaseViewHolder helper, PersonSection item) {
//        helper.setText(R.id.tv_head_text, item.header);
        //也可展示Item中数据
        Person person = item.t;
        String name = person.getName();
        helper.setText(R.id.tv_head_text, name);

    }

    /**
     * 设置分组下List的数据
     */
    @Override
    protected void convert(BaseViewHolder helper, PersonSection item) {
        Person person = item.t;//获取PersonSection中的实例对象Person
        helper.setText(R.id.tv_btn02_name, person.getName());
        helper.setText(R.id.tv_btn02_age, person.getAge());
    }
}
