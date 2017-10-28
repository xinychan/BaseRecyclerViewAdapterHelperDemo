package com.ubpost.baserecyclerviewadapterhelperdemo.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.ubpost.baserecyclerviewadapterhelperdemo.R;
import com.ubpost.baserecyclerviewadapterhelperdemo.adapter.Btn12Adapter;
import com.ubpost.baserecyclerviewadapterhelperdemo.bean.LevelA;
import com.ubpost.baserecyclerviewadapterhelperdemo.bean.LevelB;
import com.ubpost.baserecyclerviewadapterhelperdemo.bean.LevelC;

import java.util.ArrayList;
import java.util.List;

/**
 * 树形列表
 * 1-adapter需要继承BaseMultiItemQuickAdapter
 * 2-不同层级下的实体类都需要实现MultiItemEntity，以达到层级联系的效果
 */
public class Btn12Activity extends AppCompatActivity {

    private Btn12Activity activity;
    private List<MultiItemEntity> list;
    private RecyclerView recyclerView;
    private Btn12Adapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_btn12);
        activity = this;
        list = generateData();
        recyclerView = (RecyclerView) findViewById(R.id.rev_Btn12Activity_show);
//        final GridLayoutManager manager = new GridLayoutManager(this, 3);
//        manager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
//            @Override
//            public int getSpanSize(int position) {
//                return adapter.getItemViewType(position) == Btn12Adapter.TYPE_LEVEL_C ? 1 : manager.getSpanCount();
//            }
//        });
        adapter = new Btn12Adapter(list);
        recyclerView.setAdapter(adapter);
        // important! setLayoutManager should be called after setAdapter
        //注意：setLayoutManager要在setAdapter之后执行
        recyclerView.setLayoutManager(new LinearLayoutManager(activity));
//        recyclerView.setLayoutManager(manager);
//        adapter.expandAll();//开启所有菜单
    }

    /**
     * 获取数据
     */
    private ArrayList<MultiItemEntity> generateData() {
        int lv0Count = 3;
        int lv1Count = 2;
        int lv2Count = 4;
        ArrayList<MultiItemEntity> list = new ArrayList<>();
        for (int i = 0; i < lv0Count; i++) {
            LevelA levelA = new LevelA();
            levelA.setName("LevelA_Name_" + i);
            levelA.setAge("LevelA_Age_" + i);
            for (int j = 0; j < lv1Count; j++) {
                //创建 levelB
                LevelB levelB = new LevelB();
                levelB.setName("LevelB_Name_" + j);
                levelB.setAge("LevelB_Age_" + j);
                for (int k = 0; k < lv2Count; k++) {
                    //创建 LevelC
                    LevelC levelC = new LevelC();
                    levelC.setName("LevelC_Name_" + k);
                    levelC.setAge("LevelC_Age_" + k);
                    //将 levelC 添加到 levelB 的子层级
                    levelB.addSubItem(levelC);
                }
                //将 levelB 添加到 levelA 的子层级
                levelA.addSubItem(levelB);
            }
            //levelA 添加到 list 中
            list.add(levelA);
        }
        return list;
    }
}
