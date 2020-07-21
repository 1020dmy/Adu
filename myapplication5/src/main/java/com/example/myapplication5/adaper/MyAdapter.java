package com.example.myapplication5.adaper;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myapplication5.R;
import com.example.myapplication5.bean.FuliBean;
import com.example.myapplication5.uitl.ImageLoader;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyAdapter extends RecyclerView.Adapter {
    private ArrayList<FuliBean.ResultsBean> mlist;
    private Context mcontext;

    public MyAdapter(ArrayList<FuliBean.ResultsBean> mlist, Context mcontext) {
        this.mlist = mlist;
        this.mcontext = mcontext;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = View.inflate(mcontext, R.layout.item, null);
        return new ViewHolder(inflate);
    }

    public interface On {
        void Click(int position);
    }
    private On on;

    public void setOn(On on) {
        this.on = on;
    }
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        FuliBean.ResultsBean fuliBean = mlist.get(position);
        ViewHolder holder1 = (ViewHolder) holder;
        //Glide.with(mcontext).load(fuliBean.getUrl()).into(holder1.image);
        ImageLoader.setIMage(mcontext, fuliBean.getUrl(), holder1.image);
        //ToastUtil.showLong("123");
        holder1.tv.setText(fuliBean.getUrl());
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
        public TextView tv;

        public ViewHolder(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.image = (ImageView) rootView.findViewById(R.id.image);
            this.tv = (TextView) rootView.findViewById(R.id.tv);
        }

    }
}
