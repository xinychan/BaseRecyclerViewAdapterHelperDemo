package com.ubpost.baserecyclerviewadapterhelperdemo.bean;

import com.chad.library.adapter.base.entity.MultiItemEntity;

/**
 * 多布局实体类
 * 实体类必须实现MultiItemEntity
 * 在设置数据的时候，需要给每一个数据设置itemType
 * Created by xinychan on 2017/9/19.
 */

public class PersonMultiItem implements MultiItemEntity {

    //实体类的不同类型
    public static final int BIG = 1;//类型1
    public static final int SMALL = 2;//类型2
    private int itemType;//类型编号
    private Person person;

    public PersonMultiItem(int itemType, Person person) {
        this.itemType = itemType;
        this.person = person;
    }

    public Person getPerson() {
        return person;
    }

    @Override
    public int getItemType() {
        return itemType;//返回类型编号
    }
}
