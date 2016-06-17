package com.example.yangdianwen.rcycleviewdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
/**
 * RecycleView 的使用，其adapter的必须继承RecycleView.adapter,
 * 而RecycleView.adapter必须传入一个ViewHolder
 */

public class MainActivity extends AppCompatActivity {
    private List<String> mDatas;
    private RecyclerView recyclerView;
    private HomeAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
        recyclerView = (RecyclerView) findViewById(R.id.id_recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this) );
        //注意setAdapter的adapter的类型必须使用viewhodler
        recyclerView.setAdapter(mAdapter=new HomeAdapter());
    }
    //初始化数据
    protected void initData()
    {
        mDatas = new ArrayList<String>();
        for (int i = 'A'; i < 'z'; i++)
        {
            mDatas.add("" + (char) i);
        }
    }
/**
 * homeAdapter的类，重写三个方法
 *  1创建viewholder onCreateViewHolder（）,
 *  2 绑定viewholder   onBindViewHolder(),
 *  3  获取数据大小  getItemCount(),
 */

    class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.MyViewHolder>
    {
      //onCreateViewHolder创建viewholder
      // 返回一个viewhodler的对象 把item的样式传到 new MyViewHolder（）去
        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
        {
            MyViewHolder holder = new MyViewHolder(LayoutInflater.from(
                    MainActivity.this).inflate(R.layout.item, parent,
                    false));
            return holder;
        }
        // 绑定viewholder时去设置item中控件
        @Override
        public void onBindViewHolder(MyViewHolder holder, int position)
        {
            holder.tv.setText(mDatas.get(position));
        }
        @Override
        public int getItemCount()
        {
            return mDatas.size();
        }
/**
 *
 *创建一个vihodler的类继承RecyclerView.ViewHolder
 */
        class MyViewHolder extends RecyclerView.ViewHolder
        {

            TextView tv;

            public MyViewHolder(View view)
            {
                super(view);
                //初始化item的控件
                tv = (TextView) view.findViewById(R.id.id_num);
            }
        }
    }
}
