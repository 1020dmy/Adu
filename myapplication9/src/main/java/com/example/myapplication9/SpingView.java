package com.example.myapplication9;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;

import java.util.ArrayList;

public class SpingView extends RelativeLayout {


    private EditText ed;
    private ImageView image;
    private ArrayList<String> list;
    private PopupWindow popupWindow;
    private ListView listView;
    private boolean b;

    public SpingView(Context context, AttributeSet attrs) {
        super(context, attrs);

        init();
        initView();
        initData();
        initListener();
    }


    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.sping,this);
    }

    private void initView() {
        ed = findViewById(R.id.ed);
        image = findViewById(R.id.image);
    }

    private void initData() {
        list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {

            list.add("你是"+i);

        }
    }
    private void initListener() {
        if (!b)
                listView = new ListView(getContext());
        image.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
        if (!b)
                popupWindow = new PopupWindow(listView, ed.getWidth(), 600);
                listView.setAdapter(new ArrayAdapter<String>(getContext(),android.R.layout.simple_list_item_1,list));
                popupWindow.setBackgroundDrawable(null);
                popupWindow.setOutsideTouchable(true);
                popupWindow.showAsDropDown(ed);
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String s = list.get(position);

                ed.setText(s);

                ed.setSelection(s.length());

                popupWindow.dismiss();
            }
        });

//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//
//                String s = list.get(position);
//
//                ed.setText(s);
//
//                ed.setSelection(s.length());
//
//                popupWindow.dismiss();
//            }
//        });
    }

}
