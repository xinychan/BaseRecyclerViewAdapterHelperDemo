package com.ubpost.baserecyclerviewadapterhelperdemo.bean;

import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.ubpost.baserecyclerviewadapterhelperdemo.adapter.Btn12Adapter;

/**
 * LevelC 是树形结构层级中最内层
 * 不需要再继承AbstractExpandableItem
 * Created by xinychan on 2017/9/20.
 */

public class LevelC implements MultiItemEntity {

    private String name;
    private String age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    @Override
    public int getItemType() {
        //返回Adapter中对应的类型
        return Btn12Adapter.TYPE_LEVEL_C;
    }
}
