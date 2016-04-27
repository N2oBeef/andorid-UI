package com.example.administrator.recyclerview;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Administrator on 2016/4/25.
 */
public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder>{

    private Context mContext;
    public Adapter(Context context)
    {
        this.mContext = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_main_recycle_item,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public int getItemCount() {
        return 50;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.title.setText("大大的标题");
        holder.content.setText("这是第 " + position + " 项………………");

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, MainActivity.class);
                mContext.startActivity(intent);
            }
        });

    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        private TextView title;
        private TextView content;
        public MyViewHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.tv_titlt);
            content = (TextView) itemView.findViewById(R.id.tv_content);
        }
    }
}
