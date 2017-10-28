package com.ubpost.baserecyclerviewadapterhelperdemo.bean;

import com.chad.library.adapter.base.entity.SectionEntity;

/**
 * 分组布局的实体类
 * 实体类必须继承SectionEntity
 * Created by xinychan on 2017/9/19.
 */
public class PersonSection extends SectionEntity<Person> {

    /**
     * 决定这个对象是否是分组的Item对象
     * @param isHeader 是否是分组的Item对象
     * @param header 可在分组Item展示的内容；也可以展示Person的其他字段
     */
    public PersonSection(boolean isHeader, String header) {
        super(isHeader, header);
    }

}
