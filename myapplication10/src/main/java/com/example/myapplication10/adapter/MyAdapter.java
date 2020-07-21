package com.example.myapplication10.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.myapplication10.R;
import com.example.myapplication10.bean.JavaBean;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyAdapter extends RecyclerView.Adapter {
    private Context mcontext;
    private ArrayList<JavaBean.BodyBean.ResultBean> mlist;

    public MyAdapter(Context mcontext, ArrayList<JavaBean.BodyBean.ResultBean> mlist) {
        this.mcontext = mcontext;
        this.mlist = mlist;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = View.inflate(mcontext, R.layout.item, null);
        return new ViewHolder(view);
    }
    public interface On{
        void Click(int position);
    }
    public On on;

    public void setOn(On on) {
        this.on = on;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        ViewHolder holder1 = (ViewHolder) holder;
        JavaBean.BodyBean.ResultBean javaBean = mlist.get(position);
        RequestOptions requestOptions = new RequestOptions().circleCrop();
        Glide.with(mcontext).load(javaBean.getTeacherPic()).apply(requestOptions).into(holder1.image);
        holder1.tv1.setText(javaBean.getTeacherName());
        holder1.tv3.setText(javaBean.getTitle());
        holder1.rootView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                on.Click(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mlist.size();
    }

    public static
    class ViewHolder extends RecyclerView.ViewHolder {
        public View rootView;
        public ImageView image;
        public TextView tv1;
        public TextView tv2;
        public TextView tv3;

        public ViewHolder(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.image = (ImageView) rootView.findViewById(R.id.image);
            this.tv1 = (TextView) rootView.findViewById(R.id.tv1);
            this.tv2 = (TextView) rootView.findViewById(R.id.tv2);
            this.tv3 = (TextView) rootView.findViewById(R.id.tv3);
        }

    }
}
