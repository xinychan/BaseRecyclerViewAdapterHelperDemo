package com.ubpost.baserecyclerviewadapterhelperdemo.adapter;

import android.view.View;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.ubpost.baserecyclerviewadapterhelperdemo.R;
import com.ubpost.baserecyclerviewadapterhelperdemo.bean.LevelA;
import com.ubpost.baserecyclerviewadapterhelperdemo.bean.LevelB;
import com.ubpost.baserecyclerviewadapterhelperdemo.bean.LevelC;

import java.util.List;

/**
 * 树形列表
 * 1-adapter需要继承BaseMultiItemQuickAdapter
 * 在构造里面addItemType绑定type和layout的关系
 * 2-不同层级下的实体类都需要实现MultiItemEntity，以达到层级联系的效果
 * 这里以LevelA，LevelB，LevelC 为例
 * Created by xinychan on 2017/9/20.
 */

public class Btn12Adapter extends BaseMultiItemQuickAdapter<MultiItemEntity, BaseViewHolder> {

    //不同层级实体类对应的类型
    public static final int TYPE_LEVEL_A = 0;
    public static final int TYPE_LEVEL_B = 1;
    public static final int TYPE_LEVEL_C = 2;

    public Btn12Adapter(List<MultiItemEntity> data) {
        super(data);
        //在构造里面addItemType绑定type和layout的关系
        addItemType(TYPE_LEVEL_A, R.layout.item_head);
        addItemType(TYPE_LEVEL_B, R.layout.item_foot);
        addItemType(TYPE_LEVEL_C, R.layout.item_btn02);
    }

    @Override
    protected void convert(final BaseViewHolder holder, MultiItemEntity item) {

        switch (holder.getItemViewType()) {
            case TYPE_LEVEL_A:
                //获取 LevelA 对象
                final LevelA levelA = (LevelA) item;
                holder.setText(R.id.tv_head_text, levelA.getName());
                //itemView点击事件，如果是展开的，则收缩；如果是收缩的，则展开
                holder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        int pos = holder.getAdapterPosition();
                        if (levelA.isExpanded()) {
                            collapse(pos);
                        } else {
                            expand(pos);
                            //开启所有菜单
                            //expandAll();
                        }
                    }
                });
                break;
            case TYPE_LEVEL_B:
                //获取 levelB 对象
                final LevelB levelB = (LevelB) item;
                holder.setText(R.id.tv_foot_text, levelB.getName());
                //itemView点击事件，如果是展开的，则收缩；如果是收缩的，则展开
                holder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        int pos = holder.getAdapterPosition();
                        if (levelB.isExpanded()) {
                            collapse(pos);
                        } else {
                            expand(pos);
                        }
                    }
                });
                break;
            case TYPE_LEVEL_C:
                //获取 levelC 对象
                final LevelC levelC = (LevelC) item;
                holder.setText(R.id.tv_btn02_name, levelC.getName());
                holder.setText(R.id.tv_btn02_age, levelC.getAge());
                //itemView点击事件
                holder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        //删除某一个item（添加和修改的思路是一样的）
                        //获取当前父级位置
                        int pos = getParentPosition(levelC);
                        if (pos != -1) {
                            //通过父级位置找到当前list，删除指定下级
                            ((LevelB) getData().get(pos)).removeSubItem(levelC);
                            //列表层删除相关位置的数据
                            getData().remove(holder.getLayoutPosition());
                            //更新视图
                            notifyItemRemoved(holder.getLayoutPosition());
                        }
                    }
                });
                break;
        }
    }
}
