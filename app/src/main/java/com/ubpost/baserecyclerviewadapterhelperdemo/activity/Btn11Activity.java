package com.ubpost.baserecyclerviewadapterhelperdemo.activity;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

import com.chad.library.adapter.base.BaseViewHolder;
import com.chad.library.adapter.base.callback.ItemDragAndSwipeCallback;
import com.chad.library.adapter.base.listener.OnItemDragListener;
import com.chad.library.adapter.base.listener.OnItemSwipeListener;
import com.ubpost.baserecyclerviewadapterhelperdemo.R;
import com.ubpost.baserecyclerviewadapterhelperdemo.adapter.Btn11Adapter;
import com.ubpost.baserecyclerviewadapterhelperdemo.bean.Person;
import com.ubpost.baserecyclerviewadapterhelperdemo.utils.PersonData;

import java.util.List;

/**
 * 添加拖拽、滑动删除
 * adapter需要继承BaseItemDraggableAdapter
 * 注意：
 * 默认不支持多个不同的 ViewType 之间进行拖拽，如果开发者有所需求：
 * 重写ItemDragAndSwipeCallback里的onMove()方法，return true即可
 */
public class Btn11Activity extends AppCompatActivity {

    private Btn11Activity activity;
    private List<Person> data;
    private RecyclerView recyclerView;
    private Btn11Adapter adapter;
    private ItemTouchHelper itemTouchHelper;//Item触摸Helper
    private ItemDragAndSwipeCallback itemDragAndSwipeCallback;////拖拽和滑动回调

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_btn11);
        activity = this;
        data = PersonData.initData_15();
        recyclerView = (RecyclerView) findViewById(R.id.rev_Btn11Activity_show);
        recyclerView.setLayoutManager(new LinearLayoutManager(activity));

        //Item拖拽监听器
        OnItemDragListener onItemDragListener = new OnItemDragListener() {
            @Override
            public void onItemDragStart(RecyclerView.ViewHolder viewHolder, int pos) {
                //拖拽开始
            }

            @Override
            public void onItemDragMoving(RecyclerView.ViewHolder source, int from, RecyclerView.ViewHolder target, int to) {
                //正在拖拽
            }

            @Override
            public void onItemDragEnd(RecyclerView.ViewHolder viewHolder, int pos) {
                //拖拽结束
            }
        };
        //画笔
        final Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setTextSize(20);
        paint.setColor(Color.BLACK);
        //Item滑动监听器
        OnItemSwipeListener onItemSwipeListener = new OnItemSwipeListener() {
            @Override
            public void onItemSwipeStart(RecyclerView.ViewHolder viewHolder, int pos) {
                //滑动开始
            }

            @Override
            public void clearView(RecyclerView.ViewHolder viewHolder, int pos) {
                //滑动删除
            }

            @Override
            public void onItemSwiped(RecyclerView.ViewHolder viewHolder, int pos) {
                //滑动过后
            }

            @Override
            public void onItemSwipeMoving(Canvas canvas, RecyclerView.ViewHolder viewHolder, float dX, float dY, boolean isCurrentlyActive) {
                //滑动过程
                //BaseViewHolder baseViewHolder = (BaseViewHolder) viewHolder;
                //这里会在滑动的背景绘制颜色
                canvas.drawColor(ContextCompat.getColor(activity, android.R.color.darker_gray));
                //canvas.drawText("Just some text", 0, 40, paint);
            }
        };
        //适配器设置
        adapter = new Btn11Adapter(R.layout.item_btn02,data);
        itemDragAndSwipeCallback = new ItemDragAndSwipeCallback(adapter);//拖拽和滑动回调
        itemTouchHelper = new ItemTouchHelper(itemDragAndSwipeCallback);//触摸Helper
        itemTouchHelper.attachToRecyclerView(recyclerView);//触摸Helper应用于recyclerView
        //设置拖拽移动的方向（从上/下/左/右滑动执行拖拽）；默认不设置时四个方向都可拖拽
        itemDragAndSwipeCallback.setDragMoveFlags(ItemTouchHelper.UP | ItemTouchHelper.DOWN);
        //设置滑动删除的方向（从上/下/左/右滑动执行删除）
        itemDragAndSwipeCallback.setSwipeMoveFlags(ItemTouchHelper.LEFT);//这里只允许从右向左滑时删除
        adapter.enableSwipeItem();//允许滑动Item
        adapter.setOnItemSwipeListener(onItemSwipeListener);//设置滑动监听器
        adapter.enableDragItem(itemTouchHelper);//允许拖拽Item
        adapter.setOnItemDragListener(onItemDragListener);//设置拖拽监听器
        recyclerView.setAdapter(adapter);//setAdapter
    }
}
