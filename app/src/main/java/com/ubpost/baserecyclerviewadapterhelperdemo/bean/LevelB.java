package com.ubpost.baserecyclerviewadapterhelperdemo.bean;

import com.chad.library.adapter.base.entity.AbstractExpandableItem;
import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.ubpost.baserecyclerviewadapterhelperdemo.adapter.Btn12Adapter;

/**
 * LevelB 是树形结构层级中的中间层
 * 需要继承AbstractExpandableItem<LevelC>，表明 LevelC 是 LevelB 中的子层级
 * Created by xinychan on 2017/9/20.
 */

public class LevelB extends AbstractExpandableItem<LevelC> implements MultiItemEntity {

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
        return Btn12Adapter.TYPE_LEVEL_B;
    }

    @Override
    public int getLevel() {
        //返回层级，最外面一层为LevelA，值为0，此处则值为1，表明不是最外层
        return 1;
    }
}
