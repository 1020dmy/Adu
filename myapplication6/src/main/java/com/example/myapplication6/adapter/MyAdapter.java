package com.example.myapplication6.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.bitmap.BitmapEncoder;
import com.example.myapplication6.R;
import com.example.myapplication6.bean.JavaBean;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyAdapter extends RecyclerView.Adapter {
    private ArrayList<JavaBean.T1348647909107Bean> mlist;
    private Context mcontext;
    public boolean b;



    public MyAdapter(ArrayList<JavaBean.T1348647909107Bean> mlist, Context mcontext) {
        this.mlist = mlist;
        this.mcontext = mcontext;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = View.inflate(mcontext, R.layout.item, null);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        final ViewHolder holder1= (ViewHolder) holder;
        final JavaBean.T1348647909107Bean bean = mlist.get(position);
        holder1.tv.setText(bean.getTitle());
        Glide.with(mcontext).load(bean.getImgsrc()).diskCacheStrategy(DiskCacheStrategy.RESOURCE).into(holder1.image);
        if (b){
            holder1.rg.setVisibility(View.VISIBLE);
        }
        if (!b){
            holder1.rg.setVisibility(View.INVISIBLE);
        }
       holder1.rg.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
           @Override
           public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
               bean.setBo(isChecked);
           }
       });
        if (bean.isBo()){
            holder1.rg.setChecked(true);
        }else {
            holder1.rg.setChecked(false);
        }
    }

    @Override
    public int getItemCount() {
        return mlist.size();
    }

    public
    class ViewHolder extends RecyclerView.ViewHolder {
        public View rootView;
        public ImageView image;
        public TextView tv;
        public CheckBox rg;

        public ViewHolder(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.image = (ImageView) rootView.findViewById(R.id.image);
            this.tv = (TextView) rootView.findViewById(R.id.tv);
            this.rg = (CheckBox) rootView.findViewById(R.id.ch);
        }

    }
}
