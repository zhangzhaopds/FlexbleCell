package com.tongxingpay.zhangzhao.flexblecell;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {

    private MyAdapter myAdapter;
    private RecyclerView mRecyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = (RecyclerView)findViewById(R.id.main_recyclerview);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        myAdapter = new MyAdapter();
        mRecyclerView.setAdapter(myAdapter);

    }
}
