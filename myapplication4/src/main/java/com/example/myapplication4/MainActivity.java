package com.example.myapplication4;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myapplication4.utils.SpUtil;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText ed1;
    private EditText ed2;
    private Button but;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        ed1 = (EditText) findViewById(R.id.ed1);
        ed2 = (EditText) findViewById(R.id.ed2);
        but = (Button) findViewById(R.id.but);
        boolean param = (boolean) SpUtil.getParam("3", false);
        if (param){
        String o = (String) SpUtil.getParam("1", "");
        String p = (String) SpUtil.getParam("2", "");
        ed1.setText(o);
        ed2.setText(p);
        }
        but.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.but:
                String ed3 = ed1.getText().toString();
                String ed4 = ed2.getText().toString();
                SpUtil.setParam("3",true);
                SpUtil.setParam("1",ed3);
                SpUtil.setParam("2",ed4);
                break;
        }
    }

    private void submit() {
        // validate
        String ed1String = ed1.getText().toString().trim();
        if (TextUtils.isEmpty(ed1String)) {
            Toast.makeText(this, "ed1String不能为空", Toast.LENGTH_SHORT).show();
            return;
        }

        String ed2String = ed2.getText().toString().trim();
        if (TextUtils.isEmpty(ed2String)) {
            Toast.makeText(this, "ed2String不能为空", Toast.LENGTH_SHORT).show();
            return;
        }

        // TODO validate success, do something


    }
}
