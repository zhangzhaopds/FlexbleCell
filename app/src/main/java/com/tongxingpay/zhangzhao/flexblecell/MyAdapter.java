package com.tongxingpay.zhangzhao.flexblecell;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

/**
 * Created by zhangzhao on 23/11/2016.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> implements View.OnClickListener {

    @Override
    public int getItemCount() {
        return 20;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View cell = LayoutInflater.from(parent.getContext()).inflate(R.layout.cell_main_recyclerview, parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(cell);

        // 对每一个cell注册点击事件
        cell.setOnClickListener(this);

        // 取消viewHolder的重用机制（很重要）
        myViewHolder.setIsRecyclable(false);

        return myViewHolder;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        MyViewHolder(View view) {
            super(view);
        }
    }

    @Override
    public void onClick(View v) {

        int index;

        LinearLayout linearLayout = (LinearLayout)v.findViewById(R.id.cell_main_rootLayout);
        View subView = LayoutInflater.from(v.getContext()).inflate(R.layout.cell_main_recyclerview_add, (ViewGroup)v, false);

        // 利用cell控件的Tag值来标记cell是否被点击过,因为已经将重用机制取消，cell退出当前界面时就会被销毁，Tag值也就不存在了。
        // 如果不取消重用，那么将会出现未曾点击就已经添加子视图的效果，再点击的时候会继续添加而不是收回。
        if (v.findViewById(R.id.cell_main_rootLayout).getTag() == null) {
            index = 1;
        } else {
            index = (int)v.findViewById(R.id.cell_main_rootLayout).getTag();
        }

        Log.i("yichu", "onClick: " + index);

        // close状态: 添加视图
        if (index == 1) {
            linearLayout.addView(subView);
            subView.setTag(1000);
            v.findViewById(R.id.cell_main_rootLayout).setTag(2);
        } else {
            // open状态： 移除视图
            linearLayout.removeView(v.findViewWithTag(1000));
            v.findViewById(R.id.cell_main_rootLayout).setTag(1);
        }
    }
}
