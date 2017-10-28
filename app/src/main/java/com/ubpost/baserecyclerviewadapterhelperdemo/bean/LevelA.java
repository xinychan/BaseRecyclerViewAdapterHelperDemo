package com.ubpost.baserecyclerviewadapterhelperdemo.bean;

import com.chad.library.adapter.base.entity.AbstractExpandableItem;
import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.ubpost.baserecyclerviewadapterhelperdemo.adapter.Btn12Adapter;

/**
 * LevelA 是树形结构层级中最外层
 * 需要继承AbstractExpandableItem<LevelB>，表明 LevelB 是 LevelA 中的子层级
 * Created by xinychan on 2017/9/20.
 */

public class LevelA extends AbstractExpandableItem<LevelB> implements MultiItemEntity {

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
        return Btn12Adapter.TYPE_LEVEL_A;
    }

    @Override
    public int getLevel() {
        //返回层级，LevelA 为最外层，值为0
        return 0;
    }
}
